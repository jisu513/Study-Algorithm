package Inflearn.Section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S78 {// 송아지 찾기 (BFS)
	static int[] dis = { 1, -1, 5 }; // 한 번에 이동할 수 있는 거리
	static int[] check; // 방문 했던 노드에 또 다시 방문하지 않을 수 있게 방문 했는지 유무 check
	Queue<Integer> Q = new LinkedList<>();

	public int BFS(int s, int e) {
		check = new int[100001]; // 좌표 1 ~ 10000 까지
		check[s] = 1; // 시작위치 check
		Q.offer(s); // 시작 위치(사람 위치) Q에 삽입
		int L = 0; // Level

		while (!Q.isEmpty()) {
			int len = Q.size(); // Level마다의 노드 개수
			for (int i = 0; i < len; i++) {
				int x = Q.poll(); // 현재 노드
				for (int j = 0; j < dis.length; j++) {
					int nx = x + dis[j]; // 자식 노드
					if (nx == e) {// 송아지 위치와 같으면 리턴! (현재 노드의 Level은 L, nx는 자식노드이므로 L+1 해주기!)
						return L + 1;
					}
					if (nx >= 1 && nx <= 10000 && check[nx] == 0) {
						// 자식노드가 if문에 부합하면 Q에 삽입! (이미 방문했던 노드는 다시 방문X)
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
		int s = Integer.parseInt(st.nextToken()); // 사람 위치
		int e = Integer.parseInt(st.nextToken()); // 송아치 위치

		System.out.println(S.BFS(s, e));

	}

}
