package Inflearn.Section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S803 { //�ִ� ���� ���ϱ� (DFS)
	static int answer = Integer.MIN_VALUE, n, m;
	boolean flsg = false;

	public void DFS(int L, int sum, int Stime, int[] ps, int[] pt) {
		if(Stime > m) { // ���ѽð��� �ʰ��ϸ� �� �� �ʿ���� ������
			return;
		}
		if (n == L) { // �κ����� �ϼ�
			answer = Math.max(answer, sum);

		} else {
			DFS(L + 1, sum + ps[L], Stime + pt[L], ps, pt); // ������ Ǯ ��
			DFS(L + 1, sum, Stime, ps, pt); //�� Ǯ ��
		}

	}

	public static void main(String[] args) throws IOException {
		S803 S = new S803();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // ���� ����
		m = Integer.parseInt(st.nextToken()); // ���� �ð�

		
		int[] score = new int[n]; // ps
		int[] time = new int[n]; // pt	
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			score[i] = Integer.parseInt(st.nextToken());
			time[i] = Integer.parseInt(st.nextToken());
		}

		S.DFS(0, 0, 0, score, time); // DFS(L, score ��, time ��, score[], time[])
		System.out.println(answer);
	}

}
