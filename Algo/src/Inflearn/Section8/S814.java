package Inflearn.Section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pppoint { // 좌표
	public int x, y;

	Pppoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class S814 { // 섬나라 아일랜드(BFS)
	/* 출력 예시) 
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
	
	public void BFS(int x, int y, int[][] board) {
		Queue<Pppoint> Q = new LinkedList<>();
		Q.offer(new Pppoint(x, y));
		
		while(!Q.isEmpty()) {
			Pppoint tmp = Q.poll();
			for(int i = 0; i < 8; i++) { //시계방향
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if(nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) { // 섬은 1로 연결되어있음
					board[nx][ny] = 0; // ** 0으로 변경!
					Q.offer(new Pppoint(nx, ny)); // (nx, ny) 좌표의 시계방향도 체크!
				}
				
			}
		}
	}
	
	public void solution(int[][] board) { // board 탐색 ->S813 DFS와 동일
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 1) { //1을 만날 때마다 섬 갯수 세기 -> 연결되어 있는 1들은 DFS()에서 0으로 변경!
					answer++; 
					board[i][j] = 0; // ** 0으로 변경해주기
					BFS(i, j, board); // 섬 전체 구성하는 1 확인!
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		S814 S = new S814();

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
