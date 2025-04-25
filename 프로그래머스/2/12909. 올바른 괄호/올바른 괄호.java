class Solution {
    boolean solution(String s) {
        String[] splits = s.split("");
        
        int count = 0;
        
        for (String item : splits) {
            if (item.equals("(")) {
                count++;
            } else {
                count--;
            }
            
            if (count < 0) {
                return false;
            }
            
        }
        
        if (count != 0) {
            return false;
        }

        return true;
    }
}