
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String xyzinput = br.readLine();
        StringTokenizer st = new StringTokenizer(xyzinput, " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());

        List<tomatoPlate> tomatoPlates = new ArrayList<>();
        for (int i = 0; i < z; i++) {
            tomatoPlate tomatoPlate = new tomatoPlate(x, y);
            for (int j = 0; j < y; j++) {
                String tomatoString = br.readLine();
                StringTokenizer stLine = new StringTokenizer(tomatoString, " ");
                List<Integer> tmp = new ArrayList<>();
                while (stLine.hasMoreTokens()) {
                    tmp.add(Integer.parseInt(stLine.nextToken()));
                }
                tomatoPlate.placeOf(tmp);
            }
            tomatoPlates.add(tomatoPlate);
        }

        // 타워 생성
        tomatoTower tomatoTower = new tomatoTower();
        // 토마토 층 넣기
        tomatoTower.setTower(tomatoPlates);
        ripeTomato ripeTomato = new ripeTomato(Main.tomatoTower.getTower(), x, y, z);
        ripeTomato.setProcess();
        ripeTomato.runProcess();


        if (ripeTomato.checkAll()) {
            System.out.println((ripeTomato.getDay() - 1));
        } else {
            System.out.println(-1);
        }

    }

    static class ripeTomato {
        private List<List<List<Integer>>> tower;
        private int x;
        private int y;
        private int z;
        private Deque<List<Integer>> deque = new ArrayDeque<>();
        private int day;

        public int getDay() {
            return day;
        }

        public ripeTomato(List<List<List<Integer>>> tower, int x, int y, int z) {
            this.tower = tower;
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public void setProcess() {
            for (int i=0; i < z; i++) {
                for (int j=0; j < y; j++) {
                    for (int k=0; k < x; k++) {
                        if (tower.get(i).get(j).get(k).equals(1)) {
                            deque.add(List.of(i,j,k));
                        }
                    }
                }
            }
        }

        public boolean checkAll() {
            for (int i=0; i < z; i++) {
                for (int j=0; j < y; j++) {
                    for (int k=0; k < x; k++) {
                        if (tower.get(i).get(j).contains(0)) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        public void runProcess() {
            ArrayDeque<List<Integer>> memory = new ArrayDeque<>();
            do {
                memory.clear();
                while(!deque.isEmpty()) {
                    List<Integer> tomato = deque.poll();
                    Deque<List<Integer>> riping = riping(tomato.get(0), tomato.get(1), tomato.get(2));
                    memory.addAll(riping);
                }
                deque.addAll(memory);
                day++;
            } while (!memory.isEmpty());
        }

        private Deque<List<Integer>> riping(Integer Z, Integer Y, Integer X) {
            ArrayDeque<List<Integer>> dequeTmp = new ArrayDeque<>();
            int z = Z;
            int x = X;
            int y = Y;
            tower.get(z).get(y).set(x, 9);

            if (z + 1 <= this.z-1) {
                if (tower.get(z+1).get(y).get(x) == 0)
                {
                    tower.get(z+1).get(y).set(x, 1);
                    dequeTmp.add(List.of(z+1,y,x));
                }
            }
            if (z - 1 >= 0) {
                if (tower.get(z-1).get(y).get(x) == 0)
                {
                    tower.get(z-1).get(y).set(x, 1);
                    dequeTmp.add(List.of(z-1,y,x));
                }
            }
            if (y + 1 <= this.y-1) {
                if (tower.get(z).get(y+1).get(x) == 0)
                {
                    tower.get(z).get(y+1).set(x, 1);
                    dequeTmp.add(List.of(z,y+1,x));
                }
            }
            if (y - 1 >= 0) {
                if (tower.get(z).get(y-1).get(x) == 0)
                {
                    tower.get(z).get(y-1).set(x, 1);
                    dequeTmp.add(List.of(z,y-1,x));
                }
            }
            if (x + 1 <= this.x-1) {
                if (tower.get(z).get(y).get(x+1) == 0)
                {
                    tower.get(z).get(y).set(x+1, 1);
                    dequeTmp.add(List.of(z,y,x+1));
                }
            }
            if (x - 1 >= 0) {
                if (tower.get(z).get(y).get(x-1) == 0)
                {
                    tower.get(z).get(y).set(x-1, 1);
                    dequeTmp.add(List.of(z,y,x-1));
                }
            }
            return dequeTmp;
        }
    }

    static class tomatoPlate {
        int x;
        int y;
        List<List<Integer>> plate = new ArrayList<>(new ArrayList<>());
        int count = 0;

        public tomatoPlate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void placeOf(List<Integer> inputList) {
            plate.add(inputList);
            count++;
        }

        public List<List<Integer>> getPlate() {
            return plate;
        }

    }

    static class tomatoTower {

        private static List<List<List<Integer>>> tower = new ArrayList<>();


        public void setTower(List<tomatoPlate> plates) {
            for (tomatoPlate plate : plates) {
                tower.add(plate.getPlate());
            }
        }

        public static List<List<List<Integer>>> getTower() {
            return tower;
        }
    }

}