import Linked.*;

public class implement {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addFirst("a");
        list.addFirst("is");
        list.addLast("Linked List");
        list.addFirst("This");
        list.printList(); 
        System.out.println(list.getSize());
        list.deleteLast();
        list.printList();
        System.out.println(list.getSize());
    }
}
