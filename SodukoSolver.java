package backtracking;

public class SodukoSolver {
	public static void display(int[][] board)
	{
		for(int[] i : board)
		{
			for(int j :i)
			{
				System.out.print(j+ " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int[][] arr={{3, 0, 6, 5, 0, 8, 4, 0, 0}, 
		         {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
		         {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
		         {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
		         {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
		         {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
		         {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
		         {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
		         {0, 0, 5, 2, 0, 6, 3, 0, 0}};
		if(solve(arr,0,0))
		{
			display(arr);
		}
		else
			System.out.println("Sodoku Not Solved");
	}
	public static boolean isSafe(int[][] board,int r,int c,int num)
	{
		for(int i=0;i<r;i++)
		{
			if(board[r][i]==num)
				return false;
		}
		for(int i=0;i<board.length;i++)
		{
			if(board[i][c]==num)
				return false;
		}
		int sqrt=(int)Math.sqrt(board.length);
		int rowstart= r - (r%sqrt);
		int colstart=c - (c%sqrt);
		
		for(int i=rowstart;i<rowstart+3;i++)
		{
			for(int j=colstart;j<colstart+3;j++)
			{
				if(board[i][j]==num)
					return false;
			}
		}
		return true;
	}
	private static boolean solve(int[][] arr,int r,int c) {
		if(r==arr.length-1 && c==arr.length)
			return true;
		
		if(c==arr.length)
		{
			r++;
			c=0;
		}
		if(arr[r][c]!=0)
			return solve(arr,r,c+1);
		for(int i=1;i<=9;i++)
		{
			if(isSafe(arr,r,c,i))
			{
				arr[r][c]=i;
				if(solve(arr,r,c+1))
				{
					return true;
				}
			}
			arr[r][c]=0;
		}
		return false;
	}
}
