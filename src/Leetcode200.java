public class Leetcode200 {
    public int numIslands(char[][] grid) {
        int res = 0;
        for(int i=0; i< grid.length; i++){
            for(int j=0; j<grid[0].length ;j++){
                if(numIslands(grid,i,j)==1){
                    res++;
                }
            }
        }
        return res;
    }

    public int numIslands(char[][] grid, int i, int j) {
        if(i<0 || j<0|| i> grid.length-1 || j>grid[0].length-1 || grid[i][j]=='0'){
            return 0;
        }
        grid[i][j] = '0';
        numIslands(grid, i, j-1);
        numIslands(grid, i+1, j);
        numIslands(grid, i, j+1);
        numIslands(grid, i-1, j);
        return 1;
    }
}
