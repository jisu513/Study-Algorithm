package Inflearn.Section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S610 {// 마구간 정하기(결정 알고리즘)
	public int count(int[] arr, int dist) {
		int cnt = 1; // 배치한 말의 개수
		int ep = arr[0]; // 말이 배치된 좌표 (첫 말은 배열의 첫번째에 배치되는 것이 가장 좋음)

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] - ep >= dist) { // 말을 배치하려고 하는 좌표와 이미 말이 들어있는 좌표 사이의 거리가 dist(=mid) 보다 크거나 같아야함
				cnt++;
				ep = arr[i]; // 말이 배치된 좌표 업데이트
			}
		}
		return cnt;
	}

	public int solution(int n, int c, int[] arr) {
		int answer = 0;

		Arrays.sort(arr); // 이진검색은 반드시 정렬이 되어있어야 함!
		int lt = 1; // 마구간 사이의 최소거리
		int rt = arr[n - 1]; // 가장 마지막 좌표 값

		while (lt <= rt) {
			int mid = (lt + rt) / 2; // 두 말의 최대거리
			if (count(arr, mid) >= c) {
				answer = mid;
				lt = mid + 1;
			} else {
				rt = mid - 1;
			}
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		S610 S = new S610();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(S.solution(n, c, arr));

	}

}
