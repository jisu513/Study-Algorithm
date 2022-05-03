package Inflearn.Section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S813 {
	static int n, answer = 0;
	// 시계방향으로 돌기 위한 방향배열
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public void DFS(int x, int y, int[][] board) {
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
				board[nx][ny] = 0;
				DFS(nx, ny, board);
			}
		}

	}

	public void solution(int[][] board) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 1) {
					answer++;
					board[i][j] = 0;
					DFS(i, j, board);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		S813 S = new S813();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		S.solution(arr);
		System.out.println(answer);

	}

}
