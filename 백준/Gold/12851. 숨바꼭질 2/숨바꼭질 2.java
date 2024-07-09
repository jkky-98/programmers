

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] siblings = br.readLine().split(" ");
        int me = Integer.parseInt(siblings[0]);
        int brother = Integer.parseInt(siblings[1]);

        List<Integer> result = BFS(me, brother);
        System.out.println(result.get(1));
        System.out.println(result.get(0));

    }
    public static List<Integer> BFS(int startInt, int targetInt) {
        int finish = -1;
        int count = 0;
        Deque<int []> deque = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        deque.offer(new int[] {startInt,0});
        visited.add(startInt);

        while(!deque.isEmpty()) {
            int[] poll = deque.poll();
            visited.add(poll[0]);
            if (poll[1] == finish) {
                break;
            }
            if (poll[0] != targetInt) {
                if (!visited.contains(poll[0]-1) && poll[0]-1 >= 0) {
                    deque.offer(new int[] {poll[0]-1, poll[1]+1});
                }
                if (!visited.contains(poll[0]+1) && poll[0]+1 < targetInt + 2) {
                    deque.offer(new int[] {poll[0]+1, poll[1]+1});
                }
                if (!visited.contains(poll[0]*2) && poll[0]*2 >= 0 && poll[0]*2 < targetInt + 2) {
                    deque.offer(new int[] {poll[0]*2, poll[1]+1});
                }
            } else {
                finish = poll[1] + 1;
                count++;
            }
        }
        return List.of(count, finish - 1);
    }
}
