package Inflearn.Section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S806 { // 순열구하기 (DFS)
	static int n, m;
	static int[] pm; // n개의 자연수 중에서 뽑은 m개의 숫자 나열
	static int[] arr; // n개의 자연수
	static int[] check; // *순열을 구하는 것이기 때문에 중복 숫자 있는지 확인하기 위해 사용

	public void DFS(int L) {
		if (L == m) {
			for (int x : pm) {
				System.out.print(x + " ");
			}
			System.out.println();
		} else {
			for (int i = 0; i < n; i++) {
				if (check[i] == 0) {
					check[i] = 1; // 중복 O
					pm[L] = arr[i];
					DFS(L + 1);
					check[i] = 0; // **중복 체크 해제해줘야함!!**
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		S806 S = new S806();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // n개의 자연수가 주어질 때
		m = Integer.parseInt(st.nextToken()); // m개 뽑아 나열

		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) { // n개의 자연수
			arr[i] = Integer.parseInt(st.nextToken());
		}

		pm = new int[m]; // n개의 자연수 중에서 뽑은 m개의 숫자 나열
		check = new int[n]; // 중복 숫자 있는지 확인

		S.DFS(0);

	}

}
