package Inflearn.Section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S711 { // 그래프와 인접행렬
	static int n, m, answer = 0;
	static int[][] graph;
	static int[] ch;

	public void DFS(int v) {
		if (v == n) {
			answer++;
		} else {
			for (int i = 1; i <= n; i++) {
				if (graph[v][i] == 1 && ch[i] == 0) { // v는 현재 정점
					// graph[][]==1 은 v-->i 방향의 간선이 존재함을 의미! && ch[]==0은 아직 해당 노드에 방문 안했음을 의미
					ch[i] = 1; // 방문 표시
					DFS(i);
					ch[i] = 0; // back 했을 때 방문 취소 설정 --> 아이패드 확인!
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		S711 S = new S711();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 정점 개수
		m = Integer.parseInt(st.nextToken()); // 간선 개수

		graph = new int[n + 1][n + 1]; // 인접 행렬 (인덱스 1부터 사용!)
		ch = new int[n + 1]; // 방문했는지 유무 check!
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = 1; // a --> b 방향을 의미
		}
		ch[1] = 1;
		S.DFS(1);
		System.out.println(answer);

	}

}
