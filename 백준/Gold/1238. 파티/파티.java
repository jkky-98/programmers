

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N;
    static int M;
    static int X;
    static List<List<Road>> map;
    static int[] dp;
    static boolean[] visited;
    static int INF = 987654321;
    static int[] result;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄 파싱
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 학생 수(노드)
        M = Integer.parseInt(st.nextToken()); // 도로 수(엣지)
        X = Integer.parseInt(st.nextToken()); // 도착지

        setMap();
        result = new int[N+1];

        for (int i = 1; i <= N; i++) {
            int GoExp = dijkstra(i, X);
            int comebackExp = dijkstra(X, i);
            result[i] = GoExp + comebackExp;
        }

        // 최댓값들 삭제 해주기
        for (int i = 0; i < dp.length; i++) {
            if (result[i] > 98765432) {
                result[i] = 0;
            }
        }

        // Max값 찾기
        int maxNodeValue = result[1];
        for (int i = 1; i < result.length; i++) {
            if (result[i] > maxNodeValue) {
                maxNodeValue = result[i];
            }
        }

        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(""+maxNodeValue);
        bw.flush();
        bw.close();
        br.close();

    }
    private static int dijkstra(int start, int target) {
        dp = new int[N+1];
        visited = new boolean[N+1];
        Arrays.fill(dp, INF);

        dp[start] = 0;

        for (int i = 0; i < N; i++) {

            int min = dp[0];
            int minIndex = 0;

            for (int j = 0; j < dp.length; j++) {
                if (dp[j] < min && !visited[j]) {
                    min = dp[j];
                    minIndex = j;
                }
            }

            visited[minIndex] = true;

            for (Road road : map.get(minIndex)) {
                dp[road.end] = Math.min(dp[road.end], dp[minIndex] + road.exp);
            }
        }

        return dp[target];

    }

    private static void setMap() throws IOException {
        // map 만들기
        map = new ArrayList<>();

        // 시작점 확보
        for (int i = 0; i <= N ; i++) {
            map.add(new ArrayList<>());
        }

        // 도로 정보 주입
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int exp = Integer.parseInt(st.nextToken());

            map.get(start).add(new Road(end, exp));
        }
    }

    static class Road {
        int end;
        int exp;

        public Road(int end, int exp) {
            this.end = end;
            this.exp = exp;
        }

        @Override
        public String toString() {
            return "Road{" +
                    "end=" + end +
                    ", exp=" + exp +
                    '}';
        }
    }
}
