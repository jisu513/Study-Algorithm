package Inflearn.Section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S210 {// 봉우리 (상하좌우보다 큰 숫자는 봉우리) 2-10번
	public int solution(int n, int[][] arr) {
		int answer = 0;
		// 방향배열 먼저 설정!
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		// 3중 for문 사용
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				boolean flag = true;// 봉우리 인지 아닌지 판별
				for (int k = 0; k < 4; k++) {// 상하좌우 4개 비교!
					int nx = i + dx[k]; // 상하좌우 좌표의 행 값
					int ny = j + dy[k]; // 상하좌우 좌표의 열 값
					if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] > arr[i][j]) {
						// nx와 ny의 경계 범위 먼저 정해줘야함! -> 안해주면 outOfIndex~ 오류남
						flag = false;
						break; // arr[i][j]의 상하좌우(arr[nx][ny]) 중 하나라도 크기가 크거나 같으면 중단 -> 봉우리 아님!
					}

				}
				if (flag) {
					answer++;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		S210 S = new S210();

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
