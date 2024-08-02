
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int M;
    static int[][] mapLab;
    static List<Coordi> allSpace;
    static List<Boolean> combVisited;
    static List<List<Coordi>> combList;
    static Deque<Coordi> deque;
    static boolean[][] visited;
    static int[] drow = new int[] {0, 0, 1, -1};
    static int[] dcol = new int[] {1, -1, 0, 0};
    static List<Integer> result;
    static List<Coordi> virus;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        mapLab = new int[N][M];
        allSpace = new ArrayList<>();
        combVisited = new ArrayList<>();
        combList = new ArrayList<>();
        deque = new ArrayDeque<>();
        result = new ArrayList<>();
        virus = new ArrayList<>();

        initMapLab();
        comb(combVisited, 0, combVisited.size(), 3);
        for (List<Coordi> coordis : combList) {
            int[][] mapLabTmp = new int[N][];
            for (int i = 0; i < N; i++) {
                mapLabTmp[i] = Arrays.copyOf(mapLab[i], M);
            }

            for (Coordi coordi : coordis) {
                mapLabTmp[coordi.row][coordi.col] = 1;
            }

            int bfs = BFS(mapLabTmp);
            result.add(bfs);
        }
        System.out.println(Collections.max(result));
    }
    static int BFS (int[][] mapLabTmp) {
        visited = new boolean[N][M];

        for (Coordi coordi : virus) {
            deque.offer(coordi);
            visited[coordi.row][coordi.col] = true;
        }
        int count = 0;

        while (!deque.isEmpty()) {
            Coordi poll = deque.poll();
            int row = poll.row;
            int col = poll.col;

            for (int i = 0; i < 4; i++) {
                if (row + drow[i] < N
                    && row + drow[i] >=0
                    && col + dcol[i] < M
                    && col + dcol[i] >=0
                    && !visited[row+drow[i]][col+dcol[i]]
                    && mapLabTmp[row+drow[i]][col+dcol[i]] == 0
                ) {
                    mapLabTmp[row+drow[i]][col+dcol[i]] = 2;
                    visited[row+drow[i]][col+dcol[i]] = true;
                    deque.offer(new Coordi(row+drow[i], col+dcol[i]));
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (mapLabTmp[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    static void initMapLab() throws IOException{
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                mapLab[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (mapLab[i][j] == 0) {
                    allSpace.add(new Coordi(i,j));
                    combVisited.add(false);
                } else if (mapLab[i][j] == 2) {
                    virus.add(new Coordi(i,j));
                }
            }
        }

    }
    static void comb(List<Boolean> combVisited, int depth, int n, int r) {
        if (r == 0) {
            List<Coordi> tmp = new ArrayList<>();
            for (int i = 0; i < combVisited.size(); i++) {
                if (combVisited.get(i)) {
                    tmp.add(allSpace.get(i));
                }
            }
            combList.add(tmp);
            return;
        }
        if (depth == n) {
            return;
        }

        combVisited.set(depth, true);
        comb(combVisited, depth + 1, n, r - 1);

        combVisited.set(depth, false);
        comb(combVisited, depth + 1, n, r);
    }

    static class Coordi {
        int row;
        int col;

        public Coordi(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
