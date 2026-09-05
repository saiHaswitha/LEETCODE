class Solution {
    public int climbStairs(int n) {
        // Base cases: if there are 1 or 2 stairs, the answer is just n.
        if (n <= 2) return n;
        
        // 'a' is ways to reach (n-2)
        // 'b' is ways to reach (n-1)
        int a = 1, b = 2; 
        
        // Start calculating from step 3 up to n
        for (int i = 3; i <= n; i++) {
            int c = a + b; // Current step is the sum of the previous two
            a = b;         // Slide 'a' forward
            b = c;         // Slide 'b' forward
        }
        
        // By the end of the loop, 'b' holds the answer for step n
        return b;
    }
}