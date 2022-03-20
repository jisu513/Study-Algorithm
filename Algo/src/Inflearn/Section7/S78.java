package Inflearn.Section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S78 {// 송아지 찾기 (BFS)
	int answer = 0;
	int[] dist = {1, -1, 5};
	int[] check; // 이미 한 번 추가한 자식노드와 동일한 값의 다른 자식노드를 또 추가하는 없게 하기 위해 체크!
	Queue<Integer> Q = new LinkedList<>();
	public int BFS(int s, int e) {
		check = new int[10001]; // 좌표 범위 1~10000
		check[s]  = 1; // 내 위치에 대한 좌표 체크
		Q.offer(s);
		int L = 0; // 노드의 Level
		
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i = 0; i<len; i++) { //Q의 크기만큼 반복
				int current = Q.poll(); // 현재 노드
				for(int j = 0; j<dist.length; j++) { 
					int child = current + dist[j]; // dist[] 배열 값 만큼 이동한(더한) 값 자식노드로 설정
					if(child == e) { // 송아지 찾았는지 확인!
						return L+1; // chiled는 자식노드 이고 현재 Level은 부모노드에 맞춰있기 때문에 +1 해줘야함!
					}
					if(current >= 1 && current <= 10000 && check[child] == 0) {
						check[child] = 1; // 자식노드 값 체크
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
