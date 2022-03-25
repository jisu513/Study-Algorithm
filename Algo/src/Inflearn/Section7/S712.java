package Inflearn.Section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S712 {
	static int n, m, answer = 0;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] ch;

	public void DFS(int v) {
		if (v == n) {
			answer++;
		} else {
			for (int nv : graph.get(v)) {
				if (ch[nv] == 0) {
					ch[nv] = 1;
					DFS(nv);
					ch[nv] = 0;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		S712 S = new S712();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // ���� ����
		m = Integer.parseInt(st.nextToken()); // ���� ����
		graph = new ArrayList<ArrayList<Integer>>(); // ���� ��� (�ε��� 1���� ���!)
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
		}

		ch = new int[n + 1]; // �湮�ߴ��� ���� check!

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b); // a --> b ������ �ǹ�
		}
		ch[1] = 1;
		S.DFS(1);
		System.out.println(answer);

	}

}
