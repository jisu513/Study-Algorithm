package Inflearn.Section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class S805 { // ������ȯ(DFS) - ���� ���� ���� �������� ��ȯ���ֱ�
	static int n, m, answer = Integer.MAX_VALUE;

	public void DFS(int L, int sum, Integer[] arr) { // L�� ���� ���� (L=1 -> ���� ���� �ϳ� / L=2 -> ���� ���� �ΰ� ...)
		if (sum > m) {
			return;
		}
		if (L >= answer) {
			/* **�� �ڵ带 �־���� �ð����⵵ ���� �� ����!!** --> �ּ� ��� ������ ���ϴ� ���̹Ƿ� ���ϰ� �ִ� L�� ���� 
			                                            �̹� ���س��� �ּڰ��� answer���� ũ�ų� ������ �� �� �ʿ� ����! */
			return;
		}
		if (sum == m) {
			answer = Math.min(answer, L);
		} else {
			for (int i = 0; i < n; i++) {
				DFS(L + 1, sum + arr[i], arr);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		S805 S = new S805();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine()); // ���� ���� ����
		st = new StringTokenizer(br.readLine());
		Integer[] coin = new Integer[n]; // ���� ����
		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(coin, Collections.reverseOrder());
		/* ������ ū �ͺ��� �����ؾ� �ð��� �� ������ �� �����Ƿ� ������������ �������ֱ�!
		 *  Collections.reverseOrder()�� ����Ϸ��� coin[]�� ��ü���̾����!(Integer[])
		 *                                      �⺻���� ����� �� ����(int[])
		 */
		m = Integer.parseInt(br.readLine()); // �Ž��� �� �ݾ�

		S.DFS(0, 0, coin);
		System.out.println(answer);
	}

}
