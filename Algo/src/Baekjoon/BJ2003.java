package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2003 { //Inflearn S34

	public static void main(String[] args) throws IOException {

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

		int lt = 0, sum = 0, cnt = 0;
		for (int rt = 0; rt < n; rt++) { 
			sum += arr[rt];
			if (sum == m) {
				cnt++;
			}
			while (sum >= m) { 
				sum -= arr[lt];
				lt++;
				if(sum == m) {
					cnt++;
				}

			}
		}
		System.out.println(cnt);

	}

}
