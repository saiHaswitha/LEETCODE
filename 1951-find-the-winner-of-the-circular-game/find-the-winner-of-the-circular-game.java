class Solution {
    public int findTheWinner(int n, int k) {
        // optimal solution
       int ans = 0;

        for (int i = 2; i <= n; i++) {
            ans = (ans + k) % i;
        }

        return ans + 1;
        // using queue solution

    //     Queue<Integer> q=new LinkedList<>();
    //    for(int i=1;i<=n;i++){
    //     q.add(i);
    //    } 
    //    while(q.size()>1){
    //     for(int i=1;i<=k-1;i++){
    //         q.add(q.remove());
    //     }
    //     q.remove();
    //    }
    //    return q.peek();
    }
    
}