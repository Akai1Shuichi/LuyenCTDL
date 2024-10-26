package strings;


import java.util.Scanner;

// Nhập vào diện tích S của một mặt cầu. Tính thể tích V của hình cầu này.
/* S = 4 x pi x R^2
* V 4/3 x pi x R^3 */
public class SE1 {
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
