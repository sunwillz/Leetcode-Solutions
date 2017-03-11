package leetcode;

public class Program463 {

	public static void main(String[] args) {
		int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
		System.out.println(islandPerimeter(grid));
	}
	public static int islandPerimeter(int[][] grid) {
        int island=0;
        int neighbour=0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if(grid[i][j]==1){
					island++;
					
					if(i+1<grid.length&&grid[i+1][j]==1) neighbour++;
					if(j+1<grid[i].length&&grid[i][j+1]==1) neighbour++;
				}
				
			}
		}
		return island*4-neighbour*2;
    }

}
