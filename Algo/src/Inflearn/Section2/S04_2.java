package Inflearn.Section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S04_2 {// 피보나치 수열
	public void solution(int n) { //return값 없으므로 void 사용!
		// 배열을 사용하지 않을 경우

		int a = 1, b = 1, c = 0;

		System.out.print(a + " " + b + " ");
		for (int i = 0; i < n - 2; i++) {
			c = a + b;
			System.out.print(c + " ");
			a = b;
			b = c;
		}

	}

	public static void main(String[] args) throws IOException {
		S04_2 S = new S04_2();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		S.solution(n);

	}

}
