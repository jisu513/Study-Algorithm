package Inflearn.Section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//배열의 인덱스(id)와 우선순위(priority = 배열값)를 위한 person 클래스 생성
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
		for (int i = 0; i < n; i++) {
			q.offer(new Person(i, arr[i])); // arr[]은 우선순위가 들어있음!
		}

		while (!q.isEmpty()) {
			Person tmp = q.poll();
			for (Person x : q) {
				if (x.priority > tmp.priority) { // 숫자가 큰게 우선순위 높은 것!
					q.offer(tmp); // tmp가 x보다 우선순위 낮으므로 다시 q에 offer
					tmp = null;
					break;
				}
			}
			if (tmp != null) {  // tmp가 우선순위 더 높은 경우				
				// 특정숫자 m이 몇 번째로 진료받는지 구하는 것!
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
