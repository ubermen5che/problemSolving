package prob4153;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> result = new ArrayList<>();

        String input = bf.readLine();
        StringTokenizer st1 = new StringTokenizer(input);

        while(!input.equals("0 0 0")){

            ArrayList<Double> abc = new ArrayList<>();

            abc.add(Double.parseDouble(st1.nextToken()));
            abc.add(Double.parseDouble(st1.nextToken()));
            abc.add(Double.parseDouble(st1.nextToken()));

            Collections.sort(abc);

            input = bf.readLine();
            st1 = new StringTokenizer(input);
            if (Math.pow(abc.get(2),2) == Math.pow(abc.get(0),2) + Math.pow(abc.get(1),2))
                result.add("right");
            else
                result.add("wrong");
        }

        for (String r : result){
            System.out.println(r);
        }

    }
}
