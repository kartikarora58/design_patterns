package hashMap;


interface Map<K,V>
{
    public V get(K key);
    public void put(K key,V value);
    public V delete(K key);
}
class Cars24HashMap<K,V> implements Map<K,V>{

    class Entry<K,V>{
        K key;
        V value;
        Entry<K,V> nextNode;

        Entry(K key, V value)
        {
            this.key = key;
            this.value = value;
            this.nextNode = null;
        }


    }
    Entry[] entry;
    int size;
    int currentSize = 0;
    Cars24HashMap()
    {
        this.size = 10;
        this.entry = new Entry[10];
    }

    public int getBucketNumber(K key)
    {
        int hashCode = key.hashCode();
        int index = hashCode%this.size;
        return index;
    }
    public void put(K key,V value)
    {
        int index = this.getBucketNumber(key);
        if(entry[index] == null)
        {
            this.currentSize++;
            entry[index]= new Entry<>(key,value);
        }
        else{
            Entry<K,V> currentNode = entry[index];
            Entry<K,V> prevNode = null;
            while(currentNode!=null)
            {
                if(currentNode.key.equals(key))
                {
                    currentNode.value = value;
                    return;
                }
                prevNode = currentNode;
                currentNode = currentNode.nextNode;
            }
            Entry<K,V> newNode = new Entry<>(key,value);
            prevNode.nextNode = newNode;

        }

    }

    public V get(K key)
    {
        int index = this.getBucketNumber(key);
        Entry<K,V> currentNode = entry[index];
        while(currentNode!=null)
        {
            if(currentNode.key.equals(key))
                return currentNode.value;

            currentNode = currentNode.nextNode;
        }
        System.out.println("key not present");
        return null;
    }

    public V delete(K key)
    {
        int index = this.getBucketNumber(key);
        Entry<K,V> currentNode = entry[index];
        Entry<K,V> prevNode = null;

        while(currentNode!=null)
        {
            if(currentNode.key.equals(key))
            {
                if(prevNode == null)
                {
                    entry[index] = currentNode.nextNode;
                }
                else{
                    prevNode.nextNode = currentNode.nextNode;
                }
                return currentNode.value;
            }
        }
        System.out.println("Key not present");
        return null;
    }
}

