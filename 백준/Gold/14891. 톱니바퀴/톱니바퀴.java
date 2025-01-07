import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static final int LEFT_HAND = 6;
    static final int RIGHT_HAND = 2;
    static CogWheel[] cogWheels = new CogWheel[4];
    static int K;
    static Deque<int[]> playQueue = new ArrayDeque<>();


    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        initCogWheel();
        initConnectCogWheel();
        initK();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int cogWheelNum = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());
            playQueue.offer(new int[]{cogWheelNum, direction});
            searchSpinRight(cogWheelNum, direction);
            searchSpinLeft(cogWheelNum, direction);

            while (!playQueue.isEmpty()) {
                int[] poll = playQueue.poll();
                cogWheels[poll[0]].spinCogWheel(poll[1]);
            }
        }
        int score = getScore();
        System.out.println(score);
    }
    private static int getScore() {
        return cogWheels[0].cogs.pollFirst() + cogWheels[1].cogs.pollFirst() * 2 + cogWheels[2].cogs.pollFirst() * 4 + cogWheels[3].cogs.pollFirst() * 8;
    }

    private static void searchSpinRight(int cogWheelNum, int direction) {
        // 오른쪽 먼저 전파
        CogWheel cogWheel = cogWheels[cogWheelNum];

        if (cogWheel.rightConnect != null) {
            int target = (int) cogWheel.rightConnect.cogs.toArray()[LEFT_HAND];
            int mine = (int) cogWheel.cogs.toArray()[RIGHT_HAND];

            if (target != mine) {
                playQueue.offer(new int[]{cogWheelNum + 1, direction * (-1)});
                searchSpinRight(cogWheelNum + 1, direction * (-1));
            }
        }
    }

    private static void searchSpinLeft(int cogWheelNum, int direction) {
        CogWheel cogWheel = cogWheels[cogWheelNum];

        if (cogWheel.leftConnect != null) {
            int target = (int) cogWheel.leftConnect.cogs.toArray()[RIGHT_HAND];
            int mine = (int) cogWheel.cogs.toArray()[LEFT_HAND];

            if (target != mine) {
                playQueue.offer(new int[]{cogWheelNum - 1, direction * (-1)});
                searchSpinLeft(cogWheelNum - 1, direction * (-1));
            }
        }
    }


    private static void initK() throws IOException {
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
    }

    private static void initCogWheel() throws IOException {
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            String[] split = st.nextToken().split("");
            cogWheels[i] = new CogWheel(split);
        }
    }

    private static void initConnectCogWheel() throws IOException {
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0:
                    cogWheels[0].rightConnect = cogWheels[1];
                    break;
                case 1:
                    cogWheels[1].leftConnect = cogWheels[0];
                    cogWheels[1].rightConnect = cogWheels[2];
                    break;
                case 2:
                    cogWheels[2].leftConnect = cogWheels[1];
                    cogWheels[2].rightConnect = cogWheels[3];
                    break;
                case 3:
                    cogWheels[3].leftConnect = cogWheels[2];
            }
        }
    }

    static class CogWheel {
        Deque<Integer> cogs = new ArrayDeque<>();

        CogWheel leftConnect;
        CogWheel rightConnect;

        public CogWheel(String[] inputData) {
            for (int i = 0; i < 8; i++) {
                cogs.offer(Integer.parseInt(inputData[i]));
            }
        }

        public void spinCogWheel(int direction) {
            switch (direction) {
                case 1:
                    cogs.offerFirst(cogs.pollLast());
                    break;
                case -1:
                    cogs.offerLast(cogs.pollFirst());
                    break;
            }
        }
    }
}
