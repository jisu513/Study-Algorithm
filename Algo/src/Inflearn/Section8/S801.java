package Inflearn.Section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S801 { // 합이 같은 부분집합
	static String answer = "NO";
	static int n, total = 0;
	boolean flag = false; // answer = "YES" 가 발견됐을 때 그 다음 재귀들은 모두 return 시키기 위한 하나의 장치

	public void DFS(int L, int sum, int[] arr) {
		if(flag) {
			return;
		}
		if(sum > total/2) { // 더 해볼 필요 없이 answer = NO (두 부분집합의 합이 같을 수가 없으므로)
			return;
		}
		if (L == n) { // 인덱스는 n-1번까지 --> L==n일 때 ** 부분 집합 완성 ** 
			if ((total - sum) == sum) { // total은 arr의 총합, sum은 부분집합의 합
				answer = "YES"; 
				flag = true;
			}
		} else { // 부분 집합 구하기
			DFS(L + 1, sum + arr[L], arr); // arr[L] 포함
			DFS(L + 1, sum, arr); // arr[L] 불포함
		}

	}

	public static void main(String[] args) throws IOException {
		S801 S = new S801();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			total += arr[i];
		}

		S.DFS(0, 0, arr); // (int L, int sum, int[] arr)
		System.out.println(answer);

	}

}
