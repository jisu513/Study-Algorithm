package Inflearn.Section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Ppoint { // ��ǥ
	public int x, y;

	Ppoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class S812 { // �丶��(BFS) S811�� ����
	/*
	 * 0 0 -1 0  0 0   //  1: ���� �丶��, 0: ������ �丶��, -1: �� ���� 
	 * 0 0  1 0 -1 0
	 * 0 0 -1 0  0 0 
	 * 0 0  0 0 -1 1
	 */
	static int n, m;
	static int[][] board, dis;
	// �����¿� ����迭 ����
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static Queue<Ppoint> Q = new LinkedList<>();

	public void BFS() {
		while(!Q.isEmpty()) {
			Ppoint tmp = Q.poll();		
			for(int i = 0; i < 4; i++) { // ����迭
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];				
				
				if(nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
					board[nx][ny] = 1; 
					Q.offer(new Ppoint(nx, ny));
					dis[nx][ny] = dis[tmp.x][tmp.y] + 1; // �丶�䰡 �ʹµ� �ɸ� �Ⱓ (1�Ϻ��� ����)
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

		dis = new int[n][m]; // dis[m][n]�� �ִ� �丶�䰡 �ʹµ� �ɸ� �ð� ����
		board = new int[n][m]; // �丶��
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) { // �丶�䰡 �ִٸ�
					Q.offer(new Ppoint(i, j)); // Q�� ����!
				}
			}
		}

		S.BFS();

		// BFS()���� �Ŀ��� �� ���� �丶�䰡 �ִ��� ������ Ȯ��
		boolean flag = true; // true�� ���� �丶�丸 �ִٴ� �ǹ�
		int answer = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 0) { // BFS()�� �� �����ߴµ��� ������ �丶�䰡 �ִ� ��� (-1 ���)
					flag = false;
				}
			}
		}

		// ���
		if (flag) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					answer = Math.max(answer, dis[i][j]); // �ִ��� ��� �丶�䰡 �ʹµ� �ɸ� �ð�
				}
			}
			System.out.println(answer);
		} else {
			System.out.println(-1);
		}

	}

}
