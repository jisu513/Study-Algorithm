package Inflearn.Section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	public int vex;
	public int cost;

	Edge(int vex, int cost) {
		this.vex = vex;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}

}

public class S905 {
	static int n, m;
	static ArrayList<ArrayList<Edge>> graph;
	static int[] dis;

	public void solution(int v) {
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		pQ.offer(new Edge(v, 0));
		dis[v] = 0;
		while (!pQ.isEmpty()) {
			Edge tmp = pQ.poll();
			int now = tmp.vex;
			int nowCost = tmp.cost;
			if (nowCost > dis[now]) {
				continue;
			}
			for (Edge ob : graph.get(now)) {
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
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
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
		}

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
