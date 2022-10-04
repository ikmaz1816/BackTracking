package backtracking;

import java.util.Scanner;

public class PrintDiagonal {
	public static void print(int[][] arr,int r,int c,String s)
	{
		if(r==0 && c==0)
		{
			System.out.println(s);
			return;
		}
		if(r>0 && c>0 && r==c)
			print(arr,r-1,c-1,s+'V');
		if(r>0)
				{
				print(arr,r-1,c,s+'D');
				}
		if(c>0)
			print(arr,r,c-1,s+'R');
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[][] arr=
			{
					{1,1,1},
					{1,1,1},
					{1,1,1}
			};
		print(arr,arr.length-1,arr.length-1,"");
		sc.close();
	}
}
