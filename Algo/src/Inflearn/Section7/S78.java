package Inflearn.Section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S78 {// �۾��� ã�� (BFS)
	int answer = 0;
	int[] dist = {1, -1, 5};
	int[] check; // �̹� �� �� �߰��� �ڽĳ��� ������ ���� �ٸ� �ڽĳ�带 �� �߰��ϴ� ���� �ϱ� ���� üũ!
	Queue<Integer> Q = new LinkedList<>();
	public int BFS(int s, int e) {
		check = new int[10001]; // ��ǥ ���� 1~10000
		check[s]  = 1; // �� ��ġ�� ���� ��ǥ üũ
		Q.offer(s);
		int L = 0; // ����� Level
		
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i = 0; i<len; i++) { //Q�� ũ�⸸ŭ �ݺ�
				int current = Q.poll(); // ���� ���
				for(int j = 0; j<dist.length; j++) { 
					int child = current + dist[j]; // dist[] �迭 �� ��ŭ �̵���(����) �� �ڽĳ��� ����
					if(child == e) { // �۾��� ã�Ҵ��� Ȯ��!
						return L+1; // chiled�� �ڽĳ�� �̰� ���� Level�� �θ��忡 �����ֱ� ������ +1 �������!
					}
					if(current >= 1 && current <= 10000 && check[child] == 0) {
						check[child] = 1; // �ڽĳ�� �� üũ
						Q.offer(child);
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
