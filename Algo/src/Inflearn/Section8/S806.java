package Inflearn.Section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S806 { // �������ϱ� (DFS)
	static int n, m;
	static int[] pm; // n���� �ڿ��� �߿��� ���� m���� ���� ����
	static int[] arr; // n���� �ڿ���
	static int[] check; // *������ ���ϴ� ���̱� ������ �ߺ� ���� �ִ��� Ȯ���ϱ� ���� ��� (���� ���ڸ� ���ÿ� �̴� ���� �Ұ���)

	public void DFS(int L) { // *** �׸� �׷����鼭 �����ϰ� �Ѿ�� ***
		if (L == m) {// ���� ���
			for (int x : pm) { // ���
				System.out.print(x + " ");
			}
			System.out.println();
		} else {
			for (int i = 0; i < n; i++) {
				if (check[i] == 0) {
					check[i] = 1; // �ش� ���� ��� ǥ��
					pm[L] = arr[i];
					DFS(L + 1);
					check[i] = 0; // **üũ �����������!!**
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		S806 S = new S806();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // n���� �ڿ����� �־��� ��
		m = Integer.parseInt(st.nextToken()); // m�� �̾� ����

		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) { // n���� �ڿ�����
			arr[i] = Integer.parseInt(st.nextToken());
		}

		pm = new int[m]; // n���� �ڿ��� �߿��� ���� m���� ���� ����
		check = new int[n]; // �ߺ� ���� �ִ��� Ȯ��

		S.DFS(0);

	}

}
