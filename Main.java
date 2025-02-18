import java.util.Scanner;
public class Main {
    public static void main(String[] args){
       Scanner scnr = new Scanner(System.in);
       int[]arr = new int[10];
       int size =  0;
       System.out.println("Enter your numbers: ");
       while(scnr.hasNextInt()){
        if(size < arr.length){
            arr[size] = scnr.nextInt();
            size++;
        }
        System.out.println("Size is: " + size);
       }
    scnr.close();
    }
