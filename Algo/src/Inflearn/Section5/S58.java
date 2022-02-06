package Inflearn.Section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Person{// q���� ����(id)�� �켱����(priority)�� ���� person Ŭ���� ����
	int id;
	int priority;
	public Person(int id, int priority) {
		this.id = id;
		this.priority = priority;
	}	
}

public class S58 {// ���޽�
	public int solution(int n, int m, int[] arr) {
		int answer = 0;
		
		Queue<Person> q = new LinkedList<>();
		
		for(int i = 0; i<n; i++) {// q�� (id, priority) ������ ����!
			q.offer(new Person(i, arr[i]));
		}
		while(!q.isEmpty()) {
			Person check = q.poll();
			for(Person x : q) {
				if(x.priority > check.priority) {// check�� �켱�������� q�� �ִ� �ٸ����� �켱������ ������
					q.offer(check); // check�� �ٽ� q�� ���� 
					check = null; // check�� �ʱ�ȭ
					break;
				}
			}
			if(check != null) {//check�� null�� �ƴ϶�� ���� check�� ���� �켱���� ����޴� ���
				answer++;
				if(check.id == m) {// m�� ��� °�� ���Ḧ �޴� ���� �� ���ϴ� ���̹Ƿ�
					return answer;
				}
			}
		}
		
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S58 S = new S58();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(S.solution(n, k, arr));

	}

}
