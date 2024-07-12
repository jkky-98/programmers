

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int result = BFS(start, target);
        System.out.println(result);
    }
    public static class Position {
        int pos;
        int time;

        public Position(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return pos == position.pos;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(pos);
        }
    }

    public static int BFS(int start, int target) {
        Set<Position> visited = new HashSet<>();
        Deque<Position> deque = new ArrayDeque<>();

        deque.add(new Position(start, 0));

        while (!deque.isEmpty()) {
            Position poll = deque.poll();
            int pos = poll.pos;
            int time = poll.time;
            if (pos == target) {
                return time;
            }

            if (!visited.contains(new Position(pos + 1, time + 1))) {
                deque.offer(new Position(pos+1, time+1));
                visited.add(new Position(pos+1, time+1));
            }

            if (!visited.contains(new Position(pos - 1, time + 1)) && pos - 1 >= 0) {
                deque.offer(new Position(pos-1, time+1));
                visited.add(new Position(pos-1, time+1));
            }

            if (!visited.contains(new Position(pos * 2, time + 1)) && pos * 2 < target + 2) {
                deque.offer(new Position(pos * 2, time+1));
                visited.add(new Position(pos * 2, time+1));
            }
        }

        return -1;
    }
}
