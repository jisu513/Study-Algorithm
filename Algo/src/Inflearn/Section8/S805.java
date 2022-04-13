package Inflearn.Section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class S805 { // 동전교환(DFS) - 가장 적은 수의 동전으로 교환해주기
	static int n, m, answer = Integer.MAX_VALUE;

	public void DFS(int L, int sum, Integer[] arr) { // L은 동전 개수 (L=1 -> 사용된 동전 하나 / L=2 -> 사용된 동전 두개 ...)
		if (sum > m) {
			return;
		}
		if (L >= answer) {
			/* **이 코드를 넣어줘야 시간복잡도 줄일 수 있음!!** --> 최소 사용 개수를 구하는 것이므로 구하고 있는 L의 값이 
			                                            이미 구해놓은 최솟값인 answer보다 크거나 같으면 더 할 필요 없음! */
			return;
		}
		if (sum == m) {
			answer = Math.min(answer, L);
		} else {
			for (int i = 0; i < n; i++) {
				DFS(L + 1, sum + arr[i], arr);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		S805 S = new S805();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine()); // 동전 종류 개수
		st = new StringTokenizer(br.readLine());
		Integer[] coin = new Integer[n]; // 동전 종류
		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(coin, Collections.reverseOrder());
		/* 동전이 큰 것부터 시작해야 시간을 더 단축할 수 있으므로 내림차순으로 정렬해주기!
		 *  Collections.reverseOrder()을 사용하려면 coin[]이 객체형이어야함!(Integer[])
		 *                                      기본형은 사용할 수 없음(int[])
		 */
		m = Integer.parseInt(br.readLine()); // 거슬러 줄 금액

		S.DFS(0, 0, coin);
		System.out.println(answer);
	}

}
