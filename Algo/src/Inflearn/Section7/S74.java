package Inflearn.Section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S74 { // 피보나치 수열(메모이제이션)
	// 메모이제이션이란? 
		/* 동일한 계산을 반복해야 할 경우 한 번 계산한 결과를 메모리에 저장해 두었다가 꺼내 씀으로써 
		 * 중복 계산을 방지할 수 있게 하는 기법 -> 동적 계획법의 핵심이 되는 기술
		 */
	static int[] fibo;

	public int DFS(int n) { // 성능 매우 안좋음..!
		if(fibo[n] > 0) //*메모이제이션 
			return fibo[n];
		/* --> 이 if문 추가하면 시간 훨씬 더 단축! (이미 구해놓은 DFS()값은 그대로 가져다 사용하므로! -> 없으면 하나하나 다시 다 수행함) 
		 * DFS()에 호출 되어서 배열에 값을 넣어둔 n값은 다시 DFS()를 호출하지 않고 fibo[]값을 리턴해줌 -> 성능 훨씬 좋아짐!!
		 */
		
 		if (n == 1) {
			return fibo[n] = 1;
		} else if (n == 2) {
			return fibo[n] = 1;
		} else {
			return fibo[n] = DFS(n - 2) + DFS(n - 1);
		}

	}

	public static void main(String[] args) throws IOException {
		S74 S = new S74();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		fibo = new int[n + 1]; // 0번 인덱스는 사용X -> 1번 인덱스부터 사용하므로 n+1까지!
		S.DFS(n);
		for (int i = 1; i <= n; i++) {
			System.out.print(fibo[i] + " "); 
		} // DFS는 1번 호출하고 fibo[]에 저장한 값을 리턴!
		
		//fibo[] 배열 없이 S.DFS()를 하나하나 출력하면 시간이 더 오래걸림
		/*for (int i = 1; i <= n; i++) {
			System.out.print(S.DFS(i) + " ");  ->시간 더 오래 걸림!(DFS를 n번 호출)
			
		}*/ 

	}

}
