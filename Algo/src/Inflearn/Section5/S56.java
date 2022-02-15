package Inflearn.Section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S56 {// 공주 구하기
	public int solution(int n, int k) {
		int answer = 0;

		/*
		 * Queue(First In First Out) : 먼저 들어오 데이터가 먼저 나감! 
		 * offer(): Queue에 데이터를 집어 넣는 함수
		 * poll() : Queue에서 데이터를 빼내는 함수 
		 * size() : Queue의 크기 구하는 함수 
		 * contanins(#) : #값이 Queue에 있는지의 유무를 T/F로 리턴하는 함수
		 */

		Queue<Integer> q = new LinkedList<>();
		//q에 1~n까지의 숫자 offer()
		for (int i = 0; i < n; i++) {
			q.offer(i + 1);
		}
		while (!q.isEmpty()) {
			// k바로 전의 숫자까지 poll()하고  다시 offer()
			for (int i = 1; i < k; i++) {
				q.offer(q.poll());
			}
			//k번째 poll()
			q.poll();
			if (q.size() == 1) {
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
