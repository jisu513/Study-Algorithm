package Inflearn.Section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S74 { // 피보나치 수열
	static int[] fibo;

	public int DFS(int n) { // 성능 매우 안좋음..!
		if(fibo[n] > 0)
			return fibo[n]; // --> 이 if문 추가하면 시간 훨씬 더 단축! (이미 구해놓은 DFS()값은 그대로 가져다 사용하므로! -> 없으면 하나하나 다시 다 수행함)
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
		}
		
		//fibo[] 배열 없이 S.DFS()를 하나하나 출력하면 시간이 더 오래걸림
		/*for (int i = 1; i <= n; i++) {
			System.out.print(S.DFS(i) + " ");  ->시간 더 오래 걸림!
		}*/ 

	}

}
