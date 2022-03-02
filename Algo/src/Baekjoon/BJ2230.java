package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2230 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		// Arrays.sort(arr);

		int lt = 0, rt = 0, len = 0, min = Integer.MAX_VALUE;
		while (lt <= n) {
			len = arr[rt] - arr[lt];
			if (len >= m) {
				if (len < min) {
					min = len;
				}
				lt++;
			} else {
				rt++;
				if(rt >= n)
					break;
			}

		}
		System.out.println(min);

	}

}
