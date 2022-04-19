package Inflearn.Section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S808 { // 수열 추측하기
	static int[] b; // 컴비네이션 값 저장!
	static int[] p; // 순열 저장
	static int[] check; // 중복 순열이 아니기 때문에 필요 (S806 - 순열구하기 )
	static int n, f;
	boolean flag = false;
	int[][] dy = new int[35][35]; // 메모이제이션을 위해 필요!

	public int combi(int n, int r) {
		if (dy[n][r] > 0)
			return dy[n][r];
		if (n == r || r == 0) {
			return 1;
		} else {
			return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
		}

	}

	public void DFS(int L, int sum) {
		if (flag)
			return;
		if (L == n) {
			if (sum == f) {
				for (int x : p) {
					System.out.print(x + " ");
				}
				flag = true;
			}

		} else {
			for (int i = 1; i <= n; i++) { // *i는 순열을 만드는 숫자!
				if (check[i] == 0) {
					check[i] = 1;
					p[L] = i;
					DFS(L + 1, sum + (p[L] * b[L]));
					check[i] = 0;
				}

			}
		}
	}

	public static void main(String[] args) throws IOException {
		S808 S = new S808();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		f = Integer.parseInt(st.nextToken());

		b = new int[n];
		p = new int[n];
		check = new int[n + 1]; // 숫자를 1부터 사용!(인덱스도 1부터 사용해야함)
		for (int i = 0; i < n; i++) {
			b[i] = S.combi(n - 1, i);
		}

		S.DFS(0, 0);

	}

}
