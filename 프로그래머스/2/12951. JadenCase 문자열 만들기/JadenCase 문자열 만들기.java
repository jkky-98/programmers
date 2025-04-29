import java.util.*;

class Solution {
    public String solution(String s) {
        String[] words = s.split(" ", -1);
        
        int count = 0;
        for (String word : words) {
            if (word.length() == 0) {  
                words[count] = "";
            }
            else if (Character.isDigit(word.substring(0,1).charAt(0))) {
                String num = word.substring(0,1);
                String subword = word.substring(1).toLowerCase();
                String sum = num + subword;
                words[count] = sum;
            } else {
                String first = word.substring(0,1).toUpperCase();
                String other = word.substring(1).toLowerCase();
                String sum = first + other;
                words[count] = sum;
            }
            count++;
        }
        
        return String.join(" ", words);
    }
}
