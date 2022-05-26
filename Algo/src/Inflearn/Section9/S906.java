package Inflearn.Section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S906 { // 친구인가? (서로소 집합 (Disjoint-Set) Union & Find)
	static int[] U; // 집합

	public static int Find(int v) {
		if (v == U[v]) {
			return v;
		} else {
			return U[v] = Find(U[v]); // U[v]= 을 추가해주면 경로 압축이 됨! (????)
		}
	}

	public static void Union(int a, int b) { // (a, b)
		int fa = Find(a);
		int fb = Find(b);
		if (fa != fb) {
			U[fa] = fb;
		}

	}

	public static void main(String[] args) throws IOException {
		S906 S = new S906();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		U = new int[n + 1]; // index 번호를 n까지 사용하기 위해 n+1까지
		for (int i = 1; i <= n; i++) {
			U[i] = i;
		}
		for (int i = 1; i <= m; i++) {// 집합 생성
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Union(a, b);
		}

		// (a, b)가 친구인지 아닌지
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int fa = Find(a);
		int fb = Find(b);
		if (fa == fb) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

}
