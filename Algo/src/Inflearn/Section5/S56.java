package Inflearn.Section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S56 {//공주 구하기
	public int solution(int n, int k) {
		int answer = 0;
		
		/*Queue(First In First Out) : 먼저 들어오 데이터가 먼저 나감! 
		    offer(): Queue에 데이터를 집어 넣는 함수
		    poll() : Queue에서 데이터를 빼내는 함수
		    size() : Queue의 크기 구하는 함수
		    contanins(*) : *값이 Queue에 있는지의 유무를 T/F로 리턴하는 함수 
		 */
		 	
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 0; i<n; i++) { //Queue에 n까지의 수 삽입
			q.offer(i+1);
		}
		
		while(!q.isEmpty()) {
			for(int i = 1; i<k; i++) {
				q.offer(q.poll()); //k 이전의 숫자들은 빼냄과 동시에 다시 Queue의 맨 뒤에 삽입!
			}
			q.poll(); //k번째 일 때 poll();
			if(q.size() == 1) { //Queue에 남은 숫자가 하나 일 때
				answer = q.poll();
			}
		}
		
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S56 S = new S56();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		System.out.println(S.solution(n, k));
		

	}

}
