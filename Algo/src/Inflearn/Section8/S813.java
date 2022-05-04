package Inflearn.Section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S813 { // ������ ���Ϸ���(DFS) 
	
	/* ��� ����) ���� 1�� ǥ��(�����¿�밢������ ���� �Ǿ��ִ� ��) 0�� �ٴ�
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

	public void DFS(int x, int y, int[][] board) {
		for (int i = 0; i < 8; i++) { // �����¿�밢�� �� 8���� Ȯ��
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
				board[nx][ny] = 0; // ** 0���� �������ֱ�!
				DFS(nx, ny, board); // �� ��ü �����ϴ� 1 Ȯ��!
			}
		}

	}
	public void solution(int[][] board) { // board Ž��
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 1) { //1�� ���� ������ �� ���� ���� -> ����Ǿ� �ִ� 1���� DFS()���� 0���� ����!
					answer++; 
					board[i][j] = 0; // ** 0���� �������ֱ�
					DFS(i, j, board); // �� ��ü �����ϴ� 1 Ȯ��!
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
