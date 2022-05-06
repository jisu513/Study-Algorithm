package Inflearn.Section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pppoint { // ��ǥ
	public int x, y;

	Pppoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class S814 { // ������ ���Ϸ���(BFS)
	/* ��� ����) 
	   1 1 0 0 0 1 0    => �� ������ 5��
       0 1 1 0 1 1 0
       0 1 0 0 0 0 0
       0 0 0 1 0 1 1
       1 1 0 1 1 0 0
       1 0 0 0 1 0 0
       1 0 1 0 1 0 0
    */
	
	static int n, answer = 0;
	// �ð����(�����¿�밢��)���� ���� ���� ����迭
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
	
	public void BFS(int x, int y, int[][] board) {
		Queue<Pppoint> Q = new LinkedList<>();
		Q.offer(new Pppoint(x, y));
		
		while(!Q.isEmpty()) {
			Pppoint tmp = Q.poll();
			for(int i = 0; i < 8; i++) { //�ð����
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if(nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) { // ���� 1�� ����Ǿ�����
					board[nx][ny] = 0; // ** 0���� ����!
					Q.offer(new Pppoint(nx, ny)); // (nx, ny) ��ǥ�� �ð���⵵ üũ!
				}
				
			}
		}
	}
	
	public void solution(int[][] board) { // board Ž�� ->S813 DFS�� ����
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 1) { //1�� ���� ������ �� ���� ���� -> ����Ǿ� �ִ� 1���� DFS()���� 0���� ����!
					answer++; 
					board[i][j] = 0; // ** 0���� �������ֱ�
					BFS(i, j, board); // �� ��ü �����ϴ� 1 Ȯ��!
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
