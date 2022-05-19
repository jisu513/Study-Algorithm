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
		return o.date - this.date; // 내림차순 정렬
	}

}

public class S904 { //최대 수입 스케쥴
	static int n, max = Integer.MIN_VALUE;
	//n은 강연 개수

	public int solution(ArrayList<Lecture> arr) {
		int answer = 0;
		
		PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
		// 디폴트는 오름차순 -> Collections.reverseOrder()면 내림차순 정렬!
		/*
		  PriorityQueue() :
		    먼저 들어온 순서대로 데이터가 나가는 것이 아닌 우선순위를 먼저 결정하고 그 우선순위가 높은 엘리먼트가 먼저 나가는 자료구조
		   (일반적인 Queue는 들어온 데이터가 먼저 나가는 구조)
		  */
		Collections.sort(arr);
		int j = 0;
		for(int i = max; i >= 1; i--) { //max에 입력받을 d(날짜)의 제일 큰 값이 저장되어 있음
			for(; j < n; j++) { 
				if(arr.get(j).date < i) {
					break; //같은 date일 때의 money만을 비교하기 위해서
				}
				pQ.offer(arr.get(j).money);
			}
			if(!pQ.isEmpty()) {
				answer += pQ.poll(); // pQ에 들어 있는 값들 중 가장 큰 값 poll() ->PriorityQueue<>에 의해 (같은 date에서)
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
