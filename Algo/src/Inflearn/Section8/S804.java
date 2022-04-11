package Inflearn.Section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S804 { // 중복순열(DFS)
	static int[] pm;
	static int n, m;

	public void DFS(int L) {
		if (L == m) {
			for (int x : pm) {
				System.out.print(x + " ");			
			}
			System.out.println();
		} else {
			for (int i = 1; i <= n; i++) {
				pm[L] = i;
				DFS(L + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		S804 S = new S804();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		pm = new int[m];

		S.DFS(0);

	}

}
