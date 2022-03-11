package Inflearn.Section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S74 { // �Ǻ���ġ ����
	static int[] fibo;

	public int DFS(int n) { // ���� �ſ� ������..!
		if(fibo[n] > 0)
			return fibo[n]; // --> �� if�� �߰��ϸ� �ð� �ξ� �� ����! (�̹� ���س��� DFS()���� �״�� ������ ����ϹǷ�! -> ������ �ϳ��ϳ� �ٽ� �� ������)
 		if (n == 1) {
			return fibo[n] = 1;
		} else if (n == 2) {
			return fibo[n] = 1;
		} else {
			return fibo[n] = DFS(n - 2) + DFS(n - 1);
		}

	}

	public static void main(String[] args) throws IOException {
		S74 S = new S74();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		fibo = new int[n + 1]; // 0�� �ε����� ���X -> 1�� �ε������� ����ϹǷ� n+1����!
		S.DFS(n);
		for (int i = 1; i <= n; i++) {
			System.out.print(fibo[i] + " ");
		}
		
		//fibo[] �迭 ���� S.DFS()�� �ϳ��ϳ� ����ϸ� �ð��� �� �����ɸ�
		/*for (int i = 1; i <= n; i++) {
			System.out.print(S.DFS(i) + " ");  ->�ð� �� ���� �ɸ�!
		}*/ 

	}

}
