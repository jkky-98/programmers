import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

            for (int i=0; i<n; i++) {
                int num = sc.nextInt();
                if (num == 0) {
                    System.out.println("1 0");
                }
                else if (num == 1) {
                    System.out.println("0 1");
                }
                else {
                    int[][] dp = new int[num+1][2];
                    dp[0][0] = 1;
                    dp[0][1] = 0;
                    dp[1][0] = 0;
                    dp[1][1] = 1;
                    for (int j=2; j<=num; j++) {
                        dp[j][0] = dp[j-1][0] + dp[j-2][0];
                        dp[j][1] = dp[j-1][1] + dp[j-2][1];
                    }
                    System.out.println(dp[num][0] + " " + dp[num][1]);


                }
            }
    }
}