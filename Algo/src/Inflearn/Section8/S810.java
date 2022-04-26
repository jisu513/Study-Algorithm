package Inflearn.Section8;

import java.io.*;
import java.util.*;

public class S810 { // 미로탐색(DFS) 미로를 탈출하는 경로의 가지수 (#S210 봉우리 찾기 문제 참고)
	/* 0 0 0 0 0 0 0    // 1은 벽, 0은 통로! (1,1)에서 (7,7)로 이동 (1번 인덱스 부터 사용!)
       0 1 1 1 1 1 0
       0 0 0 1 0 0 0
       1 1 0 1 0 1 1
       1 1 0 0 0 0 1
       1 1 0 1 1 0 0
       1 0 0 0 0 0 0
     */

	static int[][] board;
	static int answer = 0;
	//상하좌우로 이동하기 위한 방향배열 설정
	static int[] dx = {-1, 0, 1, 0}; 
	static int[] dy = {0, 1, 0, -1};
	
	public void DFS(int x, int y) {
		if(x == 7 && y == 7) {
			answer++;
		}else {
			for(int i = 0; i<4; i++) { //방향배열 개수
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				//경계선 안에 있는지 확인
				if(nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
					board[nx][ny] = 1;
					DFS(nx, ny);
					board[nx][ny] = 0;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		S810 S = new S810();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		board = new int[8][8]; // 1번 인덱스부터 사용!
		
		for(int i = 1; i <= 7; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= 7; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		board[1][1] = 1;
		S.DFS(1, 1);
		
		System.out.println(answer);
		

	}

}
