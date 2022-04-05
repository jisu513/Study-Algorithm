package Inflearn.Section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S802 { // �ٵ��� ���� (DFS)

	static int answer = Integer.MIN_VALUE, c, n; //c�� �ִ� ����

	public void DFS(int L, int sum, int[] arr) {
		if (sum > c) 
			return;
		if (L == n) { // �ε����� n-1������ --> L==n�� �� ** �κ� ���� �ϼ� ** 
			answer = Math.max(answer, sum);
		} else { // �κ� ���� ���ϱ�
			DFS(L + 1, sum + arr[L], arr);
			DFS(L + 1, sum, arr);
		}
	}

	public static void main(String[] args) throws IOException {
		S802 S = new S802();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		c = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		S.DFS(0, 0, arr); // (int L, int sum, int[] arr)
		System.out.println(answer);
	}
}
