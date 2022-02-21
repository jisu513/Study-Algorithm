package Inflearn.Section6;

import java.io.*;
import java.util.StringTokenizer;

public class S61 {// 선택 정렬
	public int[] solution(int n, int[] arr) {
		
		/* 선택정렬: 가장 작은 요소부터 선택해 알맞은 위치로 옮겨서 순서대로 정렬하는 알고리즘!
		   시간복잡도 = O(N*N) --> 비효율적
		 */
		
		for (int i = 0; i < n -1 ; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			int tmp = arr[i];
			arr[i] = arr[min]; // arr[i]를 최솟값인 arr[min]으로 swap!
			arr[min] = tmp;
		}
		return arr;
	}

	public static void main(String[] args) throws IOException {
		S61 S = new S61();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int x : S.solution(n, arr)) {
			System.out.print(x + " ");
		}

	}

}
