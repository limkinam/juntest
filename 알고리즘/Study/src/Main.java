import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int arr[][] = new int[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			int c = Integer.parseInt(stk.nextToken());
			arr[a][b] = Math.min(arr[a][b], c);
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					continue;
				if (arr[i][j] == 0)
					arr[i][j] = 987654321;
			}
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (arr[i][j] == 987654321)
					System.out.print(0 + " ");
				else
					System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		// arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
	}
}