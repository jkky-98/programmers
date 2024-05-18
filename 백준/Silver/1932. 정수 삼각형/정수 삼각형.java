
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        sc.nextLine();
        Object[] process = new Object[length];

        for (int i=0; i<length; i++) {
            process[i] = getArray(sc);
        }
        int[] front = (int[]) process[0];

        for (int i=0; i<length-1; i++) {
            int[] back = (int[]) process[i+1];

            int[] dp = new int[back.length];
            for (int j=0; j<back.length; j++) {
                if (j==0) {
                    int newNum = front[j] + back[j];
                    dp[j] = newNum;

                } else if (j == back.length -1) {
                    int newNum = front[j-1] + back[j];
                    dp[j] = newNum;

                } else {
                    // 좌우 최댓값 구하기
                    int left = front[j-1] + back[j];
                    int right = front[j] + back[j];
                    int newNum = Math.max(left, right);
                    dp[j] = newNum;

                }
            }
            front = dp;
        }
        System.out.println(Arrays.stream(front).max().getAsInt());
    }

    public static int[] getArray(Scanner sc) {
        String input = sc.nextLine();
        String[] inputArray = input.split(" ");
        int[] numbers = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            numbers[i] = Integer.parseInt(inputArray[i]);
        }

        return numbers;
    }
}
