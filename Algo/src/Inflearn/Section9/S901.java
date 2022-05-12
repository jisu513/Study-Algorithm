package Inflearn.Section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
S607 ��ǥ���� �κ� �����ϱ�!! 
��ü �� -> Comparable<>�� ��ü���� �񱳸� �����ϰ� ���ִ� �������̽�
*/
class Body implements Comparable<Body> {
	// **Comparable �������̽��� ����ϸ� �ݵ�� compareTo()�޼��带 ������ �������
	public int h, w;

	Body(int h, int w) {
		this.h = h;
		this.w = w;
	}

	@Override
	public int compareTo(Body o) {
		// TODO Auto-generated method stub
		return o.h - this.h; // �������� ����
	}
}

public class S901 { // �������� (�׸��� �˰���)
	// �׸���(Ž��) �˰��� : ���� ��Ȳ���� ���� ���� ���� �����س����� �˰��� -> ��ü ������� ���� ���� ���̶�� ������ ����!
	public int solution(ArrayList<Body> arr, int n) {
		int cnt = 0; // ���ߵǴ� �ο� ��
		Collections.sort(arr); // ����!
		int max = Integer.MIN_VALUE;
		for (Body b : arr) {
			if (b.w > max) {
				max = b.w;
				cnt++;
			}
		}

		return cnt;
	}

	public static void main(String[] args) throws IOException {
		S901 S = new S901();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());

		ArrayList<Body> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr.add(new Body(h, w));
		}

		System.out.println(S.solution(arr, n));

	}

}
