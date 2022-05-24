package Inflearn.Section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	public int vex; // ����
	public int cost; // ��� (������ ����ġ ��!)

	Edge(int vex, int cost) {
		this.vex = vex;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost; // ��������
	}

}

public class S905 { //���ͽ�Ʈ�� �˰��� (����: 1�� �������� ��� ���������� �ּ� �Ÿ���� ���(������ impossible)
	/*
	  ���ͽ�Ʈ�� �˰���: ���� ����ġ�� ����(***) �׷����� �� ��忡�� �� ��� �������� �ִܰŸ��� ���ϴ� �˰���
	  --> �⺻������ �׸��� �˰������� ���� ���α׷��� ����� ����ϴ� �˰���
	      1) �湮���� ���� ��� �߿��� ���� ����� ���� ��带 ����(�׸���)
	      2) �ش� ���κ��� �� �� �ִ� ������ ����� ����(���� ���α׷���)
	 */
	static int n, m;
	static ArrayList<ArrayList<Edge>> graph;
	static int[] dis; // 1�� �������� i�������� ���� �ּҰŸ� ����

	public void solution(int v) {
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		/*
		  PriorityQueue() :
		    ���� ���� ������� �����Ͱ� ������ ���� �ƴ� �켱������ ���� �����ϰ� �� �켱������ ���� ������Ʈ�� ���� ������ �ڷᱸ��
		   (�Ϲ����� Queue�� ���� �����Ͱ� ���� ������ ����)
		  */
		
		pQ.offer(new Edge(v, 0)); // cost�� ���� �����ͺ��� ���ʴ�� poll() -> �������� ������
		dis[v] = 0;
		while (!pQ.isEmpty()) {
			Edge tmp = pQ.poll();
			int now = tmp.vex;
			int nowCost = tmp.cost;
			if (nowCost > dis[now]) { // ** ���� cost�� dis[now]���� �� ũ�� �Ʒ� for()�� �� �ʿ� ����! -> �̹� �ּҰŸ� �������Ƿ�
				continue;
			}
			for (Edge ob : graph.get(now)) { // now������ ����� ��� ���� �湮
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
		n = Integer.parseInt(st.nextToken()); // ������ ����
	    m = Integer.parseInt(st.nextToken()); // ������ ����
	    
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
		} // �Է� ���� : a�������� b�������� ���µ� c����� ��

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
