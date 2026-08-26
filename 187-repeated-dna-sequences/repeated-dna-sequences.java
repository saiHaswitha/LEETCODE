import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1
        String s1 = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(sol.findRepeatedDnaSequences(s1));
        // Expected Output: [AAAAACCCCC, CCCCCAAAAA]

        // Test case 2
        String s2 = "AAAAAAAAAAAAA";
        System.out.println(sol.findRepeatedDnaSequences(s2));
        // Expected Output: [AAAAAAAAAA]
    }
}

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        for (int i = 0; i + 10 <= s.length(); i++) {
            String sub = s.substring(i, i + 10);
            if (!seen.add(sub)) {
                repeated.add(sub);
            }
        }

        return new ArrayList<>(repeated);
    }
}