import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static <T> void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();

        int[][] matrix = new int[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int blue = 0;
        int white = 0;
        Stack<int[][]> process = new Stack<>();
        process.push(matrix);

        while (!process.isEmpty()) {
            int[][] check_item = process.pop();
            int status = CheckMatrix(check_item);

            if (status == 2) {
                Object[] ProcessItems = DivideMatrix(check_item);
                for (Object item : ProcessItems) {
                    int[][] item1 = (int[][]) item;
                    process.push(item1);
                    }
                } else if (status == 1) {
                blue += 1;
            } else if (status == 0) {
                white += 1;
            }
        }
        System.out.println(white);
        System.out.println(blue);



        }
    public static Object[] DivideMatrix(int[][] matrix){
        int length = matrix.length / 2;
        int[][] topLeft = new int[length][length];
        int[][] topRight = new int[length][length];
        int[][] botLeft = new int[length][length];
        int[][] botRight = new int[length][length];

        for (int i=0; i<length; i++) {
            for (int j=0; j<length; j++) {
                topLeft[i][j] = matrix[i][j];
                topRight[i][j] = matrix[i][j+length];
                botLeft[i][j] = matrix[i+length][j];
                botRight[i][j] = matrix[i+length][j+length];
            }
        }
        return new Object[]{topLeft, topRight, botLeft, botRight};
    }
    public static int CheckMatrix(int[][] matrix) {
        int sum = 0;
        int fullOne = (int) Math.pow(matrix.length, 2);
        for (int[] i : matrix) {
            for (int j : i) {
                sum += j;
            }
        }

        if (sum == 0) {
            return 0;
        } else if(sum > 0 & sum < fullOne) {
            return 2;
        } else if(sum == fullOne) {
            return 1;
        } else {
            return 2;
        }
    }
}
