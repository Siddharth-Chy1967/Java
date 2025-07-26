import java.util.Arrays;
import java.util.Random;

public class individual {

    public static void main(String[] args) {
        int [] arr = new int[15];
        int size = 0;
        Random rndm = new Random();

        for(int i = 0; i < 8; i++){
            arr[i] = rndm.nextInt(9);
            size++;
        }
        System.out.println("\n" + Arrays.toString(arr) + size);
        //adding a new element at 4th index(undordered)
        

        arr[4] = (int)(Math.random() * 2);    
        System.out.println("\n" + Arrays.toString(arr) + size);
        size = 0;
        //ordered
        for(int i = 0; i < 8; i++){
            arr[i] = i * 2;
            size++;
        }
        System.out.println("\n" + Arrays.toString(arr) + size);
        

//insert at 4th index for ordered [0, 2, 4, (6),^ (8), 10, 12, 14, (empty 8th)...], size = 8
        int index = 4;
        for(int i = size; i >= index; --i){
            arr[i] = arr [i - 1];
        }
        arr [index] = 7;
        size++;
        System.out.println('\n' + Arrays.toString(arr) + size);

        //removing from 5th index[0, 2, 4, 6, 7, (8), 10, 12, 14, ...]9
        index = 5;
        for(int i = index; i < size; ++i){
            arr[i] = arr[i + 1];
        }
        size--;

        System.out.println('\n' + Arrays.toString(arr) + size);
    }
}