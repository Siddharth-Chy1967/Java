package pkg;

public class QueuesLL{
    public static class Queue{
        Node head;
        public class Node{
            int data;
            Node next;

            Node(int data){
                this.data = data;
                this.next = null;
            }
        }
        public boolean isEmpty(){
            return head == null;
        }

        public void enqueue(int data){
            Node newNode = new Node(data);
            
            if(isEmpty()){
                head = newNode;
                return;
            }
            Node currNode = head;

            while(currNode.next != null){
                currNode = currNode.next;
            }
            currNode.next = newNode;
        }
        public int dequeue(){
            int top = head.data;

            if(isEmpty()){
                return -1;
            }
            head = head.next;
            return top;
        }

        public int peek(){
            
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }
    }
}