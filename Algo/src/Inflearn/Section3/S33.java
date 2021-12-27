package Inflearn.Section3;

import java.io.*;
import java.util.*;

public class S33 {// 최대 매출(k일의 매출합 최대일 때) -> Sliding window
	public int solution(int n, int k, int[] days) {
		int answer = 0;

		int sum = 0;
		// 처음 k일 까지의 합
		for (int i = 0; i < k; i++) {
			sum += days[i];
			answer = sum;
		}

		// Sliding window -> 앞에 하나 빼고 뒤에 하나 더해주기!

		for (int i = 1; i < n - k + 1; i++) {
			sum = sum - days[i - 1] + days[i + k - 1];
			answer = Math.max(answer, sum);
		}

		// -->for문의 범위는 정해주기 나름!
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
