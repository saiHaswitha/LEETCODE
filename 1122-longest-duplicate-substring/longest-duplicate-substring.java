// We use binary seach and Rabin-Karp algorithm
class Solution {
    private String searchDuplicate(String s, int length) {
        if(length == 0) return "";

        long mod = (1L << 32) - 1;
        long base = 26;
        long hash = 0;
        long pow = 1;
        for(int i = 0; i < length; i++){
            hash = (hash * base + (s.charAt(i) - 'a')) % mod;
            pow = (pow * base) % mod;
        }
        HashMap<Long, List<Integer>> seen = new HashMap();
        seen.computeIfAbsent(hash, k -> new ArrayList<>()).add(0);
        for(int i = length; i < s.length(); i++){
            hash = (hash * base - (s.charAt(i - length) - 'a') * pow % mod + mod) % mod;
            hash = (hash + (s.charAt(i) - 'a')) % mod;
        
            if(seen.containsKey(hash)){
                for(int start : seen.get(hash)){
                    if(s.substring(start, start + length).equals(s.substring(i - length + 1, i + 1))){
                        return s.substring(start, start + length);
                    }
                }
            }
            seen.computeIfAbsent(hash, k -> new ArrayList<>()).add(i - length + 1);
        }
        return "";
    }

    public String longestDupSubstring(String s) {
        int l = 1, r = s.length();
        String result = "";
        while(l < r) {
            int mid = (l + r) / 2;
            String dup = searchDuplicate(s, mid);
            if(!dup.isEmpty()){
                result = dup;
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return result;
    }
}