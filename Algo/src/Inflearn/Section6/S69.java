package Inflearn.Section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S69 { // 뮤직비디오 (결정알고리즘)
	public int count(int[] arr, int capacity) {
		int cnt = 1; // dvd 장 수
		int sum = 0; // dvd 용량의 합
		for (int x : arr) {
			if (sum + x > capacity) {
				cnt++;
				sum = x;
			} else {
				sum += x;
			}
		}
		return cnt;
	}

	public int solution(int n, int m, int[] arr) {
		int answer = 0;

		/* 결정 알고리즘 : 이분검색을 이용하는 알고리즘 */
		int lt = Arrays.stream(arr).max().getAsInt(); // arr[] 배열 값 중 최댓값
		int rt = Arrays.stream(arr).sum(); // arr[] 배열 값의 총합

		while (lt <= rt) {
			int mid = (lt + rt) / 2;
			if (count(arr, mid) <= m) {
				answer = mid;
				rt = mid - 1;
			} else {
				lt = mid + 1;
			}
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S69 S = new S69();

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
