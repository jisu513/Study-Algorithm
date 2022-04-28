package Inflearn.Section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Ppoint { // 좌표
	public int x, y;

	Ppoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class S812 { // 토마토(BFS) S811과 유사
	/*
	 * 0 0 -1 0  0 0   //  1: 익은 토마토, 0: 안익은 토마토, -1: 빈 공간 
	 * 0 0  1 0 -1 0
	 * 0 0 -1 0  0 0 
	 * 0 0  0 0 -1 1
	 */
	static int n, m;
	static int[][] board, dis;
	// 상하좌우 방향배열 설정
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static Queue<Ppoint> Q = new LinkedList<>();

	public void BFS() {
		while(!Q.isEmpty()) {
			Ppoint tmp = Q.poll();		
			for(int i = 0; i < 4; i++) { // 방향배열
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];				
				
				if(nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
					board[nx][ny] = 1; 
					Q.offer(new Ppoint(nx, ny));
					dis[nx][ny] = dis[tmp.x][tmp.y] + 1; // 토마토가 익는데 걸린 기간 (1일부터 시작)
				}
				
			}
		}
	}

	public static void main(String[] args) throws IOException {
		S812 S = new S812();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		dis = new int[n][m]; // dis[m][n]에 있는 토마토가 익는데 걸린 시간 저장
		board = new int[n][m]; // 토마토
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) { // 토마토가 있다면
					Q.offer(new Ppoint(i, j)); // Q에 삽입!
				}
			}
		}

		S.BFS();

		// BFS()수행 후에도 안 익은 토마토가 있는지 없는지 확인
		boolean flag = true; // true는 익은 토마토만 있다는 의미
		int answer = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 0) { // BFS()를 다 수행했는데도 안익은 토마토가 있는 경우 (-1 출력)
					flag = false;
				}
			}
		}

		// 출력
		if (flag) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					answer = Math.max(answer, dis[i][j]); // 최댓값이 모든 토마토가 익는데 걸린 시간
				}
			}
			System.out.println(answer);
		} else {
			System.out.println(-1);
		}

	}

}
