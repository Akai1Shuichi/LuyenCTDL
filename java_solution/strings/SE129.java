package strings;


import java.util.Scanner;
import java.util.Stack;

/* Bài 129
Nhập một chuỗi ký tự chứa ít nhất 4 ký tự số. Loại bỏ một số ký tự ra khỏi
chuỗi sao cho 4 ký tự số cuối cùng còn lại (theo đúng thứ tự đó) tạo nên số lớn nhất.
*/
public class SE129 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi ký tự: ");
        String input = scanner.nextLine();

        // Bước 1: Lấy tất cả các ký tự số trong chuỗi

        StringBuilder digits = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                digits.append(ch);
                // append từng chuỗi số theo thứ tự từ char[0] => length-1
            }
        }

        // Kiểm tra nếu số ký tự số nhỏ hơn 4
        if (digits.length() < 4) {
            System.out.println("Chuỗi không chứa ít nhất 4 ký tự số.");
            return;
        }

        // Bước 2: Tìm số lớn nhất có thể bằng cách giữ lại 4 chữ số
        // Sử dụng stack để giữ các chữ số lớn nhất theo thứ tự
        Stack<Character> stack = new Stack<>();
        int numToRemove = digits.length() - 4; // Số lượng chữ số cần loại bỏ

        for (int i = 0; i < digits.length(); i++) {
            char currentDigit = digits.charAt(i);

            // Loại bỏ các chữ số nhỏ hơn nếu còn số lượng cần loại bỏ
            while (!stack.isEmpty() && stack.peek() < currentDigit && numToRemove > 0) {
                stack.pop();
                numToRemove--;
            }

            stack.push(currentDigit);
        }

        // Bước 3: Lấy 4 chữ số cuối cùng trong stack
        while (stack.size() > 4) {
            stack.pop();
        }

        // Bước 4: Kết quả
        StringBuilder result = new StringBuilder();
        for (char digit : stack) {
            result.append(digit);
        }

        System.out.println("Số lớn nhất có thể từ 4 chữ số cuối: " + result.toString());
    }
}
