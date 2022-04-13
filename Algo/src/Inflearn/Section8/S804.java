package Inflearn.Section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S804 { // 중복순열(DFS) -> 호출이 n번 일어남
	/* 801~803은 이진트리 위주의 문제 -> 두가닥으로 뻗어나감![포함 O / X](호출이 2번 일어남)*/
	
	static int[] pm;
	static int n, m;

	public void DFS(int L) {
		if (L == m) { // 트리 완성
			for (int x : pm) { // 출력하기 
				System.out.print(x + " ");			
			}
			System.out.println();
		} else { // **손으로 코드 돌아가는 과정 그려가면서 이해하고 넘어가기!!**
			for(int i = 1; i <= n; i++) { // n가닥으로 뻗어나감으로 for문 사용!(n번의 호출이 일어남)
				pm[L] = i;
				DFS(L + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		S804 S = new S804();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); //n까지 번호가 적힌 구슬
		m = Integer.parseInt(st.nextToken()); //m번 뽑기

		pm = new int[m];

		S.DFS(0);

	}

}
