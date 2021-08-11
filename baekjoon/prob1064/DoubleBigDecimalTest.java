package prob1064;

import java.math.BigDecimal;

public class DoubleBigDecimalTest {

    public static void main(String[] args) {
        double value1 = 12.23;
        double value2 = 34.45;

        BigDecimal bd1 = BigDecimal.valueOf(12.23);
        BigDecimal bd2 = BigDecimal.valueOf(34.45);

        System.out.println(value1 + value2);
        System.out.println(bd1.add(bd2));
    }
}
