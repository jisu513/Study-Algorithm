package Inflearn.Section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S34 {// 연속 부분수열(합이 특정숫자 m이 되는 갯수)
	public int solution(int n, int m, int[] arr) {
		int answer = 0;

		int lt = 0, sum = 0;
		for (int rt = 0; rt < n; rt++) {
			sum += arr[rt];
			if (sum == m) {
				answer++;
			}
			while (sum >= m) {
				sum -= arr[lt];
				if (sum == m) {
					answer++;
				}
				lt++;
			}

		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S34 S = new S34();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(S.solution(n, m, arr));

	}

}
