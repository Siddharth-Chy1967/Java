import java.util.Scanner;
import java.util.ArrayList;
import java.util.Array;

public class Main{
    public static ArrayList<Integer> allLessThanMean(ArrayList<Integer> list){
        int sum = 0;
        double mean = 0;
        ArrayList<Integer> allLess = new ArrayList<>();
        for(int values : list){
            sum += values;
        }
        mean = sum / list.size();

        for(int values : list){
            if(mean > values){
                allLess.add(values);
            }
        }
        
        return values;
    }
    
    
    public static ArrayList<Double> distancesFromMean(ArrayList<Integer> list){
        int sum = 0;
        double mean = 0;
        
        ArrayList<Double> distances = new ArrayList<>();

        for(int values : list){
            sum += values;
        }
        mean = sum/ list.size();

        for(int values : list){
            double distance = Math.abs(mean - values);
            distances.add(distance);
        }
    }
    
    public static ArrayList<Integer> intersect(ArrayList<Integer> list1, ArrayList<Integer> list2){
    ArrayList<Integer> duplicates = new ArrayList<>();
    for (int i : list1){
        if(list2.contains(i) && !duplicates.contains(i)){
            duplicates.add(i);
        }
    }
    return duplicates; 
}

    public static ArrayList<Integer> symmetricDiff(ArrayList<Integer> list1,ArrayList<Integer> list2){
        ArrayList<Integer> symmetricDiff = new ArrayList<>();
        for(int values : list1){
            if(!list2.contains(values) && !list2.contains(values)){
                symmetricDiff.add(values);
            }
        }
        for(int values : list2){
            if(!list1.contains(values) && !symmetricDiff.contains(values)){
                symmetricDiff.add(values);
            }
        }
        return symmetricDiff;
        }

    public static ArrayList<Integer> mergeSorted(ArrayList<Integer> list1, ArrayList<Integer> list2){
        int index1 = 0;
        int index2 = 0;

        ArrayList<Integer> sorted = new ArrayList<>();

        while(index1 < list1.size() && index2 < list2.size()){
            if(list1.get(index1) < list2.get(index2)){
                sorted.add(list1.get(index1));
                index1++;
            }
            else if(list1.get(index1) > list2.get(index2)){
                sorted.add(list2.get(index2));
            }
        }
    }

    public static void main(String[] args) {
        
    }
}