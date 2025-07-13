package Linked;

public class LinkedList {
    Node head;

    class Node{
        String data;
        Node next;

        Node(String data){
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }

        Node currNode = head;

        while(currNode.next != null){
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    public void printList(){
        if(head == null){
            System.out.println("List be empty gang.");
            return;
        }
        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data + " -> " );
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    public void deleteFirst(){
        if(head == null){
            System.out.println("head empty");
        }

        head = head.next;
    }

    public void deleteLast(){
        if(head == null){
            System.out.println("head empty");
        }
        
        if(head.next == null){  /*corner case
                                if only one node in list */
            head = null;
        }
        
        Node secondLastNode = head;
        Node lastNode = head.next;

        while(lastNode.next != null){
            secondLastNode = secondLastNode.next;
            lastNode = lastNode.next;
        }
        secondLastNode.next = null;
    }
}
