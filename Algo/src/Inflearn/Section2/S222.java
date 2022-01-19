package Inflearn.Section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S222 {// 멘토링
	// ***너어무 헷갈림..***
	public int solution(int n, int m, int[][] arr) {// n은 학생 수, m은 test수
		int answer = 0;

		// 4중 for문 사용
		for (int i = 1; i <= n; i++) {// n:학생 수 i=멘토
			for (int j = 1; j <= n; j++) {//     j=멘티 --> (i, j) = (멘토, 멘티) 경우의 수
				int cnt = 0;
				for (int k = 0; k < m; k++) {// m:test 수
					int pi = 0, pj = 0;
					for (int s = 0; s < n; s++) {// n:등 수 --> 학생 수 = 등수(당연한 소리지만.. 헷갈렸음)
						if (arr[k][s] == i) {// arr[k][s]의 값은 멘토/멘티 학생번호!
							pi = s; // i는 s등
							// -->arr[k][s]의 값이 i의 값과 동일 할 때의 s값이 i의 등수!
						}
						if (arr[k][s] == j) {
							pj = s;
						}

					}
					if (pi < pj) {// 등수는 값이 낮은게 높은 등수!(헷갈림..)
						cnt++;
					}
				}
				if (cnt == m) {// cnt의 값과 test수가 같아야 모든 test에서 i가 j보다 높은 등수 --> 멘토링 가능!
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
		int n = Integer.parseInt(st1.nextToken()); // 학생 수
		int m = Integer.parseInt(st1.nextToken()); // 테스트 수

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
