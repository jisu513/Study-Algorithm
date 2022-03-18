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
	int[] ch;

	Queue<Integer> Q = new LinkedList<>();

	public int BFS(int s, int e) {
		ch = new int[10001]; // ��ǥ ���� 1~10000 ����
		ch[s] = 1;
		Q.offer(s);
		int L = 0; // Level
		while (!Q.isEmpty()) {
			int len = Q.size();
			for (int i = 0; i < len; i++) {
				int cur = Q.poll(); // ���� ���
				for (int j = 0; j < dist.length; j++) {
					int ncur = cur + dist[j]; // �ڽ� ���
					if (ncur == e) { // �۾��� ã�Ҵ��� Ȯ��!
						return L + 1; // ncur�� �ڽĳ�� �̰� ���� Level�� �θ��忡 �����ֱ� ������ +1 �������!
					}
					if (cur >= 1 && cur <= 10000 && ch[ncur] == 0) { // �̹� Q�� ��� �ִ� ���� �ߺ����� ����X
						ch[ncur] = 1;
						Q.offer(ncur);
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
