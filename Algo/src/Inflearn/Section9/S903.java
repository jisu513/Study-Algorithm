package Inflearn.Section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class F_time implements Comparable<F_time> {
	// **Comparable �������̽��� ����ϸ� �ݵ�� compareTo()�޼��带 ������ �������
	public int s, e; // s = ģ�� ���� �ð�, e = ���� �ð�

	F_time(int s, int e) {
		this.s = s;
		this.e = e;
	}

	@Override
	public int compareTo(F_time o) {
		// TODO Auto-generated method stub
		if (this.e == o.e) { // ������ �ð��� ������
			return this.s - o.s; // �����ϴ� �ð��� �������� ����(��������)
		} else
			return this.e - o.e; // ������ �ð��� �������� ����
	}
}

public class S903 { // ��ȥ��

	public static void main(String[] args) throws IOException {
		S903 S = new S903();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());

	}

}
