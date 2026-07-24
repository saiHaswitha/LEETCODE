import java.util.*;

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {

            int min = matrix[i][0];
            int col = 0;

            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    col = j;
                }
            }

            boolean flag = true;

            for (int k = 0; k < matrix.length; k++) {
                if (matrix[k][col] > min) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                ans.add(min);
            }
        }

        return ans;
    }
}