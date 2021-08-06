package baekjoon.prob2750;

import fastcampus.mergesort.QuickSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        ArrayList<Integer> iList = new ArrayList<>();

        int n = keyboard.nextInt();

        for(int i = 0; i < n; i++){
            int input = keyboard.nextInt();
            iList.add(input);
        }

        Main main = new Main();
        
        ArrayList<Integer> result = main.quickSort(iList);

        for(int i = 0; i < result.size(); i++)
            System.out.println(result.get(i));
    }
    
    public ArrayList<Integer> quickSort(ArrayList<Integer> list){
        
        if (list.size() <= 1)
            return list;
        
        int pivot = list.get(0);
        
        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();
        ArrayList<Integer> mergedArr = new ArrayList<>();
        
        for(int i = 1; i < list.size(); i++){
            if(list.get(i) < pivot)
                leftArr.add(list.get(i));
            else
                rightArr.add(list.get(i));
        }
        
        mergedArr.addAll(this.quickSort(leftArr));
        mergedArr.addAll(Arrays.asList(pivot));
        mergedArr.addAll(this.quickSort(rightArr));
        
        return mergedArr;
    }
}
