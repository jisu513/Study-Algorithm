package Inflearn.Section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S815 { // ���� ��� �Ÿ�(DFS)
	/* 1-��, 2-������
	  0 1 2 0
      1 0 2 1
      0 2 1 2
      2 0 1 2
     */
	static int n, m;
	static int[][] board;
	public void DFS() {
		
	}

	public static void main(String[] args) throws IOException {
		S815 S = new S815();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken()); // m���� ������

		board = new int[n+1][n+1]; // n*nũ��, �� ��ȣ 1���� ����
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				board[i][j] = Integer.parseInt(br.readLine());
			}
		}

	}

}
