
import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        customSet customSet = new customSet(bw);
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            Service(split, customSet);
        }
        bw.flush();
        bw.close();
    }

    private static void Service(String[] split, customSet customSet) throws IOException {
        String order = split[0];
        if (split.length == 2) {
            int value = Integer.parseInt(split[1]);

            for (String cmd : new String[]{"add", "remove", "check", "toggle"}) {
                if (cmd.equals(order)) {
                    if (cmd.equals("add")) {
                        customSet.add(value);
                    } else if (cmd.equals("remove")) {
                        customSet.remove(value);
                    } else if (cmd.equals("check")) {
                        customSet.check(value);
                    } else if (cmd.equals("toggle")) {
                        customSet.toggle(value);
                    }
                    break;
                }
            }
        } else {

            for (String cmd : new String[]{"all", "empty"}) {
                if (cmd.equals(order)) {
                    if (cmd.equals("all")) {
                        customSet.all();
                    } else if (cmd.equals("empty")) {
                        customSet.empty();
                    }
                    break;
                }
            }
        }
    }


    public static class customSet {
        Set<Integer> set = new HashSet<>();
        BufferedWriter bw;

        public customSet(BufferedWriter bw) {
            this.bw = bw;
        }

        public void add(int value) {
            set.add(value);
        }

        public void remove(int value) {
            set.remove(value);
        }

        public void check(int value) throws IOException {
            if (set.contains(value)) {
                bw.write(1 + "\n");
            } else {
                bw.write(0 + "\n");
            }
        }

        public void toggle(int value) {
            if (set.contains(value)) {
                set.remove(value);
            } else {
                set.add(value);
            }
        }

        public void all() {
            set.clear();
            for (int i = 1; i < 21; i++) {
                set.add(i);
            }
        }

        public void empty() {
            set.clear();
        }
    }
}
