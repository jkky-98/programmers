class Solution {
    public int solution(String[][] book_time) {
        int timeCount = 60 * 24 + 10;
        int[] timeMap = new int[timeCount];
        
        for (int i=0; i<book_time.length; i++) {
            int[] timeRangeIdx = parseTimeRange(book_time[i]);
            System.out.println(timeRangeIdx[0]);
            System.out.println(timeRangeIdx[1]);
            toDiffArray(timeMap, timeRangeIdx);
        }
        prefixSum(timeMap);
        
        return searchMaxRoom(timeMap);
    }
    private int searchMaxRoom(int[] timeMap) {
        int max = 0;
        for (int value : timeMap) {
            if (value > max) {
                max = value;
            }
        }
        
        return max;
    }
    
    private void prefixSum(int[] timeMap) {
        for (int i = 1; i < timeMap.length; i++) {
            timeMap[i] = timeMap[i-1] + timeMap[i];
        }
    }
    
    private void toDiffArray(int[] timeMap, int[] timeRangeIdx) {
        int startIdx = timeRangeIdx[0];
        int endIdx = timeRangeIdx[1];
        
        timeMap[startIdx]++;
        timeMap[endIdx+1]--;
    }
    
    private int[] parseTimeRange(String[] timeRange) {
        String start = timeRange[0];
        String end = timeRange[1];
        
        int startIdx = parseTime(start);
        int endIdx = parseTime(end);
        
        int realEndIdx = 0;
        realEndIdx = endIdx + 9;
        
        return new int[] {startIdx, realEndIdx};
    }
    
    private int parseTime(String time) {
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);
        
        int index = hour * 60 + minute;
        return index;
    }
}