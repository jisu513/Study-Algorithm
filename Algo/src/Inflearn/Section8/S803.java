package Inflearn.Section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S803 { //최대 점수 구하기 (DFS)
	static int answer = Integer.MIN_VALUE, n, m;
	boolean flsg = false;

	public void DFS(int L, int sum, int Stime, int[] ps, int[] pt) {
		if(Stime > m) { // 제한시간을 초과하면 더 할 필요없이 끝내기
			return;
		}
		if (n == L) { // 부분집합 완성
			answer = Math.max(answer, sum);

		} else {
			DFS(L + 1, sum + ps[L], Stime + pt[L], ps, pt); // 문제를 풀 때
			DFS(L + 1, sum, Stime, ps, pt); //안 풀 때
		}

	}

	public static void main(String[] args) throws IOException {
		S803 S = new S803();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 문제 개수
		m = Integer.parseInt(st.nextToken()); // 제한 시간

		
		int[] score = new int[n]; // ps
		int[] time = new int[n]; // pt	
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			score[i] = Integer.parseInt(st.nextToken());
			time[i] = Integer.parseInt(st.nextToken());
		}

		S.DFS(0, 0, 0, score, time); // DFS(L, score 합, time 합, score[], time[])
		System.out.println(answer);
	}

}
