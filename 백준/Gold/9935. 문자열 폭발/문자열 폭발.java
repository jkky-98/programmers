
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringBuilder sb;
    static int pointer = 0;
    static char[] chars;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        chars = br.readLine().toCharArray();

        char[] bomb = br.readLine().toCharArray();
        char[] bombReverse = new char[bomb.length];
        int count = 0;
        for (int i = bomb.length-1; i >= 0 ; i--) {
            bombReverse[count] = bomb[i];
            count ++;
        }
        bomb = bombReverse;

        Deque<Character> stack = new ArrayDeque<>();

        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < chars.length; i++) {
            stack.push(chars[i]);

            if (chars[i] == bomb[0] && stack.size() >= bomb.length) {
                boolean bombButton = true;
                Deque<Character> cache = new ArrayDeque<>();

                for (int j = i - bomb.length + 1; j <= i; j++) {
                    char peekTmp = stack.pop();
                    cache.offer(peekTmp);

                    if (peekTmp != bomb[pointer]) {
                        bombButton = false;
                        break;
                    }
                    pointer++;
                }

                if (bombButton) {
                    cache.clear();
                } else {
                    while (!cache.isEmpty()) {
                        stack.push(cache.pollLast());
                    }
                }
                pointer = 0;
            }
        }
        sb = new StringBuilder();

        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                sb.append(stack.pollLast());
            }
            bw.write(sb.toString());
        } else {
            bw.write("FRULA");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}