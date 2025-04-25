class Solution {
    public String solution(String s) {
        
        String[] splits = s.split(" ");
        
        int min = 9999999;
        int max = -9999999;
        
        for (String item : splits) {
            int number = Integer.parseInt(item);  
            
            // min 갱신
            if (min > number) {
                min = number;
            }

            // max 갱신
            if (max < number) {
                max = number;
            }
        }
        
        return "" + min + " " + max;
    }
}