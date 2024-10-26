package strings;

import java.util.Scanner;

public class SE2 {
    static double convertStoV(double s){
        double r = Math.sqrt(s/(4 * Math.PI));
        return  ((4.0/3.0) * r * r * r * Math.PI);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double s = sc.nextFloat();
        double v = convertStoV(s);
        System.out.println("The tich V la : " +  v);
    }
}
