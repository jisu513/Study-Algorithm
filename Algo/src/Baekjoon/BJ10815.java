package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ10815 { // 숫자카드
	// ***이진탐색은 반드시 배열이 정렬되어 있어야함!! ***
	public static boolean BinarySearch(int[] narr, int checkNum) {

		int lt = 0;
		int rt = narr.length - 1;
		
		while (lt <= rt) {
			int mid = (lt + rt) / 2;
			
			if (checkNum == narr[mid]) {
				return true;
			}

			if (narr[mid] < checkNum) {
				lt = mid + 1;
			} else {
				rt = mid - 1;
			}

		}
		return false;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());
		int[] narr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			narr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(narr);

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int checkNum = Integer.parseInt(st.nextToken());

			if (BinarySearch(narr, checkNum)) {
				System.out.print("1" + " ");
			} else {
				System.out.print("0" + " ");
			}
		}

	}

}
