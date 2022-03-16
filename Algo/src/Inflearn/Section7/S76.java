package Inflearn.Section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S76 {// 부분집합 구하기 (DFS)
	static int n;
	static int[] ch;

	public void DFS(int L) {
		if (L == n + 1) { // 마지막 노드일 때 출력
			String tmp = "";
			for (int i = 1; i <= n; i++) {
				if (ch[i] == 1) {
					tmp += (i + " ");
				}
			}
			if (tmp.length() > 0) { // 공집합은 출력 X
				System.out.println(tmp);
			}

		} else {
			ch[L] = 1;
			DFS(L + 1); // 왼쪽 (사용 O)
			ch[L] = 0;
			DFS(L + 1); // 오른쪽으로 뻗는다고 생각! (사용 X) -> (아이패드 정리 확인)
		}

	}

	public static void main(String[] args) throws IOException {
		S76 S = new S76();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		ch = new int[n + 1];

		S.DFS(1);

	}

}
