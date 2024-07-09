
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void BFS(int[][] cabbageMap, int[][] visited, int startX, int startY) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int rowSize = cabbageMap.length;
        int colSize = cabbageMap[0].length;

        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{startX, startY});
        visited[startX][startY] = 1;

        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            int cRow = current[0];
            int cCol = current[1];

            for (int d = 0; d < 4; d++) {
                int nRow = cRow + dx[d];
                int nCol = cCol + dy[d];

                if (nRow >= 0 && nRow < rowSize && nCol >= 0 && nCol < colSize) {
                    if (cabbageMap[nRow][nCol] == 1 && visited[nRow][nCol] == 0) {
                        deque.offer(new int[]{nRow, nCol});
                        visited[nRow][nCol] = 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < T; i++) {
            count = 0;
            String[] MNK =  br.readLine().split(" ");
            int M = Integer.parseInt(MNK[0]);
            int N = Integer.parseInt(MNK[1]);
            int K = Integer.parseInt(MNK[2]);

            int[][] cabbageMap = new int[N][M];
            int[][] visited = new int[N][M];

            for (int j = 0; j < K; j++) {
                String[] rc = br.readLine().split(" ");
                int r = Integer.parseInt(rc[1]);
                int c = Integer.parseInt(rc[0]);

                cabbageMap[r][c] = 1;

            }
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (cabbageMap[j][k] == 1) {
                        if (visited[j][k] == 0) {
                            BFS(cabbageMap, visited, j, k);
                            count++;
                        }
                    }
                }
            }
            System.out.println(count);
        }

    }

}
