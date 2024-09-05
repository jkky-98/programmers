

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int N;
    static StringTokenizer st;
    static int count = 0;
    static StringWriter writer1;
    static StringWriter writer2;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 두 개의 StringWriter 생성
        writer1 = new StringWriter();
        writer2 = new StringWriter();


        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());


        hanoi(1, 2, 3, N);
        writer2.write(count + "\n");

        bw.write(writer2.toString());
        bw.write(writer1.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static void hanoi(int start, int via, int end, int N) throws IOException {
        if (N == 1) {
            count++;
            move(N, start, end);
        } else {
            hanoi(start, end, via, N-1);
            move(N-1, start, end);
            count++;
            hanoi(via, start, end, N-1);
        }
    }

    static void move(int N, int start, int end) throws IOException {
        writer1.write(start + " " + end + "\n");
    }
}
