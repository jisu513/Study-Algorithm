package Inflearn.Section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S71 { //����Լ� --> �ڱ� �ڽ��� ȣ���ϴ� �Լ�
	public void DFS(int n) {
		if(n == 0) {
			return;
		}else {
			//System.out.print(n + " "); --> �������� ���
			DFS(n-1);
			System.out.print(n + " "); // �������� ��� --> �����е� Ȯ��
		}
	}

	public static void main(String[] args) throws IOException {
		S71 S = new S71();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		S.DFS(n);

	}

}
