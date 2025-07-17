import pkg.QueuesLL.Queue;

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
        System.out.println(list.getSize());

        
        Stack stack = new Stack();
        stack.push(30);
        stack.push(20);
        stack.push(10); //Last in First Out
        
        
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
        
        System.out.println(stack.peek());*/


        Queue queue = new Queue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        while(!queue.isEmpty()){
            System.out.println(queue.dequeue());
        }
        System.out.println(queue.peek());

        

    }
}
