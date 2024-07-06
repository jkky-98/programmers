import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputNLR = br.readLine();

        // 입력 문자열을 공백으로 분리
        String[] NLR = inputNLR.split(" ");
        int N = Integer.parseInt(NLR[0]);
        int L = Integer.parseInt(NLR[1]);
        int R = Integer.parseInt(NLR[2]);

        Deque<Integer> process = new ArrayDeque<>();


        for (int i = 0; i < N; i++) {
            String inputItems = br.readLine();
            String[] Items = inputItems.split(" ");
            for (String item : Items) {
                process.offer(Integer.parseInt(item));
            }
        }


        TransferService transferService = new TransferService(N, L, R);
        transferService.init(process);

        int count = 0;
        while (true) {
            boolean step = transferService.step();
            if (!step) {
                break;
            }
            count++;
            transferService.initmapWatch();
        }
        System.out.println(count);


    }

    public static class Country {
        int population;
        int r;
        int c;

        public Country(int population, int r, int c) {
            this.population = population;
            this.r = r;
            this.c = c;
        }

    }


    public static class TransferService {
        List<List<Country>> map = new ArrayList<>();
        List<List<Boolean>> mapWatch = new ArrayList<>();
        int size;
        int L;
        int R;
        Deque<Country> deque = new ArrayDeque<>();
        Deque<Country> dequeForCalculate = new ArrayDeque<>();
        boolean isStep = false;

        public TransferService(int size, int l, int r) {
            this.size = size;
            L = l;
            R = r;
        }

        public void init(Deque<Integer> process) {
            for (int i = 0; i < size; i++) {
                map.add(new ArrayList<>());
                mapWatch.add(new ArrayList<>());
            }
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    Integer population = process.poll();
                    map.get(i).add(new Country(population.intValue(), i, j));
                    mapWatch.get(i).add(false);
                }
            }
        }

        public void initmapWatch() {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    mapWatch.get(i).set(j, false);
                }
            }
        }

        public boolean step() {
            isStep = false;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (mapWatch.get(i).get(j).equals(false)) {

                        if (isBFS(i,j)) {
                            isStep = true;
                            deque.offer(map.get(i).get(j));
                            mapWatch.get(i).set(j, true);
                            while (!deque.isEmpty()) {
                                Country poll = deque.poll();
                                dequeForCalculate.offer(poll);
                                BFS(poll.r, poll.c);
                            }
                            // deque의 모든 합 구하기
                            int sumPopulation = 0;
                            for (Country country : dequeForCalculate) {
                                sumPopulation += country.population;
                            }
                            int avg = sumPopulation / dequeForCalculate.size();
                            for (Country country : dequeForCalculate) {
                                map.get(country.r).get(country.c).population = avg;
                            }
                            dequeForCalculate.clear();
                        }
                    }

                }
            }
            return isStep;
        }

        private boolean isBFS(int row, int col) {
            Country my = map.get(row).get(col);
            if (col + 1 < size) {
                int diff = Math.abs(my.population - map.get(row).get(col + 1).population);
                if (diff >= L & diff <= R & mapWatch.get(row).get(col+1).equals(false)) {
                    return true;
                }
            }
            if (col - 1 >= 0) {
                int diff = Math.abs(my.population - map.get(row).get(col - 1).population);
                if (diff >= L & diff <= R & mapWatch.get(row).get(col-1).equals(false)) {
                    return true;
                }
            }

            if (row - 1 >= 0) {
                int diff = Math.abs(my.population - map.get(row - 1).get(col).population);
                if (diff >= L & diff <= R & mapWatch.get(row-1).get(col).equals(false)) {
                    return true;
                }
            }

            if (row + 1 < size) {
                int diff = Math.abs(my.population - map.get(row + 1).get(col).population);
                if (diff >= L & diff <= R & mapWatch.get(row+1).get(col).equals(false)) {
                    return true;
                }
            }

            return false;
        }

        private Deque<Country> BFS( int row, int col) {
            Country my = map.get(row).get(col);

            if (col + 1 < size) {
                int diff = Math.abs(my.population - map.get(row).get(col + 1).population);
                if (diff >= L & diff <= R & mapWatch.get(row).get(col+1).equals(false)) {
                    deque.offer(map.get(row).get(col+1));
                    mapWatch.get(row).set(col+1, true);
                }
            }
            if (col - 1 >= 0) {
                int diff = Math.abs(my.population - map.get(row).get(col - 1).population);
                if (diff >= L & diff <= R & mapWatch.get(row).get(col-1).equals(false)) {
                    deque.offer(map.get(row).get(col-1));
                    mapWatch.get(row).set(col-1, true);
                }
            }

            if (row - 1 >= 0) {
                int diff = Math.abs(my.population - map.get(row - 1).get(col).population);
                if (diff >= L & diff <= R & mapWatch.get(row-1).get(col).equals(false)) {
                    deque.offer(map.get(row-1).get(col));
                    mapWatch.get(row-1).set(col, true);
                }
            }
            if (row + 1 < size) {
                int diff = Math.abs(my.population - map.get(row + 1).get(col).population);
                if (diff >= L & diff <= R & mapWatch.get(row+1).get(col).equals(false)) {
                    deque.offer(map.get(row+1).get(col));
                    mapWatch.get(row+1).set(col, true);
                }
            }

            return deque;
        }

    }
}
