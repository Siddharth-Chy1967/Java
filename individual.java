import java.util.Arrays;
public class individual {
    public static void main(String[] args) {
        int[] num = {1,3,5,3,32,23,24,23};
        int[] maxMin = evenAndOdd(num);
        System.out.println(Arrays.toString(maxMin));
    }


    public static int[] evenAndOdd(int[] list){
        int evenCount = 0;
        int oddCount = 0;
        int[] count = new int[2];
        for(int values : list){
            if(values % 2 == 0){
                evenCount++;
            }
            else if(values % 2 != 0){
                oddCount++;
            }
        }

        count[0] = oddCount;
        count[1] = evenCount;
        return count;
    }
}
