import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static int result;
	static class Point{
		int i,j;

		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			result=987654321;
			stk = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(stk.nextToken());//¶³¾î¶ß¸®´Â º®µ¹
			int W = Integer.parseInt(stk.nextToken());//¿­
			int H = Integer.parseInt(stk.nextToken());//Çà
			int arr[][]=new int[H][W];
			
			for (int i = 0; i < H; i++) {
				stk = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					arr[i][j]=Integer.parseInt(br.readLine());
				}
			}
			
			for (int i = 0; i < W; i++) {
				Select(0,N,arr,i);
			}
			
			System.out.println("#"+(tc+1)+" "+result);
		}
	}

	private static void Select(int i, int n, int[][] arr, int i2) {
		// TODO Auto-generated method stub
		HashSet<E>
	}
}
