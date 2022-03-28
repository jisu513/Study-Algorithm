package Inflearn.Section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S713 { // �׷��� �ִܰŸ� (BFS) **�ִܰŸ��� BFS ���!
	static int n, m;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] ch, dis;

	public void BFS(int v) {
		Queue<Integer> q = new LinkedList<>();
		ch[v] = 1;
		dis[v] = 0;
		q.offer(v);
		while (!q.isEmpty()) {
			int cv = q.poll();
			for (int nv : graph.get(cv)) {
				if (ch[nv] == 0) {
					ch[nv] = 1;
					q.offer(nv);
					dis[nv] = dis[cv] + 1;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		S713 S = new S713();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // ���� ����
		m = Integer.parseInt(st.nextToken()); // ���� ����
		graph = new ArrayList<ArrayList<Integer>>(); // ArrayList ��ü�� ������ �� �ִ� ArrayList
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
			// *** ������ ������ �� �ִ� ArrayList ��ü ���� --> ������ �ǹ� ***
		}

		ch = new int[n + 1]; // �湮�ߴ��� ���� check!
		dis = new int[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b); // a --> b (a�� ArrayList�� �����ؼ� b�� add) �����е� Ȯ��!
		}

		S.BFS(1);
		for (int i = 2; i <= n; i++) {
			System.out.println(i + " : " + dis[i]);
		}

	}

}
