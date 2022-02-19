package Inflearn.Section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//�迭 �ε���(id)�� �켱����(priority)�� ���� person Ŭ���� ����
class Person {
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

		// q�� id�� priority ����!
		for (int i = 0; i < n; i++) {
			q.offer(new Person(i, arr[i])); // arr�� �켱���� ����ִ� �迭!
		}

		while (!q.isEmpty()) {
			Person tmp = q.poll();
			for (Person x : q) {
				if (x.priority > tmp.priority) { // ���ڰ� ū�� �켱���� ���� ��!
					q.offer(tmp); // tmp�� x���� �켱���� �����Ƿ� �ٽ� q�� offer
					tmp = null;
					break;
				}
			}
			if (tmp != null) { // tmp�� �켱���� �� ���� ���
				answer++;
				if (tmp.id == m) { // Ư������ m�� �� ��°�� ����޴��� ���ϴ� ��!
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
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(S.solution(n, k, arr));

	}

}
