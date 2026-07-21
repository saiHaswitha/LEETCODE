class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int ones = 0;
        for(char ch: s.toCharArray())
        {
            if(ch == '1')
            {
                ones++;
            }
        }

        String t = "1" + s + "1";

        List<int[]> runs = new ArrayList<>();

        int k=0;
        int n = t.length();

        while(k < n)
        {
            int j = k;
            while(j < n && t.charAt(j) == t.charAt(k))
            {
                j++;
            }
            runs.add(new int[]{t.charAt(k),j-k});
            k=j;
        }

        int ans = ones;

        //Check every 1-run,0-run,1-run,0-run pattern
        for(int i=2; i< runs.size()-1; i+=2)
        {
            int leftZero = runs.get(i-1)[1];
            int rightZero = runs.get(i+1)[1];

            ans = Math.max(ans, ones + leftZero + rightZero);

        }

        return ans;

        
    }
}