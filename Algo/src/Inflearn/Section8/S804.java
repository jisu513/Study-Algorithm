package Inflearn.Section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S804 { // �ߺ�����(DFS) -> ȣ���� n�� �Ͼ
	/* 801~803�� ����Ʈ�� ������ ���� -> �ΰ������� �����![���� O / X](ȣ���� 2�� �Ͼ)*/
	
	static int[] pm;
	static int n, m;

	public void DFS(int L) {
		if (L == m) { // Ʈ�� �ϼ�
			for (int x : pm) { // ����ϱ� 
				System.out.print(x + " ");			
			}
			System.out.println();
		} else { // **������ �ڵ� ���ư��� ���� �׷����鼭 �����ϰ� �Ѿ��!!**
			for(int i = 1; i <= n; i++) { // n�������� ��������� for�� ���!(n���� ȣ���� �Ͼ)
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
		n = Integer.parseInt(st.nextToken()); //n���� ��ȣ�� ���� ����
		m = Integer.parseInt(st.nextToken()); //m�� �̱�

		pm = new int[m];

		S.DFS(0);

	}

}
