package backtracking;

public class NQueen {
	public static void display(boolean[][] board)
	{
		for(boolean[] i : board)
		{
			for(boolean j :i)
			{
				if(j)
					System.out.print("Q");
				else
					System.out.print("X");
			}
			System.out.println();
		}
	}
	public static void print(boolean[][] board,int r)
	{
		if(r==board.length)
		{
			display(board);
			System.out.println();
			return;
		}
		for(int c=0;c<board.length;c++)
		{
			if(isSafe(board,r,c))
			{
				board[r][c]=true;
				print(board,r+1);
				board[r][c]=false;
			}
		}
	}
      private static boolean isSafe(boolean[][] board, int r, int c) {
		for(int i=0;i<r;i++)
		{
			if(board[i][c])
				return false;
		}
		
		int maxright=Math.min(r, c);
		for(int i=1;i<=maxright;i++)
		{
			if(board[r-i][c-i])
				return false;
		}
		int maxleft=Math.min(r, board.length-1-c);
		for(int i=1;i<=maxleft;i++)
		{
			if(board[r-i][c+i])
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
			boolean[][] board =new boolean[4][4];
			print(board,0);
		}
}
