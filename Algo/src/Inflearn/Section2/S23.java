package Inflearn.Section2;

import java.io.*;
import java.util.*;

public class S23 { // ���������� (����:1 ����:2 ��:3)
	public String solution(int n, int[] A, int[] B) {
		String answer = "";

		// A, B �� ��� �� �̱� ��� ���! ���� D ���
		for (int i = 0; i < n; i++) {
			if (A[i] == B[i]) {
				answer += "D";
			} else if (A[i] == 1 && B[i] == 3) {
				answer += "A";
			} else if (A[i] == 2 && B[i] == 1) {
				answer += "A";
			} else if (A[i] == 3 && B[i] == 2) {
				answer += "A";
			} else {
				answer += "B";
			}
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S23 S = new S23();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int[] B = new int[n];
		for (int i = 0; i < n; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		for(char x : S.solution(n, A, B).toCharArray()) {
			System.out.println(x);
		}

	}

}
