import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int totalPickCount = picks[0] + picks[1] + picks[2];
        int maxUseMinerals = Math.min(totalPickCount * 5, minerals.length);

        // 광물 5개씩 묶어서 chunk 생성
        List<MineralChunk> chunks = new ArrayList<>();
        for (int i = 0; i < maxUseMinerals; i += 5) {
            int dia = 0, iron = 0, stone = 0;
            for (int j = i; j < i + 5 && j < minerals.length; j++) {
                switch (minerals[j]) {
                    case "diamond" -> dia++;
                    case "iron" -> iron++;
                    case "stone" -> stone++;
                }
            }
            chunks.add(new MineralChunk(dia, iron, stone));
        }

        // 피로도가 높은 순으로 정렬 (diamond > iron > stone)
        chunks.sort((a, b) -> b.getWeight() - a.getWeight());

        int fatigue = 0;
        int chunkIndex = 0;

        for (int i = 0; i < picks[0] && chunkIndex < chunks.size(); i++, chunkIndex++) {
            fatigue += chunks.get(chunkIndex).getFatigue("dia");
        }
        for (int i = 0; i < picks[1] && chunkIndex < chunks.size(); i++, chunkIndex++) {
            fatigue += chunks.get(chunkIndex).getFatigue("iron");
        }
        for (int i = 0; i < picks[2] && chunkIndex < chunks.size(); i++, chunkIndex++) {
            fatigue += chunks.get(chunkIndex).getFatigue("stone");
        }

        return fatigue;
    }

    // 광물 chunk 객체
    static class MineralChunk {
        int dia, iron, stone;

        public MineralChunk(int dia, int iron, int stone) {
            this.dia = dia;
            this.iron = iron;
            this.stone = stone;
        }

        // 각 곡괭이로 캘 때 피로도
        public int getFatigue(String pick) {
            return switch (pick) {
                case "dia" -> dia + iron + stone;
                case "iron" -> dia * 5 + iron + stone;
                case "stone" -> dia * 25 + iron * 5 + stone;
                default -> 0;
            };
        }

        // 정렬 기준: diamond > iron > stone
        public int getWeight() {
            return dia * 25 + iron * 5 + stone;
        }
    }
}
