package Inflearn.Section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S63 {
	public int[] solution(int n, int[] arr) {
		/*
		 * 삽입정렬 : 선택한 요소를 그보다 더 앞쪽의 알맞은 위치에 '삽입하는' 작업을 반복하여 정렬하는 알고리즘! 
		 * 시간 복잡도 = O(N*N)
		 *   --> 같은 시간복잡도를 가지는 선택, 버블 정렬에 비해 필요할 때만 삽입한다는 점에서 연산 수가 적어 비교적 효율적
		 */

		for (int i = 1; i < n; i++) { // i는 1부터 시작!!
			int tmp = arr[i];
			int j;
			for (j = i - 1; j >= 0; j--) {
				if (arr[j] > tmp) {
					arr[j + 1] = arr[j];
				} else {
					break;
				}
			}
			arr[j + 1] = tmp;
		}
		return arr;
	}

	public static void main(String[] args) throws IOException {
		S63 S = new S63();

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
