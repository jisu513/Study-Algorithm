package Inflearn.Section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S78 {// �۾��� ã�� (BFS)
	int answer = 0;
	int[] dist = { 1, -1, 5 };
	int[] ch; // Q�� �̹� �ִ� �� ���� �� Ȯ��! -> �ߺ��� ���� �ٽ� ���� ����

	Queue<Integer> Q = new LinkedList<>();

	public int BFS(int s, int e) {
		ch = new int[10001];
		ch[s] = 1; // ��� ����(������ ��ġ)
		Q.offer(s);
		int L = 0;
		while (!Q.isEmpty()) {
			int len = Q.size();
			for (int i = 0; i < len; i++) {
				int x = Q.poll(); // ���� ���
				for (int j = 0; j < dist.length; j++) {
					int nx = x + dist[j]; // �ڽ� ���
					if(nx == e) { // �۾����� ã�Ҵ��� Ȯ��!
						return L+1; // nx�� �ڽĳ���̹Ƿ� ������ +1 �������!
					}
					if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
						ch[nx] = 1;
						Q.offer(nx);
					}
				}
			}
			L++;
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {
		S78 S = new S78();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		System.out.println(S.BFS(s, e));

	}

}
