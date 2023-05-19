package ex4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Branium Academy
 * @ link: https: braniumacademy.net
 */

public class Exercises4 {
    public static void main(String[] args) throws FileNotFoundException {
        // dữ liệu cho trước đã chuẩn hóa nên k cần dùng nextX để kiểm tra
        File file = new File("./Lesson 36/src/ex4/input4.txt"); // tạo đối tượng file trỏ đến file input4.txt
        var input = new Scanner(file); // chuyển đối tượng của Scanner sang đọc file
        var n = input.nextInt(); // đọc n
        var numbers = getNumbers(n, input); // gọi phương thức đọc ra n phần tử mảng
        input.close(); // đóng file - đọc xong file thì đóng nó lại
        // sắp xếp và hiển thị
        sort(numbers); // viết hàm sắp xếp
        System.out.println("Mảng sau khi sắp xếp: ");
        showArray(numbers); // hiển thị mảng
        int min2 = findMin2(numbers); // tìm giá trị nhỏ thứ hai trong mảng
        if (min2 != numbers[numbers.length - 1]) { // nếu phần tử cuối của mảng mà khác với
            showMin2(numbers, min2);                // min2 tức là có giá trị min thứ 2, hiện nó ra
        } else {                        // ngược lại: không có giá trị min2
            System.out.println("Không có giá trị nhỏ thứ hai trong mảng");
        }
    }

    /**
     * phương thức sắp xếp nổi bọt
     *
     * @param numbers mảng cần sắp xếp
     */
    private static void sort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = numbers.length - 1; j > i; j--) {
                if (numbers[j] > numbers[j - 1]) { // sắp xếp giảm dần
                    var x = numbers[j];
                    numbers[j] = numbers[j - 1];
                    numbers[j - 1] = x;
                }
            }
        }
    }

    /**
     * phương thức hiển thị chỉ số các phần tử trùng với giá trị min2
     *
     * @param numbers là mảng chứa các phần tử cần xét
     * @param min2    là giá trị nhỏ thứ hai
     */
    private static void showMin2(int[] numbers, int min2) {
        System.out.println("Giá trị min2 = " + min2); // hiện giá trị min 2
        System.out.print("Chỉ số: ");                   // hiện đầu mục
        for (int i = 0; i < numbers.length; i++) {      // liệt kê các chỉ số của các phần tử có giá trị trùng với min2
            if (numbers[i] == min2) {
                System.out.print(i + " ");
            }
        }
    }

    /**
     * phương thức tìm và trả về giá trị min2 trong mảng đã sắp xếp
     *
     * @param numbers là mảng chứa các giá trị cần xét
     * @return giá trị min2 tìm được
     */
    private static int findMin2(int[] numbers) {
        int max = numbers[numbers.length - 1];
        // tìm min2
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] != max) { // nếu tìm thấy min2
                return numbers[i];
            }
        }
        return max;
    }

    /**
     * phương thức hiển thị các phần tử mảng
     *
     * @param numbers là mảng chứa các phần tử cần hiển thị
     */
    private static void showArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) { // duyệt toàn bộ mảng
            System.out.print(numbers[i] + " "); // in ra từng p.tử
        }
        System.out.println(); // hiện xuống dòng mới
    }

    /**
     * phương thức nhập vào danh sách các số nguyên
     *
     * @param n     số lượng giá trị cần nhập
     * @param input đối tượng của lớp Scanner
     * @return mảng các phần tử đã nhập vào
     */
    private static int[] getNumbers(int n, Scanner input) {
        var numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = input.nextInt();
        }
        return numbers;
    }
}