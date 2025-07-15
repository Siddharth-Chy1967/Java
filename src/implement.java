import pkg.StackClass.Stack;

public class implement {
    public static void main(String[] args) {
        /*LinkedList list = new LinkedList();
        list.addFirst("a");
        list.addFirst("is");
        list.addLast("Linked List");
        list.addFirst("This");
        list.printList(); 
        System.out.println(list.getSize());
        list.deleteLast();
        list.printList();
        System.out.println(list.getSize());*/


        Stack stack = new Stack();
        stack.push(30);
        stack.push(20);
        stack.push(10);
        
        
        while(!stack.isEmpty()){
            System.out.println(stack.peek());
            stack.pop();
        }
        
        System.out.println(stack.peek());
    }
}
