
import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N;
    static int M;
    static List<List<Road>> roads = new ArrayList<>();
    static long[] vertexCosts;
    static long INF_VALUE = 987654321000000L;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] NMSplit = br.readLine().split(" ");
        N = Integer.parseInt(NMSplit[0]); // vertex 수
        M = Integer.parseInt(NMSplit[1]); // 버스 노선
        vertexCosts = new long[N+1];
        setRoads(); // roads에 데이터 채우기


        boolean bellmanford = Bellmanford();

        sb = new StringBuilder();

        if (bellmanford) {
            sb.append("-1\n");
        } else {
            for (int i = 2; i <= N; i++) {
                if (vertexCosts[i] == INF_VALUE) {
                    sb.append("-1\n");
                } else {
                    sb.append(vertexCosts[i]).append("\n");
                }
            }
        }

        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();


    }
    private static boolean Bellmanford() {
        Arrays.fill(vertexCosts, INF_VALUE);
        vertexCosts[1] = 0; // 시작점 설정

        boolean updated = false;
        for (int i = 0; i < N-1; i++) { // N-1번 반복
            updated = false;
            for (int j = 1; j <= N; j++) { // 모든 vertex 조사
                if (vertexCosts[j] == INF_VALUE) {
                    continue;
                }
                for (Road road : roads.get(j)) {
                    if (vertexCosts[road.end] > vertexCosts[j] + road.cost) {
                        vertexCosts[road.end] = vertexCosts[j] + road.cost;
                        updated = true;
                    }
                }
            }

            if (!updated) {
                break;
            }
        }

        if(updated) {
            for (int j = 1; j <= N; j++) { // 모든 vertex 조사
                if (vertexCosts[j] == INF_VALUE) {
                    continue;
                }
                for (Road road : roads.get(j)) {
                    if (vertexCosts[road.end] > vertexCosts[j] + road.cost) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static void setRoads() throws IOException {
        for (int i = 0; i <= N; i++) {
            roads.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            roads.get(A).add(new Road(B, C));
        }
    }

    public static class Road {
        int end;
        int cost;

        public Road(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
}
