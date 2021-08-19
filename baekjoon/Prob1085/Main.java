package Prob1085;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] xywh = new int[4];
        ArrayList<Integer> udlr = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < xywh.length; i++)
            xywh[i] = sc.nextInt();

        //calculate up distance
        udlr.add(xywh[3] - xywh[1]);
        //down
        udlr.add(xywh[1] - 0);
        //left
        udlr.add(xywh[0] - 0);
        //right
        udlr.add(xywh[2] - xywh[0]);

        Collections.sort(udlr);
        System.out.println(udlr.get(0));
    }

}
