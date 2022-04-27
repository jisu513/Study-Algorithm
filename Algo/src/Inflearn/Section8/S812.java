package Inflearn.Section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S812 { //토마토(BFS)
	/* 0 0 -1 0 0 0      // 1-익은 토마토, 0-안익은 토마토, -1-빈 공간
       0 0 1 0 -1 0
       0 0 -1 0 0 0
       0 0 0 0 -1 1
    */
	static int n, m;
	static int[][] board, dis;
	// 상하좌우 방향배열 설정
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		dis = new int[m][n];
		board = new int[m][n];	
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

	}

}
