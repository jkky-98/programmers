import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(line[j]);
                map.get(i).add(Integer.parseInt(line[j]));
            }
        }

        List<List<Integer>> result = search(map, N);
        int count =0;
        for (List<Integer> integers : result) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            count++;
            if (count != N) {
                System.out.println();
            }
        }

    }

    public static List<List<Integer>> search(List<List<Integer>> map, int N) {
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map.get(i).get(k) == 1 && map.get(k).get(j) == 1) {
                        map.get(i).set(j, 1);
                    }
                }
            }
        }

        return map;

    }
}
