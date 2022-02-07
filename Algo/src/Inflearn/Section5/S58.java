package Inflearn.Section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Person{// �迭 �ε���(id)�� �켱����(priority)�� ���� person Ŭ���� ����
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
		
		for(int i = 0; i<arr.length; i++) {//q�� �迭 �ε����� �켱����(id, priority) ����
			q.offer(new Person(i, arr[i]));
		}
		while(!q.isEmpty()) {
			Person tmp = q.poll();
			for(Person x : q) {
				if(x.priority > tmp.priority) {//�켱������ ���ڰ� ������ ������!
					q.offer(tmp); // x�� �켱������ �� �����Ƿ� tmp�� q�� �ٽ� ����!
					tmp = null; // tmp �ʱ�ȭ!	
					break; //*** break �������!
				}
			}
			if(tmp != null) { //tmp�� �켱������ x���� ���ٴ� �ǹ�!
				answer++;
				if(tmp.id == m) {//m�� �� ��°�� ���� �޴��� ���ؾ���
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
