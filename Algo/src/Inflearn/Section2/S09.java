package Inflearn.Section2;

import java.io.*;
import java.util.*;

public class S09 {// 격자판 최대합
	public int solution(int n, int[][] arr) {
		int answer = 0;

		int sum1 = 0, sum2 = 0;
		for (int i = 0; i < n; i++) {
			sum1 = sum2 = 0;
			for (int j = 0; j < n; j++) {
				sum1 += arr[i][j]; // 행의 합
				sum2 += arr[j][i]; // 열의 합
			}
			answer = Math.max(answer, sum1); // 삼항연산자 -> answer > sum1 ? answer : sum1 과 동일
			answer = Math.max(answer, sum2);
		}

		sum1 = sum2 = 0;
		for (int i = 0; i < n; i++) {// 좌,우 대각선의 합
			sum1 += arr[i][i];
			sum2 += arr[i][n - 1 - i];
		}
		answer = Math.max(answer, sum1); 
		answer = Math.max(answer, sum2);

		return answer;
	}

	public static void main(String[] args) throws IOException {
		S09 S = new S09();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(S.solution(n, arr));

	}

}
