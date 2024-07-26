
import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static BufferedReader br;
    static int N;
    static StringTokenizer st;
    static Map<Integer, List<Integer>> nodeMap;
    static int[] childs;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        nodeMap = new TreeMap<>();
        childs = new int[N+1];
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            nodeMap.put(i, new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int Node1 = Integer.parseInt(st.nextToken());
            int Node2 = Integer.parseInt(st.nextToken());

            nodeMap.get(Node1).add(Node2);
            nodeMap.get(Node2).add(Node1);

        }
        search(1);

        for (int child : childs) {
            if (child > 0) {
                bw.write(child + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();

    }

    private static void search(int key) throws IOException {
        visited[key] = true;
        if (!nodeMap.get(key).isEmpty()) {
            for (Integer child : nodeMap.get(key)) {
                if (!visited[child]) {
                    childs[child] = key;
                    search(child);
                }
            }
        }
    }

}
