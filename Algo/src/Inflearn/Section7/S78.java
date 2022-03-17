package Inflearn.Section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S78 {// 송아지 찾기 (BFS)
	int answer = 0;
	int[] dist = { 1, -1, 5 };
	int[] ch; // Q에 이미 있는 지 없는 지 확인! -> 중복된 값은 다시 넣지 않음

	Queue<Integer> Q = new LinkedList<>();

	public int BFS(int s, int e) {
		ch = new int[10001];
		ch[s] = 1; // 출발 지점(현수의 위치)
		Q.offer(s);
		int L = 0;
		while (!Q.isEmpty()) {
			int len = Q.size();
			for (int i = 0; i < len; i++) {
				int x = Q.poll(); // 현재 노드
				for (int j = 0; j < dist.length; j++) {
					int nx = x + dist[j]; // 자식 노드
					if(nx == e) { // 송아지를 찾았는지 확인!
						return L+1; // nx는 자식노드이므로 현재노드 +1 해줘야함!
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
