package Inflearn.Section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S72 {// ����Լ��� �̿��� ���� ���
	public void DFS(int n) {
		if (n == 0) {
			return;
		} else {
			DFS(n / 2);
			System.out.print(n % 2);
			// System.out.print() ��ġ �߿�! DFS() �տ� �����Ĥ� �ڿ� �����Ŀ� ���� ���� �޶��� --> �����е� ����
		}

	}

	public static void main(String[] args) throws IOException {
		S72 S = new S72();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		S.DFS(n);

	}

}
