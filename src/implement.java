import Linked.LinkedList;

public class implement {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addFirst("a");
        list.addFirst("is");
        list.addLast("Linked List");
        list.addFirst("This"); 
        list.deleteLast();
        list.printList();
    }
}
