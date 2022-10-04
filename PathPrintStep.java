package backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class PathPrintStep {

	public static void print(int[][] arr,int r,int c,String s,int[][] path,int step)
	{
		if(r==arr.length-1 && c==arr.length-1)
		{
			path[r][c]=step;
			for(int[] i : path
					)
			{
				System.out.println(Arrays.toString(i));
			}
			System.out.println(s);
			System.out.println();
			path[r][c]=0;
			return;
		}
		
		if(arr[r][c]==0)
			return;
		
		arr[r][c]=0;
		path[r][c]=step;
		
		if(r<arr.length-1 && c<arr.length-1 && r==c)
			print(arr,r+1,c+1,s+'V',path,step+1);
		if(r<arr.length-1)
			print(arr,r+1,c,s+'D',path,step+1);
		if(c<arr.length-1)
			print(arr,r,c+1,s+'R',path,step+1);
		if(r>0)
				{
				print(arr,r-1,c,s+'U',path,step+1);
				}
		if(c>0)
			print(arr,r,c-1,s+'L',path,step+1);
		arr[r][c]=1;
		path[r][c]=0;
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[][] arr=
			{
					{1,1,1},
					{1,0,1},
					{1,1,1}
			};
		int[][] path=new int[arr.length][arr.length];
		print(arr,0,0,"",path,1);
		sc.close();
	}

}
