package Inflearn.Section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S807 { // ������ ����� ��(�޸������̼�) nCr = n-1Cr-1 + c-1Cr
	// �޸������̼��̶�? 
	/* ������ ����� �ݺ��ؾ� �� ��� �� �� ����� ����� �޸𸮿� ������ �ξ��ٰ� ���� �����ν� 
	 * �ߺ� ����� ������ �� �ְ� �ϴ� ��� -> ���� ��ȹ���� �ٽ��� �Ǵ� ���
	 */
	static int n, r;
	int[][] dy = new int[35][35]; // �޸������̼��� ���� ���
	public int DFS(int n, int r) {
		if(dy[n][r] > 0) {
			return dy[n][r];
		}
		if(n == r || r == 0) {
			return 1;
		}else {
			return dy[n][r] =  DFS(n-1, r-1) + DFS(n-1, r);
		}
		
	}
	
	// �޸������̼� X --> ���� �ſ� ���ϵ�
	/*
	 * public int DFS(int n, int r) {
		if(n == r || r == 0) {
			return 1;
		}else {
			return DFS(n-1, r-1) + DFS(n-1, r);
		}
		
	}*/

	public static void main(String[] args) throws IOException {
		S807 S = new S807();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // ����: 3 <= n <= 33
		r = Integer.parseInt(st.nextToken());
		
		System.out.println(S.DFS(n, r));

	}

}
