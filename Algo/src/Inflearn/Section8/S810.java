package Inflearn.Section8;

import java.io.*;
import java.util.*;

public class S810 { // �̷�Ž��(DFS) �̷θ� Ż���ϴ� ����� ������ (#S210 ���츮 ã�� ���� ����)
	/* 0 0 0 0 0 0 0    // 1�� ��, 0�� ���! (1,1)���� (7,7)�� �̵� (1�� �ε��� ���� ���!)
       0 1 1 1 1 1 0
       0 0 0 1 0 0 0
       1 1 0 1 0 1 1
       1 1 0 0 0 0 1
       1 1 0 1 1 0 0
       1 0 0 0 0 0 0
     */

	static int[][] board;
	static int answer = 0;
	//�����¿�� �̵��ϱ� ���� ����迭 ����
	static int[] dx = {-1, 0, 1, 0}; 
	static int[] dy = {0, 1, 0, -1};
	
	public void DFS(int x, int y) {
		if(x == 7 && y == 7) {
			answer++;
		}else {
			for(int i = 0; i<4; i++) { //����迭 ����
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				//��輱 �ȿ� �ִ��� Ȯ��
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
		
		board = new int[8][8]; // 1�� �ε������� ���!
		
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
