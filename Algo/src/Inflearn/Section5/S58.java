package Inflearn.Section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//배열 인덱스(id)와 우선순위(priority)를 위한 person 클래스 생성
class Person {
	int id;
	int priority;

	public Person(int id, int priority) {
		this.id = id;
		this.priority = priority;
	}
}

public class S58 {// 응급실
	public int solution(int n, int m, int[] arr) {
		int answer = 0;

		Queue<Person> q = new LinkedList<>();
		// q에 id와 priority 삽입!
		for (int i = 0; i < arr.length; i++) {
			q.offer(new Person(i, arr[i]));
		}

		// arr은 우선순위 들어있는 배열!
		while (!q.isEmpty()) {
			Person tmp = q.poll();
			for (Person x : q) {
				if (x.priority > tmp.priority) {
					q.offer(tmp);
					tmp = null;
					break;
				}
			}
			if (tmp != null) {
				answer++;
				if (tmp.id == m) {
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
