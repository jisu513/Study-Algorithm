package Inflearn.Section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Person{// 배열 인덱스(id)와 우선순위(priority)를 위한 person 클래스 생성
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
		
		for(int i = 0; i<arr.length; i++) {//q에 배열 인덱스와 우선순위(id, priority) 삽입
			q.offer(new Person(i, arr[i]));
		}
		while(!q.isEmpty()) {
			Person tmp = q.poll();
			for(Person x : q) {
				if(x.priority > tmp.priority) {//우선순위의 숫자가 높은게 먼저임!
					q.offer(tmp); // x의 우선순위가 더 높으므로 tmp를 q에 다시 삽입!
					tmp = null; // tmp 초기화!	
					break; //*** break 해줘야함!
				}
			}
			if(tmp != null) { //tmp의 우선순위가 x보다 높다는 의미!
				answer++;
				if(tmp.id == m) {//m이 몇 번째로 진료 받는지 구해야함
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
