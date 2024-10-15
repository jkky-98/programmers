

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N;
    static List<List<Integer>> map;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        map = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        map();
        quadTree(map);

        bw.flush();
        br.close();
        bw.close();
    }

    private static void map() throws IOException {
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String[] split = st.nextToken().split("");
            map.add(new ArrayList<>());
            for (int j = 0; j < N; j++) {
                map.get(i).add(Integer.parseInt(split[j]));
            }
        }
    }

    private static boolean checkSame(List<List<Integer>> subMap) {
        int size = subMap.size();
        int index = subMap.get(0).get(0);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Integer findValue = subMap.get(i).get(j);
                if (index != findValue) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void quadTree(List<List<Integer>> map) throws IOException {
        if (checkSame(map)) {
            bw.write(Integer.toString(map.get(0).get(0)));
            return;
        } else {
            Deque<List<List<Integer>>> deque = mapSlice(map);
            bw.write("(");
            while (!deque.isEmpty()) {
                quadTree(deque.poll());
            }
            bw.write(")");
        }
    }

    private static Deque<List<List<Integer>>> mapSlice(List<List<Integer>> map) {
        Deque<List<List<Integer>>> deque = new ArrayDeque<>();

        int size = map.size();

        List<List<Integer>> leftUP = cut4(map, new int[] {0, size/2-1, 0, size/2-1});
        List<List<Integer>> rightUP = cut4(map, new int[] {0, size/2-1, size/2, size-1});
        List<List<Integer>> leftDown = cut4(map, new int[] {size/2, size-1, 0, size/2-1});
        List<List<Integer>> rightDown = cut4(map, new int[] {size/2, size-1, size/2, size-1});

        deque.offer(leftUP);
        deque.offer(rightUP);
        deque.offer(leftDown);
        deque.offer(rightDown);

        return deque;
    }

    private static List<List<Integer>> cut4(List<List<Integer>> map, int[] index) {
        List<List<Integer>> tmpSubMap = new ArrayList<>();
        int count = 0;

        for (int i = index[0]; i <= index[1]; i++) {
            tmpSubMap.add(new ArrayList<>());
            for (int j = index[2]; j <= index[3]; j++) {
                tmpSubMap.get(count).add(map.get(i).get(j));
            }
            count++;
        }

        return tmpSubMap;
    }
}
