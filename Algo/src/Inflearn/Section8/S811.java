package Inflearn.Section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{ //��ǥ
	public int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class S811 {// �̷�Ž��(BFS) �̷θ� Ż���ϴ� �ִܰŸ�
	/* 0 0 0 0 0 0 0    // 1�� ��, 0�� ���! (1,1)���� (7,7)�� �̵� (1�� �ε��� ���� ���!)
       0 1 1 1 1 1 0
       0 0 0 1 0 0 0
       1 1 0 1 0 1 1
       1 1 0 0 0 0 1
       1 1 0 1 1 0 0
       1 0 0 0 0 0 0
    */
	
	static int[][] board, dis;
	// �����¿�� �̵��ϱ� ���� ����迭 ����
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	public void BFS(int x, int y) {
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(x, y));
		board[x][y] = 1; // ������� üũ(�� �����)
		
		while(!Q.isEmpty()) {
			Point tmp = Q.poll();
			
			for(int i = 0; i < 4; i++) { // ����迭
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];				
				//��輱 �ȿ� �ִ��� + ������� Ȯ��
				if(nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
					board[nx][ny] = 1; // �� �����
					Q.offer(new Point(nx, ny));
					dis[nx][ny] = dis[tmp.x][tmp.y] + 1; // �Ÿ� ���� (�������� + 1)
				}
				
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		S811 S = new S811();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		board = new int[8][8]; // 1�� �ε������� ���!
		dis = new int[8][8]; // �ּҰŸ� ���ϱ� ���� �迭 ( dis[n][n]�� (1,1)���� (n,n)������ �Ÿ� ����)

		for (int i = 1; i <= 7; i++) { // �ε��� ���� 1~7
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 7; j++) { // �ε��� ���� 1~7
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
