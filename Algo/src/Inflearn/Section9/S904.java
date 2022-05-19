package Inflearn.Section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Lecture implements Comparable<Lecture> {
	public int money;
	public int date;

	Lecture(int money, int date) {
		this.money = money;
		this.date = date;
	}

	@Override
	public int compareTo(Lecture o) {
		return o.date - this.date; // �������� ����
	}

}

public class S904 { //�ִ� ���� ������
	static int n, max = Integer.MIN_VALUE;
	//n�� ���� ����

	public int solution(ArrayList<Lecture> arr) {
		int answer = 0;
		
		PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
		// ����Ʈ�� �������� -> Collections.reverseOrder()�� �������� ����!
		/*
		  PriorityQueue() :
		    ���� ���� ������� �����Ͱ� ������ ���� �ƴ� �켱������ ���� �����ϰ� �� �켱������ ���� ������Ʈ�� ���� ������ �ڷᱸ��
		   (�Ϲ����� Queue�� ���� �����Ͱ� ���� ������ ����)
		  */
		Collections.sort(arr);
		int j = 0;
		for(int i = max; i >= 1; i--) { //max�� �Է¹��� d(��¥)�� ���� ū ���� ����Ǿ� ����
			for(; j < n; j++) { 
				if(arr.get(j).date < i) {
					break; //���� date�� ���� money���� ���ϱ� ���ؼ�
				}
				pQ.offer(arr.get(j).money);
			}
			if(!pQ.isEmpty()) {
				answer += pQ.poll(); // pQ�� ��� �ִ� ���� �� ���� ū �� poll() ->PriorityQueue<>�� ���� (���� date����)
			}
		}
		

		return answer;
	}

	public static void main(String[] args) throws IOException {
		S904 S = new S904();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine());

		ArrayList<Lecture> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			arr.add(new Lecture(m, d));
			if(d > max) {
				max = d;
			}
		}
		
		System.out.println(S.solution(arr));

	}

}
