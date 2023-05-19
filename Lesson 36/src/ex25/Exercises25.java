package ex25;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Branium Academy
 * @address <a href="https://braniumacademy.net/">Trang chủ</a>
 */

public class Exercises25 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("./Lesson 36/src/ex25/input25.txt");
        var input = new Scanner(file);
        var numOfTest = input.nextInt();
        while (numOfTest > 0) {
            var m = input.nextInt();
            var n = input.nextInt();
            var matrix = new int[m][n];
            fillMatrix(matrix);
            System.out.println("Ma trận A: ");
            onScreen(matrix);
            numOfTest--;
        }

    }

    /**
     * phương thức hiển thị ma trận lên màn hình
     *
     * @param matrix ma trận chứa các phần tử cần hiển thị
     */
    private static void onScreen(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    /**
     * phương thức điền giá trị cho ma trận. Nhận thấy rằng
     * phần tử tại vị trí i, j trong ma trận là phần dư của (i + j) % 2
     *
     */
    private static void fillMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (i + j) % 2;
            }
        }
    }
}
