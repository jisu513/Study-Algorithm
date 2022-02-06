package Inflearn.Section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Person{// q삽입 순서(id)와 우선순위(priority)를 위한 person 클래스 생성
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
		
		for(int i = 0; i<n; i++) {// q에 (id, priority) 데이터 삽입!
			q.offer(new Person(i, arr[i]));
		}
		while(!q.isEmpty()) {
			Person check = q.poll();
			for(Person x : q) {
				if(x.priority > check.priority) {// check의 우선순위보다 q에 있는 다른값의 우선순위가 높으면
					q.offer(check); // check를 다시 q에 삽입 
					check = null; // check값 초기화
					break;
				}
			}
			if(check != null) {//check가 null이 아니라는 것은 check가 가장 우선으로 진료받는 경우
				answer++;
				if(check.id == m) {// m이 몇번 째로 진료를 받는 것인 지 구하는 것이므로
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
