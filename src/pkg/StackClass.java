package pkg;



public class StackClass{

    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static class Stack{
        Node head;

        public boolean isEmpty(){
            return head == null;
        }

        public void push(int data){
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        public int pop(){
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