package Inflearn.Section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Ftime implements Comparable<Ftime> {
	// **Comparable �������̽��� ����ϸ� �ݵ�� compareTo()�޼��带 ������ �������
	public int time; // �ð�
	public char state; // ���½ð�(s) ���� ���½ð�(e)����

	Ftime(int time, char state) {
		this.time = time;
		this.state = state;
	}

	@Override
	public int compareTo(Ftime ob) { // ���� ����
		// TODO Auto-generated method stub
		if (this.time == ob.time) { // �ð��� ������
			return this.state - ob.state; // ���ĺ� �������� ����
			//s�� ���½ð� e�� ���½ð�! �� �ð��� ������� ���½ð��� e�� ����(-->���ĺ��󿡼� e�� ����)
			// ����: s,e�� ���� �� s�� �����ϸ� �Ƿο��忡 �����ϴ� ��� ���� �� �� ������ ����! (�ο��� �� ���� ��)
		} else {
			return this.time - ob.time; // �ð������� ����
		}
	}
}

public class S903 { // ��ȥ��
	public int solution(ArrayList<Ftime> arr) {
		int answer = Integer.MIN_VALUE;

		Collections.sort(arr); // compareTo() ���ؿ� ���ؼ� ����

		int cnt = 0; // �Ƿο��忡 �ִ� ��� ��
		for(Ftime ob : arr) {
			if(ob.state == 's') {
				cnt++;
			}else { //'e' �̸� ����
				cnt--;
			}
			answer = Math.max(answer, cnt);
		}
		
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S903 S = new S903();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());

		ArrayList<Ftime> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int sT = Integer.parseInt(st.nextToken()); // ���� �ð�
			int eT = Integer.parseInt(st.nextToken()); // ���� �ð�
			arr.add(new Ftime(sT, 's'));
			arr.add(new Ftime(eT, 'e'));
		}

		System.out.println(S.solution(arr));

	}

}
