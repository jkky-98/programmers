import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<NumberPacket> heap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (heap.isEmpty()) {
                    System.out.println("0");
                } else {
                    NumberPacket poll = heap.poll();
                    System.out.println(poll.originNumber);
                }
            } else {
                heap.add(new NumberPacket(input));
            }
        }
    }

    public static class NumberPacket implements Comparable<NumberPacket>{
        int originNumber;
        int absNumber;

        public NumberPacket(int originNumber) {
            this.originNumber = originNumber;
            absNumber = Math.abs(originNumber);
        }

        @Override
        public int compareTo(NumberPacket o) {
            if (this.absNumber != o.absNumber) {
                return Integer.compare(this.absNumber, o.absNumber);
            }
            return Integer.compare(this.originNumber, o.originNumber);
        }
    }
}
