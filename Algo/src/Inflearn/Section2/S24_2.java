package Inflearn.Section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S24_2 {// �Ǻ���ġ ����
	public void solution(int n) { //return�� �����Ƿ� void ���!
		// �迭�� ������� ���� ���

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
		S24_2 S = new S24_2();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		S.solution(n);

	}

}
