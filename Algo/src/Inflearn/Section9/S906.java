package Inflearn.Section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S906 { // ģ���ΰ�? (���μ� ���� (Disjoint-Set) Union & Find)
	static int[] U; // ����

	public static int Find(int v) {
		if (v == U[v]) {
			return v;
		} else {
			return U[v] = Find(U[v]); // U[v]= �� �߰����ָ� ��� ������ ��! (????)
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

		U = new int[n + 1]; // index ��ȣ�� n���� ����ϱ� ���� n+1����
		for (int i = 1; i <= n; i++) {
			U[i] = i;
		}
		for (int i = 1; i <= m; i++) {// ���� ����
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Union(a, b);
		}

		// (a, b)�� ģ������ �ƴ���
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
