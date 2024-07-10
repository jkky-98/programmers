

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());

        int result = BFS(target);
        System.out.println(result);


    }

    public static class Scenario {
        int count;
        int clipBoard;
        int time;

        public Scenario(int count, int clipBoard, int time) {
            this.count = count;
            this.clipBoard = clipBoard;
            this.time = time;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Scenario scenario = (Scenario) o;
            return count == scenario.count && clipBoard == scenario.clipBoard;
        }

        @Override
        public int hashCode() {
            return Objects.hash(count, clipBoard);
        }
    }

    public static int BFS(int target) {
        int start = 1;
        Set<Scenario> visited = new HashSet<>();
        Deque<Scenario> deque = new ArrayDeque<>();
        int error = -99;
        // 이모티콘 개수, 클립보드에 존재하는 수, time
        deque.offer(new Scenario(start,0,0));
        visited.add(new Scenario(start,0,0));

        while (!deque.isEmpty()) {
            Scenario poll = deque.poll();

            if (poll.count == target) {
                return poll.time;
            }

            // 조건 1 구현 : 화면에 있는 이모티콘 모두 복사해서 클립보드에 저장
            if (!visited.contains(new Scenario(poll.count, poll.count, poll.time+1)) ) {
                deque.offer(new Scenario(poll.count, poll.count, poll.time+1));
                visited.add(new Scenario(poll.count, poll.count, poll.time+1));
            }

            // 조건 2 구현 : 클립보드의 모든 이모티콘 화면으로
            if (!visited.contains(new Scenario(poll.count + poll.clipBoard, 0, poll.time+1)) &&
                    poll.count + poll.clipBoard < target + 2 && poll.clipBoard > 0) {
                deque.offer(new Scenario(poll.count + poll.clipBoard, poll.clipBoard, poll.time+1));
                visited.add(new Scenario(poll.count + poll.clipBoard, poll.clipBoard, poll.time+1));
            }

            // 조건 3 구현 : 화면에서 이모티콘 하나 빼기
            if (!visited.contains(new Scenario(poll.count-1, poll.clipBoard, poll.time+1)) && poll.count - 1 > 0 ) {
                deque.offer(new Scenario(poll.count-1, poll.clipBoard, poll.time+1));
                visited.add(new Scenario(poll.count-1, poll.clipBoard, poll.time+1));
            }

        }
        return error;
    }
}
