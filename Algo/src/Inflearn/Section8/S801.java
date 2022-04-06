package Inflearn.Section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S801 { // 합이 같은 부분집합 (DFS)
	static int n, total = 0; // total은 arr의 총 합
	static String answer = "No";
	boolean flag = false; // answer = "YES" 가 발견됐을 때 그 다음 재귀들은 모두 return 시키기 위한 표시

	public void DFS(int L, int sum, int[] arr) { // sum은 부분집합의 총합
		if (flag) {
			return;
		}
		if (sum > total / 2) { // 부분집합(sum)의 총합이 total/2보다 크면 더 해볼 필요 X (합이 같은 부분집합을 찾고 있기때문에!)
			return;
		}
		if (n == L) { // index는 0 ~ n-1 까지 -> n==L이면 부분집합 완성
			if ((total - sum) == sum) { // 두 부분집합의 합이 같으므로
				answer = "YES";
				flag = true;
			}
		} else {
			DFS(L + 1, sum + arr[L], arr); // 아이패드로 확인!  O(포함)
			DFS(L + 1, sum, arr); // X(불포함)
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
