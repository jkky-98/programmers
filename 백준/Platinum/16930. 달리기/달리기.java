


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class isBlocked {
        char[][] map;
        HashSet<Integer> block = new HashSet<>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        public isBlocked(char[][] map) {
            this.map = map;
        }

        public boolean inference(int x, int y, int i, int stride) {
            if (!block.contains(i)) {
                if (map[x + dx[i]*stride][y + dy[i]*stride] == '.') {
                    return true;
                } else {
                    block.add(i);
                    return false;
                }
            } else {
                return false;
            }
        }

        public void clearBlock() {
            block.clear();
        }
    }

    public static int BFS(char[][] map, int[][] mapDP, int K, int startX, int startY, int targetX, int targetY) {
        Deque<Position> deque = new ArrayDeque<>();
        int count = 0;
        int N = map.length;
        int M = map[0].length;


        deque.offer(new Position(startX, startY, 0));
        mapDP[startX][startY] = 0;

        Position positionTarget = new Position(targetX, targetY, 99);

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int[] dl = new int[K];

        for (int i = 0; i < K; i++) {
            dl[i] = i+1;
        }

        isBlocked isblocked = new isBlocked(map);

        while (!deque.isEmpty()) {
            Position poll = deque.poll();


            isblocked.clearBlock();
            if (poll.equals(positionTarget)) {
                return poll.time;
            }
            for (int i = 0; i < 4; i++) {
                for (int stride : dl) {
                    if (poll.x + dx[i]*stride < N
                            && poll.x + dx[i]*stride >= 0
                            && poll.y + dy[i]*stride < M
                            && poll.y + dy[i]*stride >= 0
                    ) {
                        if (mapDP[poll.x + dx[i]*stride][poll.y + dy[i]*stride] != -1 && mapDP[poll.x + dx[i]*stride][poll.y + dy[i]*stride] <  poll.time+1) {
                            break;
                        }
                        if (isblocked.inference(poll.x, poll.y, i, stride)) {
                            if (mapDP[poll.x + dx[i]*stride][poll.y + dy[i]*stride] == -1) {
                                deque.offer(new Position(poll.x + dx[i]*stride, poll.y + dy[i]*stride, poll.time+1));
                                mapDP[poll.x + dx[i]*stride][poll.y + dy[i]*stride] = poll.time + 1;
                                count++;
                            } else if (mapDP[poll.x + dx[i]*stride][poll.y + dy[i]*stride] >  poll.time+1) {
                                deque.offer(new Position(poll.x + dx[i]*stride, poll.y + dy[i]*stride, poll.time+1));
                                mapDP[poll.x + dx[i]*stride][poll.y + dy[i]*stride] = poll.time + 1;
                                count++;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static class Position {
        int x;
        int y;
        int time;

        public Position(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x && y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Position{" +
                    "x=" + x +
                    ", y=" + y +
                    ", time=" + time +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        int[][] mapDP = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            Arrays.fill(mapDP[i], Integer.MAX_VALUE);
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        st = new StringTokenizer(br.readLine());

        int startX = Integer.parseInt(st.nextToken()) -1;
        int startY = Integer.parseInt(st.nextToken()) -1;
        int targetX = Integer.parseInt(st.nextToken()) -1;
        int targetY = Integer.parseInt(st.nextToken()) -1;


        int result = BFS(map, mapDP, K, startX, startY, targetX, targetY);
        System.out.println(result);



    }
}

