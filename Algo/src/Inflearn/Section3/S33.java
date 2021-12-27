package Inflearn.Section3;

import java.io.*;
import java.util.*;

public class S33 {// �ִ� ����(k���� ������ �ִ��� ��) -> Sliding window
	public int solution(int n, int k, int[] days) {
		int answer = 0;

		int sum = 0;
		// ó�� k�� ������ ��
		for (int i = 0; i < k; i++) {
			sum += days[i];
			answer = sum;
		}

		// Sliding window -> �տ� �ϳ� ���� �ڿ� �ϳ� �����ֱ�!

		for (int i = 1; i < n - k + 1; i++) {
			sum = sum - days[i - 1] + days[i + k - 1];
			answer = Math.max(answer, sum);
		}

		// -->for���� ������ �����ֱ� ����!
		/*
		 * for (int i = k; i < n; i++) {
		       sum = sum - days[i-k] + days[i]; 
		       answer = Math.max(answer, sum); 
		   }
		 */
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S33 S = new S33();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] days = new int[n];
		for (int i = 0; i < n; i++) {
			days[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(S.solution(n, k, days));

	}

}
