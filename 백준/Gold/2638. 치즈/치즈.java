
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int M;
    static int[][] cheeseMap;
    static int[] dRow = new int[] {1, -1, 0, 0};
    static int[] dCol = new int[] {0, 0, 1, -1};
    static int count;
    static boolean isChanged = true;
    static int loop;
    static int[] noCheeseZone;
    static Deque<int[]> deque;
    static boolean[][] visited;



    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        noCheeseZone = new int[] {0, M-1};
        deque = new ArrayDeque<>();

        cheeseMap = new int[N][M];

        setCheeseMap();
        loop = 0;
        while (isChanged) {
            restructMap();
            loop++;
        }
        System.out.println(loop-1);
    }
    private static void restructMap() {
        isChanged = false;

        checkInside();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cheeseMap[i][j] == 1) {
                    cheackMeltingCheese(i,j);
                }
            }
        }


        // 변화 로직
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cheeseMap[i][j] == 3) {
                    isChanged = true;
                    cheeseMap[i][j] = 0;
                } else if (cheeseMap[i][j] == -1) {
                    cheeseMap[i][j] = 0;
                }
            }
        }



    }

    private static void cheackMeltingCheese(int i, int j) {
        int count = 0;
        for (int k = 0; k < 4; k++) {
            if (    i+dRow[k] >= 0
                    && i+dRow[k] < N
                    && j+dCol[k] >= 0
                    && j+dCol[k] < M
            ) {
                if (cheeseMap[i+dRow[k]][j+dCol[k]] == -1
                ) {
                    count++;
                }
            }
            if (count > 1) {
                cheeseMap[i][j] = 3;
            }
        }
    }

    private static void setCheeseMap() throws IOException {
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                cheeseMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void checkInside() {
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            if (i == 0 || i == N-1) {
                for (int j = 0; j < M; j++) {
                    if (cheeseMap[i][j] == 0) {
                        BFS(i,j);
                    }
                }
            } else {
                for (int j = 0; j < 2; j++) {
                    if (cheeseMap[i][j] == 0) {
                        BFS(i,j);
                    }
                }
            }
        }
    }

    private static void BFS(int i, int j) {
        deque.offer(new int[] {i,j});
        cheeseMap[i][j] = -1;


        while (!deque.isEmpty()) {
            int[] poll = deque.poll();
            int r = poll[0];
            int c = poll[1];

            for (int k = 0; k < 4; k++) {
                if (    r+dRow[k] >= 0
                        && r+dRow[k] < N
                        && c+dCol[k] >= 0
                        && c+dCol[k] < M
                ) {
                    if (cheeseMap[r+dRow[k]][c+dCol[k]] == 0 && !visited[r+dRow[k]][c+dCol[k]]) {
                        deque.offer(new int[] {r+dRow[k], c+dCol[k]});
                        cheeseMap[r+dRow[k]][c+dCol[k]] = -1;
                        visited[r+dRow[k]][c+dCol[k]] = true;
                    }
                }

            }
        }
    }
}