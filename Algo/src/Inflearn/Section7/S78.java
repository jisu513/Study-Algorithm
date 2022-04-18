package Inflearn.Section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S78 {// �۾��� ã�� (BFS)
	static int[] dis = { 1, -1, 5 }; // �� ���� �̵��� �� �ִ� �Ÿ�
	static int[] check; // �湮 �ߴ� ��忡 �� �ٽ� �湮���� ���� �� �ְ� �湮 �ߴ��� ���� check
	Queue<Integer> Q = new LinkedList<>();

	public int BFS(int s, int e) {
		check = new int[100001]; // ��ǥ 1 ~ 10000 ����
		check[s] = 1; // ������ġ check
		Q.offer(s); // ���� ��ġ(��� ��ġ) Q�� ����
		int L = 0; // Level

		while (!Q.isEmpty()) {
			int len = Q.size(); // Level������ ��� ����
			for (int i = 0; i < len; i++) {
				int x = Q.poll(); // ���� ���
				for (int j = 0; j < dis.length; j++) {
					int nx = x + dis[j]; // �ڽ� ���
					if (nx == e) {// �۾��� ��ġ�� ������ ����! (���� ����� Level�� L, nx�� �ڽĳ���̹Ƿ� L+1 ���ֱ�!)
						return L + 1;
					}
					if (nx >= 1 && nx <= 10000 && check[nx] == 0) {
						// �ڽĳ�尡 if���� �����ϸ� Q�� ����! (�̹� �湮�ߴ� ���� �ٽ� �湮X)
						check[nx] = 1;
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
		int s = Integer.parseInt(st.nextToken()); // ��� ��ġ
		int e = Integer.parseInt(st.nextToken()); // �۾�ġ ��ġ

		System.out.println(S.BFS(s, e));

	}

}
