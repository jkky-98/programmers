

import java.io.*;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Member> heap = new PriorityQueue<>();

        int count = 0;
        for (int i = 0; i < N; i++) {
            count++;
            String[] split = br.readLine().split(" ");
            int age = Integer.parseInt(split[0]);
            String name = split[1];
            heap.add(new Member(age, name, count));
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (!heap.isEmpty()) {
            Member poll = heap.poll();
            bw.write(poll.age + " " + poll.name + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static class Member implements Comparable<Member>{
        int age;
        String name;
        int count;

        public Member(int age, String name, int count) {
            this.age = age;
            this.name = name;
            this.count = count;
        }

        @Override
        public int compareTo(Member o) {
            if (age == o.age) {
                return Integer.compare(count, o.count);
            }
            return Integer.compare(age, o.age);
        }
    }
}
