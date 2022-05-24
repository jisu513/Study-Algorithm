package Inflearn.Section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	public int vex; // 정점
	public int cost; // 비용 (간선의 가중치 값!)

	Edge(int vex, int cost) {
		this.vex = vex;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost; // 오름차순
	}

}

public class S905 { //다익스트라 알고리즘 (문제: 1번 정점에서 모든 정점으로의 최소 거리비용 출력(없으면 impossible)
	/*
	  다익스트라 알고리즘: 음의 가중치가 없는(***) 그래프의 한 노드에서 각 모든 노드까지의 최단거리를 구하는 알고리즘
	  --> 기본적으로 그리디 알고리즘이자 동적 프로그래밍 기법을 사용하는 알고리즘
	      1) 방문하지 않은 노드 중에서 가장 비용이 적은 노드를 선택(그리디)
	      2) 해당 노드로부터 갈 수 있는 노드들의 비용을 갱신(동적 프로그래밍)
	 */
	static int n, m;
	static ArrayList<ArrayList<Edge>> graph;
	static int[] dis; // 1번 정점에서 i정점까지 가는 최소거리 저장

	public void solution(int v) {
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		/*
		  PriorityQueue() :
		    먼저 들어온 순서대로 데이터가 나가는 것이 아닌 우선순위를 먼저 결정하고 그 우선순위가 높은 엘리먼트가 먼저 나가는 자료구조
		   (일반적인 Queue는 들어온 데이터가 먼저 나가는 구조)
		  */
		
		pQ.offer(new Edge(v, 0)); // cost가 가장 작은것부터 차례대로 poll() -> 오름차순 정렬함
		dis[v] = 0;
		while (!pQ.isEmpty()) {
			Edge tmp = pQ.poll();
			int now = tmp.vex;
			int nowCost = tmp.cost;
			if (nowCost > dis[now]) { // ** 현재 cost가 dis[now]보다 더 크면 아래 for()을 할 필요 없음! -> 이미 최소거리 구했으므로
				continue;
			}
			for (Edge ob : graph.get(now)) { // now정점에 연결된 모두 정점 방문
				if (dis[ob.vex] > nowCost + ob.cost) {
					dis[ob.vex] = nowCost + ob.cost;
					pQ.offer(new Edge(ob.vex, nowCost + ob.cost));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		S905 S = new S905();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 정점의 개수
	    m = Integer.parseInt(st.nextToken()); // 간선의 개수
	    
		graph = new ArrayList<ArrayList<Edge>>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Edge>());
		}

		dis = new int[n + 1];

		Arrays.fill(dis, Integer.MAX_VALUE);
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Edge(b, c));
		} // 입력 예시 : a정점에서 b정점으로 가는데 c비용이 듬

		S.solution(1);
		
		for (int i = 2; i <= n; i++) {
			if (dis[i] != Integer.MAX_VALUE) {
				System.out.println(i + " : " + dis[i]);
			} else {
				System.out.println(i + " : impossible");
			}
		}

	}

}
