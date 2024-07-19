
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static final int INF_VALUE = 9000001;

    public static class Edge {
        int start;
        int end;
        int exp;

        public Edge(int start, int end, int exp) {
            this.start = start;
            this.end = end;
            this.exp = exp;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "start=" + start +
                    ", end=" + end +
                    ", exp=" + exp +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        int TC = Integer.parseInt(br.readLine());

        int[] dp;
        Map<Integer,List<Edge>> map;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < TC; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 지점 수
            int M = Integer.parseInt(st.nextToken()); // 도로 개수
            int W = Integer.parseInt(st.nextToken()); // 웜홀 개수
            // 메모리 초기화
            map = new HashMap<>();
            dp = new int[N+1];
            for (int j = 1; j <= N; j++) {
                map.put(j, new ArrayList<>());
            }
            // 데이터 초기화
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int exp = Integer.parseInt(st.nextToken());
                map.get(start).add(new Edge(start, end, exp));
                map.get(end).add(new Edge(end, start, exp));

            }

            for (int j = 0; j < W; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int exp = -Integer.parseInt(st.nextToken());
                map.get(start).add(new Edge(end, start, exp));
            }

            sb.append(bellmanford(map, dp, N) ? "YES\n" : "NO\n");

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean bellmanford(Map<Integer,List<Edge>> map, int[] dp, int N) {

        for (int i = 1; i <= N; i++) {
            dp[i] = INF_VALUE;
        }
        boolean updated = false;

        dp[1] = 0; // 시작점 설정

        // N-1 반복
        for (int i = 0; i < N-1; i++) {
            updated = false;
            // 모든 노드 조사
            for (int j = 1; j <= N; j++) {
                for (Edge edge : map.get(j)) {
                    if (dp[edge.end] > dp[edge.start] + edge.exp) {
                        updated = true;
                        dp[edge.end] = dp[edge.start] + edge.exp;
                    }
                }
            }

            if (!updated) {
                break;
            }
        }

        if (updated) {
            for (int j = 1; j <= N; j++) {
                for (Edge edge : map.get(j)) {
                    if (dp[edge.end] > dp[edge.start] + edge.exp) {
                        return true;
                    }
                }
            }
        }
        return false;

    }
}
