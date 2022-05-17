package Inflearn.Section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Time implements Comparable<Time> {
	// **Comparable �������̽��� ����ϸ� �ݵ�� compareTo()�޼��带 ������ �������
	public int s, e; // s = ���� �ð�, e = ������ �ð�

	Time(int s, int e) {
		this.s = s;
		this.e = e;
	}

	@Override
	public int compareTo(Time o) {
		// TODO Auto-generated method stub
		if (this.e == o.e) { // ������ �ð��� ������
			return this.s - o.s; // �����ϴ� �ð��� �������� ����(��������)
		} else
			return this.e - o.e; // ������ �ð��� �������� ����
	}
}

public class S902 { // ȸ�ǽ� ����
	public int solution(ArrayList<Time> arr, int n) {
		int cnt = 0;

		Collections.sort(arr); // compareTo() ���ؿ� ���ؼ� ����
		
		int end_time = 0; //ȸ�ǰ� ������ �ð�
		for (Time ob : arr) {
			if (ob.s >= end_time) {
				cnt++;
				end_time = ob.e;
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		S902 S = new S902();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());

		ArrayList<Time> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr.add(new Time(x, y));
		}

		System.out.println(S.solution(arr, n));
		
		
	}

}
