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
	/* 정점개수가 많아질 수록 인접행렬보다 ArrayList 사용하는게 훨씬 효율적!
	   --> 인접행렬은 정점 개수가 10000개면 10000개 모두 탐색해야함
	       But ArrayLists는 정점별로 리스트 안에 있는 값들만 탐색하면 됨 
     */

	public void DFS(int v) { // v번째 ArrayList
		if (v == n) {
			answer++;
		} else {
			for (int nv : graph.get(v)) { // nv( v번 ArrayList에 add한 값들)
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
		n = Integer.parseInt(st.nextToken()); // 정점 개수
		m = Integer.parseInt(st.nextToken()); // 간선 개수
		graph = new ArrayList<ArrayList<Integer>>(); // ArrayList 객체를 저장할 수 있는 ArrayList
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
			// *** 정수를 저장할 수 있는 ArrayList 객체 생성 --> 정점을 의미 ***
		}

		ch = new int[n + 1]; // 방문했는지 유무 check!

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b); // a --> b (a번 ArrayList에 접근해서 b를 add) 아이패드 확인!
		}
		ch[1] = 1;
		S.DFS(1);
		System.out.println(answer);

	}

}
