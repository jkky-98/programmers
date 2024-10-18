

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static List<List<String>> mapNormal = new ArrayList<>();
    static List<List<String>> mapBlindness = new ArrayList<>();
    static List<List<Boolean>> visitedNormal = new ArrayList<>();
    static List<List<Boolean>> visitedBlindness = new ArrayList<>();
    static Deque<int[]> deque = new ArrayDeque<>();
    static int countNormal;
    static int countBlindness;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        setMap();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visitedNormal.get(i).get(j).equals(false)) {
                    countNormal++;
                    BFS(visitedNormal, mapNormal, i, j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visitedBlindness.get(i).get(j).equals(false)) {
                    countBlindness++;
                    BFS(visitedBlindness, mapBlindness, i, j);
                }
            }
        }

        System.out.println(countNormal + " " + countBlindness);
    }
    static class Place {
        String color;
        int row;
        int col;

        public Place(String color, int row, int col) {
            this.color = color;
            this.row = row;
            this.col = col;
        }
    }
    private static void BFS(List<List<Boolean>> visited, List<List<String>> map, int startRow, int startCol) {
        String indexColor = map.get(startRow).get(startCol);
        Deque<Place> deque = new ArrayDeque<>();

        int[] rdel = {1, -1, 0, 0};
        int[] cdel = {0, 0, 1, -1};

        deque.offer(new Place(indexColor, startRow, startCol));

        while (!deque.isEmpty()) {
            Place poll = deque.poll();
            for (int i = 0; i < 4; i++) {
                if (0 <= poll.row + rdel[i] &&
                    N > poll.row + rdel[i] &&
                    0 <= poll.col + cdel[i] &&
                    N > poll.col + cdel[i]
                ) {
                    if (!visited.get(poll.row + rdel[i]).get(poll.col + cdel[i])
                            && map.get(poll.row + rdel[i]).get(poll.col + cdel[i]).equals(indexColor)) {
                        deque.offer(new Place(indexColor, poll.row + rdel[i], poll.col + cdel[i]));
                        visited.get(poll.row + rdel[i]).set(poll.col + cdel[i], true);
                    }
                }
            }
        }

    }

    private static void setMap() throws IOException {
        for (int i = 0; i < N; i++) {
            mapBlindness.add(new ArrayList<>());
            mapNormal.add(new ArrayList<>());
            visitedNormal.add(new ArrayList<>());
            visitedBlindness.add(new ArrayList<>());
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                String place = String.valueOf(line.charAt(j));

                mapNormal.get(i).add(place);

                visitedNormal.get(i).add(false);
                visitedBlindness.get(i).add(false);

                if (place.equals("G")) {
                    mapBlindness.get(i).add("R");
                } else {
                    mapBlindness.get(i).add(place);
                }
            }
        }
    }
}
