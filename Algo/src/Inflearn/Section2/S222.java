package Inflearn.Section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S222 {//멘토링
	public int solution(int n, int m, int[][] arr) {
		int answer=0;
		//2-10 ~ 2-12 다시 공부하기..!
		for (int i = 1; i <= n; i++) { // 학생수
			for (int j = 1; j <= n; j++) {
				int cnt = 0;
				for (int k = 0; k < m; k++) {// 테스트 수
					int pi = 0, pj = 0;
					for (int s = 0; s < n; s++) { // (i,j) 등수 비교
						if (arr[k][s] == i) {
							pi = s;
						}
						if (arr[k][s] == j) {
							pj = s;
						}
					}
					if (pi < pj) {
						cnt++;
					}
				}
				if (cnt == m) {
					answer++;
				}
			}

		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S222 S = new S222();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = null;
		StringTokenizer st2 = null;

		st1 = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st1.nextToken()); //학생 수
		int m = Integer.parseInt(st1.nextToken()); //테스트 수

		int[][] arr = new int[m][n];
		for (int i = 0; i < m; i++) {
			st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) { 
				arr[i][j] = Integer.parseInt(st2.nextToken());
			}
		}

		System.out.println(S.solution(n, m, arr));

	}

}
