package pkg;
import java.util.ArrayList;

public class QueuesAL {

    public static class Queue{
        ArrayList<Integer> list = new ArrayList<>();
        public boolean isEmpty(){
            return list.isEmpty();
        }
        
        public void enqueue(int data){
            list.add(data);
        }

        public int dequeue(){
            int top = list.get(0);
            
            if(isEmpty()){
                return -1;
            }
            list.remove(0);
            
            return top;
        }

        public int peek(){
            
            if(isEmpty()){
                return -1;
            }

            return list.get(0);
        }
    }
}
