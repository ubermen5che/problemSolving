package baekjoon;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.math.BigInteger;

public class Main {
    private static int arraySize = 2;
    private ArrayList<String> colorList;
    private ArrayList<Integer> valueList;
    private ArrayList<Integer> pdValueList;
    public HashMap<String, Integer> colorValue;

    public static void main(String[] args)  {
        Main cr = new Main();
        Scanner keyboard = new Scanner(System.in);
        String twoColor;

        ArrayList<String> input = new ArrayList<>();

        for(int i = 0; i < 3; i++){
            input.add(keyboard.next());
        }

        twoColor = Integer.toString(cr.colorValue.get(input.get(0))) + Integer.toString(cr.colorValue.get(input.get(1)));

        BigInteger left = new BigInteger(twoColor);
        BigInteger right = new BigInteger(Integer.toString(cr.pdValueList.get(cr.colorValue.get(input.get(2)))));

        BigInteger result = left.multiply(right);

        System.out.println(result);
    }

    public Main() {
        this.colorValue = new HashMap<String, Integer>();
        this.colorList = new ArrayList<String>(10);
        this.valueList = new ArrayList<>(10);
        this.pdValueList = new ArrayList<>(10);

        this.setColor(this.colorList);
        this.setValue(this.valueList, this.pdValueList);
        this.stubHashMap();
    }

    public void stubHashMap(){
        for(int i = 0; i < 10; i++)
            this.colorValue.put(this.colorList.get(i), i);
    }

    public void setColor(ArrayList<String> color){
        color.add("black");
        color.add("brown");
        color.add("red");
        color.add("orange");
        color.add("yellow");
        color.add("green");
        color.add("blue");
        color.add("violet");
        color.add("grey");
        color.add("white");
    }

    public void setValue(ArrayList<Integer> valueList, ArrayList<Integer> pdValueList){
        for(int i = 0; i < 10; i++){
            valueList.add(i);
            pdValueList.add((int)Math.pow(10, i));
        }
    }
}
