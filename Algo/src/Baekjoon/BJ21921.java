package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ21921 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int answer = 0, sum = 0, cnt = 1;
		for (int i = 0; i < x; i++) { // ó�� x�� ������ �湮�� �� ���س���
			sum += arr[i];
			answer = sum;
		}

		for (int i = x; i < n; i++) {
			sum = sum - arr[i - x] + arr[i];
			if (answer < sum) {
				answer = sum;
				cnt = 1; // ** cnt=1�� �ʱ�ȭ ���ֱ�!
			} else if (answer == sum) {
				cnt++;
			}
		}
		if (answer == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(answer);
			System.out.println(cnt);
		}

	}

}
