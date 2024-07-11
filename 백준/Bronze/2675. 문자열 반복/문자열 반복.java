
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] items = br.readLine().split(" ");
            int again = Integer.parseInt(items[0]);
            String[] alphabet = items[1].split("");

            StringBuilder sb = new StringBuilder();
            for (String s : alphabet) {
                sb.append(String.valueOf(s).repeat(Math.max(0, again)));
            }

            String result = sb.toString();
            System.out.println(result);
        }
    }
}
