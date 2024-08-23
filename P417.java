public class P417 {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacificReachable = new boolean[m][n];
        boolean[][] atlanticReachable = new boolean[m][n];

        // Start DFS from all Pacific border cells (top row and left column)
        for (int i = 0; i < m; i++) {
            dfs(heights, pacificReachable, i, 0);
            dfs(heights, atlanticReachable, i, n - 1);
        }

        // Start DFS from all Atlantic border cells (bottom row and right column)
        for (int j = 0; j < n; j++) {
            dfs(heights, pacificReachable, 0, j);
            dfs(heights, atlanticReachable, m - 1, j);
        }

        // Collect all cells that can flow to both Pacific and Atlantic
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    result.add(cell);
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, boolean[][] reachable, int row, int col) {
        int m = heights.length;
        int n = heights[0].length;
        reachable[row][col] = true;

        // Define directions for moving up, down, left, right
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            // Check bounds and ensure that we can flow from the current cell to the next one
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                    !reachable[newRow][newCol] && heights[newRow][newCol] >= heights[row][col]) {
                dfs(heights, reachable, newRow, newCol);
            }
        }
    }
}
