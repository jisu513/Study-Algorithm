package Inflearn.Section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S210 {// 봉우리 (상하좌우보다 큰 숫자는 봉우리) 2-10번
	public int solution(int n, int[][] arr) {
		int answer = 0;
		// 방향 배열 먼저 설정!(상하좌우 비교 -> k for문)
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		for (int i = 0; i < n; i++) {// arr의 행
			for (int j = 0; j < n; j++) {// arr의 열
				boolean flag = true; // 봉우리인지 아닌지 판별
				for (int k = 0; k < 4; k++) {// 상하좌우 비교!(방향배열)
					int nx = i + dx[k]; // 상하좌우의 행 좌표
					int ny = i + dy[k]; // 상하좌우의 열 좌표
					if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] >= arr[i][j]) {
						// nx와 ny의 범위 지정 안해주면 outOfIndex~ 오류 남! (***nx와 ny의 범위 지정을 arr[i][j]의 상하좌우 크기
						// 비교보다 먼저 해줘야함!)
						flag = false;
						break; // 상하좌우(arr[nx][ny]) 중 하나라도 arr[i][j] 보다 크면 중단!
					} // nx>=0 과 ny>=0 을 해줌으로써 arr을 0으로 둘러쌓는 것 해결
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
