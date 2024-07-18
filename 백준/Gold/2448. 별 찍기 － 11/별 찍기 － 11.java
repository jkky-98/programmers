
import java.io.*;
public class Main {
    static BufferedReader br = null;
    static BufferedWriter bw = null;
    static StringBuilder sb = null;
    static String[] arr = null;
    static int N;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new String[N];

        arr[0] = "  *  ";
        arr[1] = " * * ";
        arr[2] = "*****";

        for(int k = 1; 3*(int)Math.pow(2, k) <= N; k++) {
            process(k);
        }

        sb.delete(0, sb.length());
        for(int i = 0; i < N; i++) {
            sb.append(arr[i]).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    public static void process(int k) {
        int end = 3 * (int)Math.pow(2, k);  
        int mid = end / 2;

        for(int i = mid; i < end; i++) {  
            arr[i] = arr[i - mid] + " " + arr[i - mid];
        }

        sb.delete(0, sb.length());
        while(sb.length() < mid) {
            sb.append(" ");
        }

        for(int i = 0; i < mid; i++) {  
            arr[i] = sb.toString() + arr[i] + sb.toString();
        }
    }
}