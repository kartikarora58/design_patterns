import java.util.*;

//Requirements for consistent hashing algorithm
// assign server on ring and if two servers have same hashCode
// then add upcoming request to the newly assign server
// when a server is added the function should return the number of users request that server is assigned
// similarly when a server is removed it should return
public class ConsistentHashing {

    class Server{
        String serverName;
        Map<Integer,List<String>> usersMapping;
        Server(String serverName)
        {
            this.serverName = serverName;
            this.usersMapping = new HashMap<>();
        }
    }

    public void addUserToServer(TreeMap<Integer,List<Server>> serverMap,int serverHashCode,int hashCode,String userName)
    {
        List<Server> servers = serverMap.get(serverHashCode);
        Server server = servers.get(servers.size()-1);
        if(!server.usersMapping.containsKey(hashCode))
        {
            server.usersMapping.put(hashCode,new ArrayList<>());
        }
        server.usersMapping.get(hashCode).add(userName);

    }
    public int assignUser(TreeMap<Integer,List<Server>> serverMap,int hashCode,String userName)
    {
        Integer serverCeilId = serverMap.higherKey(hashCode);
        //if there is already a server at the user hashcode then assign it to this one
        if (serverMap.containsKey(hashCode))
        {
            this.addUserToServer(serverMap,hashCode,hashCode,userName);
            return hashCode;
        }
        // if there is ceil server then assign this user to this
        else if(serverCeilId !=null)
        {
            this.addUserToServer(serverMap,serverCeilId,hashCode,userName);
            return serverCeilId;
        }
        // assign this request to first server
        else{
            this.addUserToServer(serverMap,serverMap.firstKey(),hashCode,userName);
            return serverMap.firstKey();
        }

    }
    public int moveUsers(Server server,Server removedServer)
    {
        int count = 0;
        Map<Integer,List<String>> existingServerUsersMapping = server.usersMapping;
        for(Integer userId:removedServer.usersMapping.keySet())
        {
            if(!existingServerUsersMapping.containsKey(userId))
            {
                existingServerUsersMapping.put(userId,new ArrayList<>());
            }
            count+=removedServer.usersMapping.get(userId).size();
            existingServerUsersMapping.get(userId).addAll(removedServer.usersMapping.get(userId));

        }
        return count;
    }

    public int removeServer(TreeMap<Integer,List<Server>> serverMap,int hashCode,String serverName)
    {
        int count = 0;
        List<Server> servers = serverMap.get(hashCode);
        if(servers.size()>1)
        {
            Server removedServer = null;
            int position = -1;
            for(int i=0;i<servers.size();i++)
            {
                Server server = servers.get(i);
                if(server.serverName.equals(serverName))
                {
                    removedServer = server;
                    position = i;
                    break;
                }
            }
            if(position == servers.size()-1)
                position = servers.size()-2;
            else
                position = servers.size()-1;
            count = moveUsers(servers.get(position),removedServer);
            servers.remove(removedServer);
            return count;


        }
        Integer ceilServerId = serverMap.higherKey(hashCode);
        Integer floorServerId = serverMap.lowerKey(hashCode);
        Server removedServer = serverMap.get(hashCode).get(0);
        if(ceilServerId == null && floorServerId == null)
        {
            return 0;
        }
        if(ceilServerId == null)
        {
            servers = serverMap.get(serverMap.firstKey());
            Server server = servers.get(servers.size()-1);
            count = moveUsers(server,removedServer);
            serverMap.remove(hashCode);
            return count;
        }
        else{
            servers = serverMap.get(ceilServerId);
            Server server = servers.get(servers.size()-1);
            count = moveUsers(server,removedServer);
            serverMap.remove(hashCode);
            return count;
        }

    }

    public int addServer(TreeMap<Integer,List<Server>> serverMap,int hashCode,String serverName)
    {
        int count = 0;
        // if there is already a server at that hashCode then simply add new instance and there is no need to move data
        // because new request will be assigned to user
        if(serverMap.containsKey(hashCode))
        {
            serverMap.get(hashCode).add(new Server(serverName));
            return 0;
        }
        Server newServer = new Server(serverName);
        serverMap.put(hashCode,new ArrayList<>(Arrays.asList(newServer)));
        Integer ceilServerId = serverMap.higherKey(hashCode);
        Integer floorServerId = serverMap.lowerKey(hashCode);
        // if there is a ceil server greater than the new server
        // then move user from ceil server to new server having
        // hashCode less than or equals to new server
        if(ceilServerId!=null)
        {
            for(Server server:serverMap.get(ceilServerId))
            {
                Iterator<Integer> keyIterator = server.usersMapping.keySet().iterator();
                while(keyIterator.hasNext())
                {
                    Integer key = keyIterator.next();
                    if(key<=hashCode)
                    {
                        if(!newServer.usersMapping.containsKey(key))
                        {
                            newServer.usersMapping.put(key,new ArrayList<>());
                        }
                        count+=server.usersMapping.get(key).size();
                        newServer.usersMapping.get(key).addAll(server.usersMapping.get(key));
                        keyIterator.remove();
                    }
                }
            }
        }
        // if the newly added server doesn't has floor key then
        // it means is the first server in the row.
        // the users having hashcode greater than the hashCode of the last server
        // which are currently in ceil server will be transfer to this new sever
        // because assignment operation is in clockwise manner
        if(floorServerId == null && serverMap.lastKey()!=hashCode)
        {
            for(Server server:serverMap.get(ceilServerId))
            {
                Iterator<Integer> keyIterator = server.usersMapping.keySet().iterator();
                while(keyIterator.hasNext())
                {
                    Integer key = keyIterator.next();
                    if(key>serverMap.lastKey())
                    {
                        if(!newServer.usersMapping.containsKey(key))
                        {
                            newServer.usersMapping.put(key,new ArrayList<>());
                        }
                        count+=server.usersMapping.get(key).size();
                        newServer.usersMapping.get(key).addAll(server.usersMapping.get(key));
                        keyIterator.remove();
                    }
                }
            }
        }

    // if the newly added server does not have any ceil server means is the last server
        // then we willl move user of first server to this server whose hasecode is less than new server
        // but greater than the floor server
        if(ceilServerId==null && serverMap.firstKey()!=hashCode)
        {
            for(Server server:serverMap.get(serverMap.firstKey()))
            {
                Iterator<Integer> keyIterator = server.usersMapping.keySet().iterator();
                while(keyIterator.hasNext())
                {
                    Integer key = keyIterator.next();
                    if(key<=hashCode && key>floorServerId)
                    {
                        if(!newServer.usersMapping.containsKey(key))
                        {
                            newServer.usersMapping.put(key,new ArrayList<>());
                        }
                        count+=server.usersMapping.get(key).size();
                        newServer.usersMapping.get(key).addAll(server.usersMapping.get(key));
                        keyIterator.remove();
                    }
                }
            }
        }

        return count;

    }

    public int userHash(String username, int hashKey){
        int p = hashKey;
        int n = 360;
        long hashCode = 0;
        long p_pow = 1;
        char userArray[] = username.toCharArray();
        for (int i = 0; i < username.length(); i++) {
            char character = userArray[i];
            hashCode = (Long.valueOf(hashCode) + (character - 'A' + 1) * p_pow) % n;
            p_pow = (p_pow * p) % n;
        }
        return (int)hashCode;
    }
    public ArrayList<Integer> solve(ArrayList<String> A, ArrayList<String> B, ArrayList<Integer> C) {
        int n = A.size();
        ArrayList<Integer> ans = new ArrayList<>();
        TreeMap<Integer,List<Server>> serverMap = new TreeMap<>();
        Map<String,Integer> serverToHashMap = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            String operation = A.get(i);
            String key = B.get(i);
            int hashCode = userHash(key,C.get(i));
            if(operation.equals("ADD"))
            {
                serverToHashMap.put(key,hashCode);
                ans.add(this.addServer(serverMap,hashCode,key));
            }
            else if(operation.equals("REMOVE"))
            {
                hashCode = serverToHashMap.get(key);
                ans.add(this.removeServer(serverMap,hashCode,key));
                serverToHashMap.remove(key);
            }
            else{
                ans.add(this.assignUser(serverMap,hashCode,key));
            }
            System.out.println(hashCode);
            System.out.println(ans);
        }
        return ans;

    }

    public static void main(String[] args) {
        ArrayList<String> A = new ArrayList<>(Arrays.asList("ADD","ASSIGN","ASSIGN","ASSIGN","ADD","ASSIGN","ASSIGN","ASSIGN","ADD","ASSIGN","ASSIGN","ASSIGN","ADD","ASSIGN","ASSIGN","ASSIGN","REMOVE","ASSIGN","ASSIGN","ASSIGN","REMOVE","ASSIGN","ASSIGN","ASSIGN","REMOVE","ASSIGN","ASSIGN"));
        ArrayList<String> B = new ArrayList<>(Arrays.asList("INDIA","GYQF","SSAH","DVTQ","RUSSIA","ZIVQ","VBWW","ACDW","CHINA","YNXC","MWUN","NECZ","GERMANY","OOHQ","RSTZ","WRJJ","INDIA","YLDR","XDFH","SCCV","RUSSIA","QECH","WPCA","ZLVQ","CHINA","RQPJ","PFWJ"));
        ArrayList<Integer> C = new ArrayList<>(Arrays.asList(947,613,821,701,193,683,19,467,503,347,433,887,971,587,509,283,-1,359,443,883,-1,487,853,223,-1,13,739));
        System.out.println(new ConsistentHashing().solve(A,B,C));

    }
}
