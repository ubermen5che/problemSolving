package baekjoon.prob4673;

public class Main {

    static boolean[] selfNumber;

    public static void main(String[] args) {

        selfNumber = new boolean[10001];

        checkSelfNum(1);

        for (int i = 1; i < selfNumber.length; i++){
            if (selfNumber[i] == false)
                System.out.println(i);
        }
    }

    private static void checkSelfNum(int n){
        int i = n;
        int k;

        while( i <= 10000 ){
            k = dOfN(i++);
            if (k < 10001)
                selfNumber[k] = true;
        }

        System.out.println("i = " + i);
    }

    private static int dOfN(int n){
        int result = n;

        String strN = String.valueOf(n);

        for (int i = 0; i < strN.length(); i++){
            result += Integer.parseInt(String.valueOf(strN.charAt(i)));
        }

        return result;
    }
}
