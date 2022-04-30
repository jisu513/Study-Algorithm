package Inflearn.Section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S813 {

	public static void main(String[] args) throws IOException {
		S813 S = new S813();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());

		int[][] board = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

	}

}
