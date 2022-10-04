package backtracking;

public class KNight {
	public static void display(boolean[][] board)
	{
		for(boolean[] i : board)
		{
			for(boolean j :i)
			{
				if(j)
					System.out.print("K");
				else
					System.out.print("X");
			}
			System.out.println();
		}
	}
	public static void print(boolean[][] board,int r,int c,int target)
	{
		if(target==0)
		{
			display(board);
			System.out.println();
			return;
		}
		if(r==board.length-1 && c==board.length)
		{
			return;
		}
		if(c==board.length)
		{
			r++;
			c=0;
		}
		if(isSafe(board,r,c))
		{
			board[r][c]=true;
			print(board,r,c+1,target-1);
			board[r][c]=false;
		}
		print(board,r,c+1,target);
	}
	private static boolean isSafe(boolean[][] board, int r, int c) {
		if(isValid(board,r-2,c+1))
		{
			if(board[r-2][c+1])
				return false;
		}
		if(isValid(board,r-2,c-1))
		{
			if(board[r-2][c-1])
				return false;
		}
		if(isValid(board,r-1,c+2))
		{
			if(board[r-1][c+2])
				return false;
		}
		if(isValid(board,r-1,c-2))
		{
			if(board[r-1][c-2])
				return false;
		}
		return true;
	}
	private static boolean isValid(boolean[][] board,int r,int c)
	{
		if(r>=0 && r<board.length && c>=0 && c<board.length)
		{
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		boolean[][] board =new boolean[4][4];
		print(board,0,0,4);
	}
}
