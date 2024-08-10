
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int M;
    static int[][] chickenMap;
    static int[][] withoutChickenMap;
    static List<ChickenStore> allChickenList;
    static boolean[] visited;
    static List<List<ChickenStore>> combChickenList;
    static int[] drow = new int[] {1, -1, 0, 0};
    static int[] dcol = new int[] {0, 0, 1, -1};
    static int localMinimum = 987654310;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        setChickenMap();

        visited = new boolean[allChickenList.size()];
        combChickenList = new ArrayList<>();
        setComb();
//        System.out.println("combChickenList = " + combChickenList);
        List<Integer> results = minimumDistance();
        System.out.println(Collections.min(results));


    }
    private static List<Integer> minimumDistance() {

        List<Integer> allList = new ArrayList<>();

        for (int i = 0; i < combChickenList.size(); i++) {
            int dist = 0;
            int[][] tmpMap = new int[N][N];
            for (int j = 0; j < N; j++) {
                tmpMap[j] = Arrays.copyOf(withoutChickenMap[j], withoutChickenMap[j].length);
            }
            for (ChickenStore chickenStore : combChickenList.get(i)) {
                tmpMap[chickenStore.row][chickenStore.col] = 2;
            }
//            for (int j = 0; j < N; j++) {
//                System.out.println(Arrays.toString(tmpMap[j]));
//            }

            // 1에서 가까운 치킨집 찾기
            dist = getDist(tmpMap, dist);

//            System.out.println("distanceFinal = " + dist);
//            System.out.println("=======");
            if (dist > 0) {
                allList.add(dist);
            }
        }

        return allList;
    }

    private static int getDist(int[][] tmpMap, int dist) {
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < N; k++) {

                if (tmpMap[j][k] == 1) {
//                    System.out.println("row : " + j + " col : " + k);
                    boolean[][] visitedSearch = new boolean[N][N];
                    Deque<int[]> deque = new ArrayDeque<>();

                    deque.offer(new int[] {j, k, 0});
                    visitedSearch[j][k] = true;

                    while (!deque.isEmpty()) {
                        int[] poll = deque.poll();

                        for (int l = 0; l < 4; l++) {
                            if (poll[0] + drow[l] >= 0
                                && poll[0] + drow[l] < N
                                && poll[1] + dcol[l] >= 0
                                && poll[1] + dcol[l] < N
                            ) {
                                if (!visitedSearch[poll[0] + drow[l]][poll[1] + dcol[l]]) {
                                    if (tmpMap[poll[0] + drow[l]][poll[1] + dcol[l]] == 2) {
                                        dist += poll[2] + 1;
                                        if (dist >= localMinimum) {
                                            return -1;
                                        }
                                        deque.clear();
                                        break;
                                    } else {
                                        deque.offer(new int[] {poll[0] + drow[l], poll[1] + dcol[l], poll[2] + 1});
//                                        System.out.println("큐 사이즈: " + deque.size());
                                        visitedSearch[poll[0] + drow[l]][poll[1] + dcol[l]] = true;
                                    }
                                }
                            }
                        }
                    }
//                    System.out.println("중간계산 : " + dist);
                }
            }
        }
        if (localMinimum > dist) {
            localMinimum = dist;
        }
        return dist;
    }


    private static void comb(List<ChickenStore> arr, boolean[] visited, int depth, int n, int r) {
        if(r == 0) {
            List<ChickenStore> tmp = new ArrayList<>();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    tmp.add(arr.get(i));
                }
            }
            combChickenList.add(tmp);
            return;
        }

        if(depth == n) {
            return;
        }

        visited[depth] = true;
        comb(arr, visited, depth + 1, n, r-1);
        visited[depth] = false;
        comb(arr, visited, depth + 1, n, r);
    }

    private static void setComb() {
        comb(allChickenList, visited, 0, allChickenList.size(), M);
    }

    static void setChickenMap() throws IOException {
        chickenMap = new int[N][N];
        withoutChickenMap = new int[N][N];
        allChickenList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                chickenMap[i][j] = value;
                if (value == 2) {
                    withoutChickenMap[i][j] = 0;
                    allChickenList.add(new ChickenStore(i, j));
                } else {
                    withoutChickenMap[i][j] = value;
                }
            }
        }
    }

    static class ChickenStore {
        int row;
        int col;

        public ChickenStore(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "ChickenStore{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }
}
