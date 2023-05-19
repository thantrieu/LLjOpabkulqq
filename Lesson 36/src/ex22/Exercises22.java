package ex22;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Branium Academy
 * @address https://braniumacademy.net/
 */

public class Exercises22 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("./Lesson 36/src/ex22/input22.txt");
        var input = new Scanner(file);
        var h = input.nextInt();
        // mảng lưu kết quả
        var triangle = new String[h][2 * h - 1];
        // vẽ tam giác
        fillRect(triangle);
        // hiện kết quả lên màn hình
        onScreen(triangle);
    }

    /**
     * phương thức vẽ lên màn hình các giá trị trong mảng
     *
     * @param rect mảng chứa dữ liệu cần hiển thị lên màn hình
     */
    private static void onScreen(String[][] rect) {
        System.out.println("Hình cần vẽ: ");
        for (int i = 0; i < rect.length; i++) {
            for (int j = 0; j < 2 * rect.length - 1; j++) {
                System.out.print(rect[i][j]); // in ra giá trị trong mảng
            }
            System.out.println(); // in xuống dòng
        }
    }

    /**
     * phương thức điền kí tự * và khoảng trắng vào mảng
     *
     * @param rect mảng chứa hình tam giác vuông cần vẽ
     */
    private static void fillRect(String[][] rect) {
        // vẽ tam giác cân đặc bằng các chữ số theo nguyên lý:
        // lấy đối xứng qua cột h, j, i bắt đầu từ 1
        // trên hàng thứ i vẽ số tại các vị trí từ h-i+1 đến h+i-1
        // giá trị in ra trên cột j là i-|h-j|. Các vị trí còn lại
        // vẽ khoảng trắng
        var h = rect.length;
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j < 2 * h; j++) {
                if (j >= h - i + 1 && j <= h + i - 1) {
                    rect[i - 1][j - 1] = " " + (i - Math.abs(h - j)) + " ";
                } else {
                    rect[i - 1][j - 1] = "   ";
                }
            }
        }
    }
}
