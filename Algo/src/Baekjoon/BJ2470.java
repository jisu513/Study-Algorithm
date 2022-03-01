package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2470 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int lt = 0, len = 0, min = Integer.MAX_VALUE, sum = 0;
		for (int rt = 0; rt < n; rt++) {
			if (sum < s) {
				sum += arr[rt];
			}
			while (sum >= s) {
				len = rt - lt + 1;
				if (len < min) {
					min = len;
				}
				sum -= arr[lt];
				lt++;
			}
		}

		if (min == Integer.MAX_VALUE) { // 길이가 최소가 되는 합을 구하지 못하면 0출력 --> min의 값이 변하지 않음
			System.out.println("0");
		} else {
			System.out.println(min);
		}

	}

}
