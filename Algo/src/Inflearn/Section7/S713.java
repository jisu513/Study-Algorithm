package Inflearn.Section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S713 { // 그래프 최단거리 (BFS) **최단거리는 BFS 사용!
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
		n = Integer.parseInt(st.nextToken()); // 정점 개수
		m = Integer.parseInt(st.nextToken()); // 간선 개수
		graph = new ArrayList<ArrayList<Integer>>(); // ArrayList 객체를 저장할 수 있는 ArrayList
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
			// *** 정수를 저장할 수 있는 ArrayList 객체 생성 --> 정점을 의미 ***
		}

		ch = new int[n + 1]; // 방문했는지 유무 check!
		dis = new int[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b); // a --> b (a번 ArrayList에 접근해서 b를 add) 아이패드 확인!
		}

		S.BFS(1);
		for (int i = 2; i <= n; i++) {
			System.out.println(i + " : " + dis[i]);
		}

	}

}
