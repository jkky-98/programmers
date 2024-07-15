

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int busCount = Integer.parseInt(st.nextToken());
        int[][] city = new int[N][N];

        for (int bus = 0; bus < busCount; bus++) {
            String[] line = br.readLine().split(" ");

            int start = Integer.parseInt(line[0]) - 1;
            int end = Integer.parseInt(line[1]) - 1;
            int exp = Integer.parseInt(line[2]);
            if (city[start][end] != 0) {
                exp = Math.min(city[start][end], exp);
            }
            city[start][end] = exp;
        }

        initCity(city);
        floyd(city);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(city[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void floyd(int[][] city) {
        int N = city.length;
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i != j) {
                        city[i][j] = Math.min(city[i][j], city[i][k] + city[k][j]);
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (city[i][j] == 10000000) {
                    city[i][j] = 0;
                }
            }
        }
    }

    public static void initCity(int[][] city) {
        int N = city.length;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (city[i][j] == 0) {
                    city[i][j] = 10000000;
                }
            }
        }
    }
}
