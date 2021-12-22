package Inflearn.Section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S10 {//봉우리 (상하좌우보다 큰 숫자는 봉우리)
	public int solution(int n, int[][] arr) {
		int answer = 0;
		return answer;
	}
	public static void main(String[] args) throws IOException {
		S10 S = new S10();
		
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
