package backtracking;

import java.util.Scanner;

public class MazeWithObstacle {

	public static void print(int[][] arr,int r,int c,String s)
	{
		if(r==arr.length-1 && c==arr.length-1)
		{
			System.out.println(s);
			return;
		}
		if(arr[r][c]==0)
			return;
		arr[r][c]=0;
		if(r<arr.length-1 && c<arr.length-1 && r==c)
			print(arr,r+1,c+1,s+'V');
		if(r<arr.length-1)
			print(arr,r+1,c,s+'D');
		if(c<arr.length-1)
			print(arr,r,c+1,s+'R');
		if(r>0)
				{
				print(arr,r-1,c,s+'U');
				}
		if(c>0)
			print(arr,r,c-1,s+'L');
		arr[r][c]=1;
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[][] arr=
			{
					{1,1,1},
					{1,0,1},
					{1,1,1}
			};
		print(arr,0,0,"");
		sc.close();
	}
}
