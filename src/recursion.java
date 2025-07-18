

public class recursion {
   
    public static void printNum(int i){
        if(i == 5){
            return;
        }
        System.out.println(i);
        i++;
        printNum(i);
    }

    public static void main(String[] args) {
        printNum(5);
    }
}
