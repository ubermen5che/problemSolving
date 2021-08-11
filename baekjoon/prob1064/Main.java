package prob1064;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        HashMap<String, Integer> xy = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String delimiter = " ";

        String input = sc.nextLine();
        StringTokenizer st = new StringTokenizer(input, delimiter);
        int numOfToken = st.countTokens();

        for (int i = 0; i < numOfToken; i++)
        {
            if (i == 0)
                xy.put("xA", Integer.parseInt(st.nextToken()));
            else if(i == 1)
                xy.put("yA", Integer.parseInt(st.nextToken()));
            else if(i == 2)
                xy.put("xB", Integer.parseInt(st.nextToken()));
            else if(i == 3)
                xy.put("yB", Integer.parseInt(st.nextToken()));
            else if(i == 4)
                xy.put("xC", Integer.parseInt(st.nextToken()));
            else if(i == 5)
                xy.put("yC", Integer.parseInt(st.nextToken()));
        }

        boolean isTriangle = isTriangle(xy.get("xA"), xy.get("xB"), xy.get("xC"), xy.get("yA"),
                xy.get("yB"), xy.get("yC"));

        if (isTriangle){
            ArrayList<BigDecimal> distanceList = getDistanceList(xy.get("xA"), xy.get("xB"), xy.get("xC"), xy.get("yA"),
                    xy.get("yB"), xy.get("yC"));

            Collections.sort(distanceList);

            ArrayList<BigDecimal> sqList = new ArrayList<>();
            sqList.add(calculateRound(distanceList.get(2), distanceList.get(1)));
            sqList.add(calculateRound(distanceList.get(2), distanceList.get(0)));
            sqList.add(calculateRound(distanceList.get(1), distanceList.get(0)));

            Collections.sort(sqList);
            BigDecimal result = sqList.get(2).subtract(sqList.get(0));
            System.out.printf("%.15f", result);
        }
        else{
            double notTriangle = -1.0;
            System.out.println(notTriangle);
        }
        //System.out.println(calculateDistance(xy.get("xB"), xy.get("xC"), xy.get("yB"), xy.get("yC")));
    }

    private static ArrayList<Double> getExceptMaxDistanceList(ArrayList<Double> distanceList, Double maxDistance) {
        ArrayList<Double> eList = new ArrayList<>();

        for (int i = 0; i < distanceList.size(); i++){
            if (distanceList.get(i).doubleValue() != maxDistance.doubleValue())
                eList.add(distanceList.get(i));
        }

        return eList;
    }

    public static boolean isTriangle(int x1, int x2, int x3, int y1, int y2, int y3){

        ArrayList<BigDecimal> distanceList;

        distanceList = getDistanceList(x1, x2, x3, y1, y2, y3);

        BigDecimal maxDistance = getMaxDistance(distanceList);

        BigDecimal SumOfNotMaxDistance = BigDecimal.ZERO;
        for (int i = 0; i < distanceList.size(); i++){
            if (!(distanceList.get(i).compareTo(maxDistance) == 0)) {
                SumOfNotMaxDistance = SumOfNotMaxDistance.add(distanceList.get(i));
            }
        }
        SumOfNotMaxDistance = SumOfNotMaxDistance.setScale(15, RoundingMode.FLOOR);
        //System.out.println("maxDistance: " + maxDistance + "SumOfNotMaxDistance: " + SumOfNotMaxDistance);

        if (maxDistance.compareTo(SumOfNotMaxDistance) == -1)
            return true;
        else
            return false;
    }

    public static BigDecimal calculateDistance(int x1, int x2, int y1, int y2){
        return (BigDecimal.valueOf(Math.sqrt(Math.pow((x2-x1), 2.0) + Math.pow(y2-y1, 2.0))));
    }

    public static BigDecimal calculateRound(BigDecimal sideA, BigDecimal sideB){
        return ((sideA.add(sideB).multiply(BigDecimal.valueOf(2.0))));
    }

    public static ArrayList<BigDecimal> getDistanceList(int x1, int x2, int x3, int y1, int y2, int y3){
        ArrayList<BigDecimal> distanceList = new ArrayList<>();

        distanceList.add(calculateDistance(x1, x2, y1, y2));
        distanceList.add(calculateDistance(x1, x3, y1, y3));
        distanceList.add(calculateDistance(x2, x3, y2, y3));

        return distanceList;
    }

    public static BigDecimal getMaxDistance(ArrayList<BigDecimal> distanceList){
        BigDecimal maxDistance = BigDecimal.ZERO;
        for (int i = 0; i < distanceList.size(); i++){
            if (maxDistance.compareTo(distanceList.get(i)) == -1)
                maxDistance = distanceList.get(i);
        }

        return maxDistance;
    }
}
