package strings;

import java.util.Scanner;
/*Viết chương trình nhập vào một số nhị phân ở dạng chuỗi ký tự 0 và 1,
chuyển số này thành một số nguyên hệ thập phân*/
public class SE122 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nhị phân: ");
        String binaryString = scanner.nextLine();

        int decimalValue = 0;
        int length = binaryString.length();

        // Duyệt qua từng ký tự trong chuỗi nhị phân từ trái sang phải
        for (int i = 0; i < length; i++) {
            char bit = binaryString.charAt(i);
            if (bit == '1') {
                // Nếu ký tự là '1', cộng giá trị tương ứng vào decimalValue
                decimalValue += Math.pow(2, length - 1 - i);
            } else if (bit != '0') {
                System.out.println("Chuỗi không phải là số nhị phân hợp lệ.");
                return;
            }
        }

        System.out.println("Giá trị thập phân: " + decimalValue);
    }
}
