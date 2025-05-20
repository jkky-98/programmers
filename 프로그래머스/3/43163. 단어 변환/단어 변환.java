import java.util.*;

class Solution {
    
    static Deque<Node> queue; 
    
    public int solution(String begin, String target, String[] words) {
        queue = new ArrayDeque<>();
        
        Node beginNode = new Node(0, begin, new HashSet<>());
        
        queue.offer(beginNode);
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            
            String word = node.word;
            int depth = node.depth;
            
            if (word.equals(target)) {
                return depth;
            }
            
            List<String> nextNodes = getNextNode(node, words);
            
            for (String nextNodeWord : nextNodes) {
                queue.offer(new Node(depth + 1, nextNodeWord, node.history));
            }
        }
        
        return 0;
    }
    // 다음 노드 리스트업
    static List<String> getNextNode(Node node, String[] words) {
        
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            if (!node.history.contains(word)) {
                if (checkChange(node.word, word)) {
                    result.add(word);
                }
            }
        }
        
        return result;
    }
    
    static boolean checkChange(String word, String change) {
        String[] words = word.split("");
        String[] changes = change.split("");
        
        int count = 0;
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(changes[i])) {
                count++;
            }
        }
        
        if (count == (words.length - 1)) {
            return true;
        } else {
            return false;
        }
    }
    
    static class Node {
        public int depth;
        public String word;
        public Set<String> history = new HashSet<>();
        
        public Node (int depth, String word, Set<String> prevHistory) {
            this.depth = depth;
            this.word = word;
            
            for (String prevHistoryWord : prevHistory) {
                history.add(prevHistoryWord);
            }
            
            history.add(this.word);
        }
    }
}