class Solution {
    public int[] solution(String s) {
        
        int zeroCounter = 0;
        int binaryCounter = 0;
        
        while (!s.equals("1")) {
            int sLength = s.length();
            
            String sNew = s.replace("0", "");
            int sNewLength = sNew.length();
            
            int zeroCount = sLength - sNewLength;
            
            s = Integer.toBinaryString(sNewLength);
            
            zeroCounter += zeroCount;
            binaryCounter++;
        };
        
        return new int[] {binaryCounter, zeroCounter};
    }
}