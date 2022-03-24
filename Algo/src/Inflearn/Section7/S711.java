package Inflearn.Section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S711 { // �׷����� �������
	static int n, m, answer = 0;
	static int[][] graph;
	static int[] ch;

	public void DFS(int v) {
		if (v == n) {
			answer++;
		} else {
			for (int i = 1; i <= n; i++) {
				if (graph[v][i] == 1 && ch[i] == 0) { // v�� ���� ����
					// graph[][]==1 �� v-->i ������ ������ �������� �ǹ�! && ch[]==0�� ���� �ش� ��忡 �湮 �������� �ǹ�
					ch[i] = 1; // �湮 ǥ��
					DFS(i);
					ch[i] = 0; // back ���� �� �湮 ��� ���� --> �����е� Ȯ��!
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		S711 S = new S711();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // ���� ����
		m = Integer.parseInt(st.nextToken()); // ���� ����

		graph = new int[n + 1][n + 1]; // ���� ��� (�ε��� 1���� ���!)
		ch = new int[n + 1]; // �湮�ߴ��� ���� check!
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = 1; // a --> b ������ �ǹ�
		}
		ch[1] = 1;
		S.DFS(1);
		System.out.println(answer);

	}

}
