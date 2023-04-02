public class Sample {
    static class Node{
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
        }
    }
    static class LinkedList{
        Node head;
        Node tail;
    }
    public static void add(Node head,Node tail,Node node)
    {
        if(head == null)
        {
            head = node;
            tail = node;
        }
        else
        {
            tail.next = node;
            tail = node;
        }

    }

    public static void merge(Node head,Node tail,Node tempHead,Node tempTail)
    {
        if(head == null)
        {
            head = tempHead;
            tail = tempTail;
        }
        else{
            tail.next = tempHead;
            tail = tempTail;
        }
    }
    static Node divide(int N, Node head){
        Node evenHead = null;
        Node evenTail = null;

        Node oddHead = null;
        Node oddTail = null;

        while(head!=null)
        {
            if((head.data&1) == 0)
            {
                if(evenHead == null)
                {
                    evenHead = head;
                    evenTail = head;
                }
                else{
                    evenTail.next = head;
                    evenTail = head;
                }
            }
            else{
                if(oddHead == null)
                {
                    oddHead = head;
                    oddTail = head;
                }
                else{
                    oddTail.next = head;
                    oddTail = head;
                }
            }

            head = head.next;
        }

        if(oddHead == null)
            return evenHead;
        else if(evenHead == null)
            return oddHead;
        else{
            evenTail.next = oddHead;
            return evenHead;
        }


    }
    public static void main(String[] args) {

        LinkedList ob = new LinkedList();
        int arr[]= {8,2,4,6,17,15,9};
        for(int item:arr)
        {
            Node temp = new Node(item);
            if(ob.head == null)
            {
                ob.head = temp;
                ob.tail = temp;
            }
            else
            {
                ob.tail.next = temp;
                ob.tail = temp;
            }
        }

        System.out.println(divide(7,ob.head));

    }
}
