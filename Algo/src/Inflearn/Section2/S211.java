package Inflearn.Section2;

import java.io.*;
import java.util.*;

public class S211 {// 임시 반장 정하기
	public int solution(int n, int[][] arr) {
		int answer = 0;

		int cnt = 0, max = 0;
		// 3중 for문 사용
		for (int i = 1; i < n + 1; i++) {// 기준 학생
			cnt=0;
			for (int j = 1; j < n + 1; j++) {// 비교대상 학생
				for (int k = 1; k < 6; k++) {// 학년(5학년까지만)
					if (arr[i][k] == arr[j][k]) {
						cnt++;
						break;//한 번이라도 같은 반이었던 사람 count(여러번 같은 반이었더라고 한번만!)
					}
				}
			}
			if(cnt > max) {
				max = cnt;
				answer = i;//최대값을 만드는 i번 학생이 답
			}

		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		S211 S = new S211();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n + 1][6];
		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 6; j++) { // 5학년 까지!
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(S.solution(n, arr));
	}

}
