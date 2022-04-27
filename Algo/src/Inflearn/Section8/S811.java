package Inflearn.Section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{ //좌표
	public int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class S811 {// 미로탐색(BFS) 미로를 탈출하는 최단거리
	/* 0 0 0 0 0 0 0    // 1은 벽, 0은 통로! (1,1)에서 (7,7)로 이동 (1번 인덱스 부터 사용!)
       0 1 1 1 1 1 0
       0 0 0 1 0 0 0
       1 1 0 1 0 1 1
       1 1 0 0 0 0 1
       1 1 0 1 1 0 0
       1 0 0 0 0 0 0
    */
	
	static int[][] board, dis;
	// 상하좌우로 이동하기 위한 방향배열 설정
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	public void BFS(int x, int y) {
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(x, y));
		board[x][y] = 1; // 출발지점 체크(벽 만들기)
		
		while(!Q.isEmpty()) {
			Point tmp = Q.poll();
			
			for(int i = 0; i < 4; i++) { // 방향배열
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];				
				//경계선 안에 있는지 + 통로인지 확인
				if(nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
					board[nx][ny] = 1; // 벽 만들기
					Q.offer(new Point(nx, ny));
					dis[nx][ny] = dis[tmp.x][tmp.y] + 1; // 거리 저장 (현재지점 + 1)
				}
				
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		S811 S = new S811();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		board = new int[8][8]; // 1번 인덱스부터 사용!
		dis = new int[8][8]; // 최소거리 구하기 위한 배열 ( dis[n][n]에 (1,1)에서 (n,n)까지의 거리 저장)

		for (int i = 1; i <= 7; i++) { // 인덱스 범위 1~7
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 7; j++) { // 인덱스 범위 1~7
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		board[1][1] = 1;
		S.BFS(1, 1);

		if(dis[7][7] == 0) {
			System.out.println(-1);
		}else {
			System.out.println(dis[7][7]);
		}

	}

}
