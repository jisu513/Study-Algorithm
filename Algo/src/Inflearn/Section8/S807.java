package Inflearn.Section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S807 { // 조합의 경우의 수(메모이제이션) nCr = n-1Cr-1 + c-1Cr
	// 메모이제이션이란? 
	/* 동일한 계산을 반복해야 할 경우 한 번 계산한 결과를 메모리에 저장해 두었다가 꺼내 씀으로써 
	 * 중복 계산을 방지할 수 있게 하는 기법 -> 동적 계획법의 핵심이 되는 기술
	 */
	
	static int n, r;
	int[][] dy = new int[35][35]; // 메모이제이션을 위해 사용 (없으면 성능 굉장히 저하됨) [35]까지 한 이유는 문지에서 주어져서임
	public int DFS(int n, int r) {
		// 메모이제이션 사용
		if(dy[n][r] > 0) {
			return dy[n][r];
		}
		
		// 조합의 수 구하기
		if(n == r || r == 0) {
			return 1;
		}else {
			return dy[n][r] =  DFS(n-1, r-1) + DFS(n-1, r); // 조합: nCr = n-1Cr-1 + c-1Cr
		}
		
	}
	
	// 메모이제이션 X --> 성능 매우 저하됨
	/*  조합: nCr = n-1Cr-1 + c-1Cr
	 * public int DFS(int n, int r) {
		if(n == r || r == 0) {
			return 1;
		}else {
			return DFS(n-1, r-1) + DFS(n-1, r);
		}
		
	}*/

	public static void main(String[] args) throws IOException {
		S807 S = new S807();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 범위: 3 <= n <= 33
		r = Integer.parseInt(st.nextToken());
		
		System.out.println(S.DFS(n, r));

	}

}
