package Inflearn.Section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

//��ü �� -> Comparable�� ��ü���� �񱳸� �����ϰ� ���ִ� �������̽�!
class Point implements Comparable<Point> { // **Comparable �������̽��� ����ϸ� �ݵ�� compareTo()�޼��带 ������ �������!!
	public int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Point o) {
		if (this.x == o.x) {// x��ǥ�� ���� ������ y��ǥ���� �������� ����
			return this.y - o.y; // �������� ����! (������������ �Ϸ��� o.y - this.y) --> ������� ������ ����������
		} else {
			return this.x - o.x;
		}
	}
} // ���� �ܿ��α�!

public class S67 {// ��ǥ���� (2���� �迭 ����) - ��������

	public static void main(String[] args) throws IOException {
		S67 S = new S67();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());

		ArrayList<Point> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			arr.add(new Point(x, y));
		}

		Collections.sort(arr); //compareTo�� ������ ���� ���� �������� ������ �� ���
		
		for (Point o : arr) {
			System.out.println(o.x + " " + o.y);
		}

	}

}
