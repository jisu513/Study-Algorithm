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
	int[] ch;

	Queue<Integer> Q = new LinkedList<>();

	public int BFS(int s, int e) {
		ch = new int[10001]; // 좌표 점위 1~10000 까지
		ch[s] = 1;
		Q.offer(s);
		int L = 0; // Level
		while (!Q.isEmpty()) {
			int len = Q.size();
			for (int i = 0; i < len; i++) {
				int cur = Q.poll(); // 현재 노드
				for (int j = 0; j < dist.length; j++) {
					int ncur = cur + dist[j]; // 자식 노드
					if (ncur == e) { // 송아지 찾았는지 확인!
						return L + 1; // ncur은 자식노드 이고 현재 Level은 부모노드에 맞춰있기 때문에 +1 해줘야함!
					}
					if (cur >= 1 && cur <= 10000 && ch[ncur] == 0) { // 이미 Q에 들어 있는 값은 중복으로 삽입X
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
