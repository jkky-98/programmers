

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N;
    static int r;
    static int c;
    static int count = 0;
    static int[] dr;
    static int[] dc;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());


        // dxdy 정의
        dr = new int[] {0, 0, 1, 1};
        dc = new int[] {0, 1, 0, 1};

        zProcess(N,0, 0);

        System.out.println(result);
    }

    public static void zProcess(int level, int startRow, int startCol) {
        if (result > 0) {
            return;
        }
        if (level == 1) {
            for (int i = 0; i < 4; i++) {
                if (startRow+dr[i] == r && startCol+dc[i] == c) {
                    result = count;
                    return;
                }
                count++;
            }
        } else {
            for (int i = 0; i < 4; i++) {
                int posDivided = (int) Math.pow(2, level - 1);
                if (dr[i]*posDivided+startRow <= r
                        && dr[i]*posDivided+startRow + Math.pow(2, level-1) > r
                        && dc[i]*posDivided+startCol <= c
                        && dc[i]*posDivided+startCol + Math.pow(2, level-1) > c
                ) {
                    zProcess(level-1, dr[i]*posDivided+startRow, dc[i]*posDivided+startCol);
//                    System.out.println("zProcess : level :" + (level-1) + " start row : " + (dr[i]*posDivided+startRow) + " start col: " + (dc[i]*posDivided+startCol));
                } else {
//                    System.out.println("PASS : level :" + (level-1) + " start row : " + (dr[i]*posDivided+startRow) + " start col: " + (dc[i]*posDivided+startCol));
                    count += (int) ((int) Math.pow(2, level-1) * Math.pow(2, level-1));
//                    System.out.println("PASS 후 : " + count);
                }
            }

        }
    }

}
