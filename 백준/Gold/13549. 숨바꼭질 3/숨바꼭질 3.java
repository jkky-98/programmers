

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int M;
    static Deque<Step> deque;
    static int[] visited;
    static int result;
    static final int INF_VALUE = 987654321;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        deque = new ArrayDeque<>();
        visited = new int[100000+2];
        BFS();

        System.out.println(visited[M]);
    }
    static void BFS() {
        Arrays.fill(visited, INF_VALUE);
        deque.offer(new Step(N,0));
        visited[N] = 0;

        while (!deque.isEmpty()) {
//            System.out.println(deque);
            Step poll = deque.poll();

            if (poll.pos == M) {
                result = poll.time;
                for (int i = 0; i < deque.size(); i++) {
                    Step poll1 = deque.poll();
                    if (poll1.time < result) {
                        deque.offer(poll1);
                    }
                }
                continue;
            }


            if (poll.pos - 1 >= 0) {
                if (visited[poll.pos - 1] == INF_VALUE || visited[poll.pos - 1] > poll.time + 1) {
                    visited[poll.pos - 1] = poll.time + 1;
                    deque.offer(new Step(poll.pos - 1, poll.time + 1));
                }
            }

            if (poll.pos + 1 < M + 2) {
                if (visited[poll.pos + 1] == INF_VALUE || visited[poll.pos + 1] > poll.time + 1) {
                    visited[poll.pos + 1] = poll.time + 1;
                    deque.offer(new Step(poll.pos + 1, poll.time + 1));
                }
            }

            if (poll.pos * 2 < M + 2) {
                if (visited[poll.pos * 2] == INF_VALUE || visited[poll.pos * 2] > poll.time) {
                    visited[poll.pos * 2] = poll.time;
                    deque.offer(new Step(poll.pos * 2, poll.time));
                }
            }
        }
    }

    static class Step {
        Integer pos;
        Integer time;

        public Step(Integer pos, Integer time) {
            this.pos = pos;
            this.time = time;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;
            Step step = (Step) object;
            return Objects.equals(pos, step.pos);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(pos);
        }

        @Override
        public String toString() {
            return "Step{" +
                    "pos=" + pos +
                    ", time=" + time +
                    '}';
        }
    }
}
