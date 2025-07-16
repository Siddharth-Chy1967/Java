package pkg;

import java.util.ArrayList;

public class StackAL{
    
    public static class Stack{
    int data = 0;

    public Stack(){
        this.data = 0;
    }
    
    ArrayList<Integer> list = new ArrayList<>();

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void push(int data){
        list.add(data);
    }

    public int pop(){
        int top = list.get(list.size() - 1);
        
        if (isEmpty()){
            return -1;
        }
        
        list.remove(list.size() -1);

        return top;
    }
    
    public int peek(){
        if (isEmpty()){
            return -1;
        }

        return list.size() - 1;
    }
    }
}