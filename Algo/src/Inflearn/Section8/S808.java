package Inflearn.Section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S808 { // ���� �����ϱ� (���� ���빮��) -> S806 + S807
	static int[] b; // �ĺ���̼� �� ����!
	static int[] p; // ���� ����
	static int[] check; // �ߺ� ������ �ƴϱ� ������ �ʿ� (S806 - �������ϱ� )
	static int n, f;
	boolean flag = false;
	int[][] dy = new int[12][12]; // �޸������̼��� ���� �ʿ�! [12]�� �������� �־��� ����

	public int combi(int n, int r) { // S807 (���� nCr = n-1Cr-1 + n-1Cr)
		//�޸������̼�
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
		if (L == n) { //**������ ���� ���ϴ� �� -> �پ��� p[]�� �� �� ������ p[]���ϴ� ��!
			if (sum == f) {
				for (int x : p) {
					System.out.print(x + " ");
				}
				flag = true; // ���� ã�� �� �ٸ� ��͵��� ȣ�����ڸ��� ���� �� �ְ� �ϱ� ���� ��ġ
			}

		} else {
			for (int i = 1; i <= n; i++) { // *i�� ������ ����� ����!
				if (check[i] == 0) {
					check[i] = 1; // �ش� ���ڸ� ������� �� ǥ�� 
					p[L] = i; // ���� ��
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
		check = new int[n + 1]; // ���ڸ� 1���� ���!(�ε����� 1���� ����ؾ���)
		for (int i = 0; i < n; i++) {
			b[i] = S.combi(n - 1, i);
		}

		S.DFS(0, 0);

	}

}
