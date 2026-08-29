class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        int[] lps = new int[n];

        int length = 0; // length of previous longest prefix-suffix
        int i = 1;

        while (i < n) {
            if (s.charAt(i) == s.charAt(length)) {
                // Characters match — extend the current prefix-suffix
                lps[i] = ++length;
                i++;
            } else {
                if (length != 0) {
                    // Fallback: reuse previous best match, don't move i
                    length = lps[length - 1];
                } else {
                    // No match possible, move forward
                    lps[i] = 0;
                    i++;
                }
            }
        }

        // lps[n-1] holds the length of the longest happy prefix
        return s.substring(0, lps[n - 1]);
    }
}