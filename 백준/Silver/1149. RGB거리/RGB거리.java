
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        Deque<int[]> dequeHouse = new ArrayDeque<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int red = Integer.parseInt(st.nextToken());   
            int green = Integer.parseInt(st.nextToken());   
            int blue = Integer.parseInt(st.nextToken());
            
            dequeHouse.offer(new int[] {red, green, blue});
        }
        List<Integer> dp = new ArrayList<>();
        int[] colorExpHouseArray = dequeHouse.poll();
        for (int i = 0; i < 3; i++) {
            dp.add(colorExpHouseArray[i]);
        }

        while (!dequeHouse.isEmpty()) {
            int[] poll = dequeHouse.poll();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                tmp.add(poll[i]);
            }
            int red = Math.min(dp.get(1), dp.get(2)) + tmp.get(0);
            int green = Math.min(dp.get(0), dp.get(2)) + tmp.get(1);
            int blue = Math.min(dp.get(0), dp.get(1)) + tmp.get(2);
            // dp에 업데이트
            dp.set(0, red);
            dp.set(1, green);
            dp.set(2, blue);
        }

        System.out.println(Collections.min(dp));
    }
}
