import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int M;
    static int x;
    static int y;
    static int K;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        initMap();
        Dice dice = new Dice(x, y, N, M, map);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int order = Integer.parseInt(st.nextToken());
            dice.move(order);
        }
    }

    private static void initMap() throws IOException {
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static class Dice {
        int top = 0;
        int bottom = 0;
        int north = 0;
        int south = 0;
        int east = 0;
        int west = 0;
        int xMin = 0;
        int yMin = 0;

        int x;
        int y;
        int xMax; //N
        int yMax; //M
        int[][] map;


        public Dice(int x, int y, int xMax, int yMax, int[][] map) {
            this.x = x;
            this.y = y;
            this.xMax = xMax - 1;
            this.yMax = yMax - 1;
            this.map = map;
        }

        public void move(int order) {
            if (checkOrder(order)) {
                // 움직임
                switch (order) {
                    case 1:
                        // 주사위 굴리기
                        int bottomPrev1 = bottom;
                        bottom = east;
                        east = top;
                        top = west;
                        west = bottomPrev1;
                        // 주사위 맵 위치 갱신
                        y += 1;
                        // 주사위 바텀값 <-> 맵값 갱신
                        updateMapDice();
                        // 출력
                        System.out.println(top);
                        break;
                    case 2:
                        int bottomPrev2 = bottom;
                        bottom = west;
                        west = top;
                        top = east;
                        east = bottomPrev2;
                        y -= 1;
                        updateMapDice();
                        System.out.println(top);
                        break;
                    case 3:
                        int bottomPrev3 = bottom;
                        bottom = north;
                        north = top;
                        top = south;
                        south = bottomPrev3;
                        x -= 1;
                        updateMapDice();
                        System.out.println(top);
                        break;
                    case 4:
                        int bottomPrev4 = bottom;
                        bottom = south;
                        south = top;
                        top = north;
                        north = bottomPrev4;
                        x += 1;
                        updateMapDice();
                        System.out.println(top);
                        break;
                }

            }
        }

        private boolean checkOrder(int order) {
            switch (order) {
                case 1:
                    if (y + 1 > yMax) {
                        return false;
                    }
                    return true;
                case 2:
                    if (y - 1 < 0) {
                        return false;
                    }
                    return true;
                case 3:
                    if (x - 1 < 0) {
                        return false;
                    }
                    return true;
                case 4:
                    if (x + 1 > xMax) {
                        return false;
                    }
                    return true;
            }
            return false;
        }

        private void updateMapDice() {
            if (map[x][y] == 0) {
                map[x][y] = bottom;
            } else {
                bottom = map[x][y];
                map[x][y] = 0;
            }
        }
    }
}
