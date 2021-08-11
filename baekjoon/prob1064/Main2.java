package prob1064;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Pair[] arr = new Pair[3];
        ArrayList<Double> lenList = new ArrayList<>();

        for (int i = 0; i < 3; i++){
            arr[i] = new Pair(sc.nextInt(), sc.nextInt());
        }

        if ((arr[1].y - arr[0].y) * (arr[2].x - arr[1].x) == (arr[1].x - arr[0].x) * (arr[2].y - arr[1].y))
            System.out.println(-1.0);
        else{
            Double side1 = Math.sqrt(Math.pow(arr[1].x - arr[0].x, 2) + Math.pow(arr[1].y - arr[0].y, 2));
            Double side2 = Math.sqrt(Math.pow(arr[2].x - arr[1].x, 2) + Math.pow(arr[2].y - arr[1].y, 2));
            Double side3 = Math.sqrt(Math.pow(arr[2].x - arr[0].x, 2) + Math.pow(arr[2].y - arr[0].y, 2));

            lenList.add(side1 + side2);
            lenList.add(side3 + side2);
            lenList.add(side3 + side1);

            Collections.sort(lenList);

            System.out.println(2 * (lenList.get(2) - lenList.get(0)));
        }
    }

    static public class Pair {
        int x;
        int y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
