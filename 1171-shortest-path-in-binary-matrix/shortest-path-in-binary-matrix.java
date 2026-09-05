class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        // Edge Cases: If start or end is blocked, return -1
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        // Queue to store coordinates and current path length: {row, col, distance}
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 1});
        grid[0][0] = 1; // Mark the starting cell as visited

        // Arrays representing the 8 possible movements (row offset, col offset)
        int[][] directions = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1},   // Up, Down, Left, Right
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}   // Diagonals
        };

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curRow = current[0];
            int curCol = current[1];
            int curDist = current[2];

            // If we reached the bottom-right corner, return the path length
            if (curRow == n - 1 && curCol == n - 1) {
                return curDist;
            }

            // Explore all 8 adjacent neighbors
            for (int[] dir : directions) {
                int neiRow = curRow + dir[0];
                int neiCol = curCol + dir[1];

                // Check boundaries and if the cell is clear (0)
                if (neiRow >= 0 && neiRow < n && neiCol >= 0 && neiCol < n && grid[neiRow][neiCol] == 0) {
                    queue.offer(new int[]{neiRow, neiCol, curDist + 1});
                    grid[neiRow][neiCol] = 1; // Mark as visited
                }
            }
        }

        // Destination is unreachable
        return -1;
    }
}