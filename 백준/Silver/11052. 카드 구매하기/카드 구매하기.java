

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static List<Integer> cards;
    static List<List<Integer>> dp;
    static Deque<Stack> process;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dp = new ArrayList<>();
        process = new ArrayDeque<>();

        setCards();
        initDP();

        while (!process.isEmpty()) {
            goOn();
        }
        System.out.println(dp.get(N).get(0));
    }

    private static void goOn() {
        Deque<Stack> newProcess = new ArrayDeque<>();
        while (!process.isEmpty()) {
            Stack poll = process.poll();
            int size = poll.size;
            int price = poll.price;

            if (price < dp.get(size).get(0)) {
                continue;
            }

            int loopIndex = cards.size() - 1 - size;

            for (int i = 1; i <= loopIndex ; i++) {
                if (dp.get(size + i).get(0) >= price + cards.get(i)) {

                } else {
                    if (size + i <= cards.size()) {
                        Stack newStack = new Stack(size + i, price + cards.get(i));
                        newProcess.offer(newStack);

                        dp.get(size + i).set(0, price + cards.get(i));
                    }
                }
            }
        }

        process = newProcess;
    }

    private static void initDP() {

        for (int i = 0; i < cards.size(); i++) {
            dp.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            dp.get(i).add(cards.get(i));
            process.offer(new Stack(i, cards.get(i)));
        }

    }

    private static void setCards() throws IOException {
        st = new StringTokenizer(br.readLine());
        cards = new ArrayList<>();
        cards.add(0);
        for (int i = 0; i < N; i++) {
            cards.add(Integer.parseInt(st.nextToken()));
        }
    }

    static class Stack {
        @Override
        public String toString() {
            return "Stack{" +
                    "size=" + size +
                    ", price=" + price +
                    '}';
        }

        public int size;
        public int price;

        public Stack(int size, int price) {
            this.size = size;
            this.price = price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Stack stack = (Stack) o;
            return size == stack.size && price == stack.price;
        }

        @Override
        public int hashCode() {
            return Objects.hash(size, price);
        }
    }
}
