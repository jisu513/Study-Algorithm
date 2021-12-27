package Inflearn.Section2;

import java.io.*;
import java.util.*;

public class S28 {// 등수구하기
	public int[] solution(int n, int[] arr) {
		int[] answer = new int[n];

		int cnt;

		// 이중 for문 사용!
		for (int i = 0; i < n; i++) {//기준 arr[]
			cnt = 1;
			for (int j = 0; j < n; j++) {//비교되는 arr[]
				if (arr[j] > arr[i]) {
					cnt++;
				}
			}
			answer[i] = cnt;
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S28 S = new S28();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for(int x : S.solution(n, arr)) {
			System.out.print(x + " ");
		}

	}

}
