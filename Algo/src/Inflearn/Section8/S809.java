package Inflearn.Section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S809 { // 조합 구하기
	static int n, m;
	static int[] combi;

	public void DFS(int L, int s) {
		if (L == m) {
			for (int x : combi) {
				System.out.print(x + " ");
			}
			System.out.println();

		} else {
			for (int i = s; i <= n; i++) { // 조합 (외우는 것이 좋음! 응용 많기 때문)
				combi[L] = i;
				DFS(L + 1, i + 1);
			}
		}

	}

	public static void main(String[] args) throws IOException {
		S809 S = new S809();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		combi = new int[m];

		S.DFS(0, 1);

	}

}
