package Inflearn.Section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S813 { // 섬나라 아일랜드(DFS) 
	
	/* 출력 예시) 섬은 1로 표시(상하좌우대각선으로 연결 되어있는 곳) 0은 바다
	   1 1 0 0 0 1 0    => 섬 갯수는 5개
       0 1 1 0 1 1 0
       0 1 0 0 0 0 0
       0 0 0 1 0 1 1
       1 1 0 1 1 0 0
       1 0 0 0 1 0 0
       1 0 1 0 1 0 0
       */
	
	static int n, answer = 0;
	// 시계방향(상하좌우대각선)으로 돌기 위한 방향배열
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public void DFS(int x, int y, int[][] board) {
		for (int i = 0; i < 8; i++) { // 상하좌우대각선 총 8방향 확인
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
				board[nx][ny] = 0; // ** 0으로 변경해주기!
				DFS(nx, ny, board); // 섬 전체 구성하는 1 확인!
			}
		}

	}
	public void solution(int[][] board) { // board 탐색
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 1) { //1을 만날 때마다 섬 갯수 세기 -> 연결되어 있는 1들은 DFS()에서 0으로 변경!
					answer++; 
					board[i][j] = 0; // ** 0으로 변경해주기
					DFS(i, j, board); // 섬 전체 구성하는 1 확인!
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
