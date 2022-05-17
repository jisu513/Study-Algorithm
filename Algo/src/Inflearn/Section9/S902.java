package Inflearn.Section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Time implements Comparable<Time> {
	// **Comparable 인터페이스를 사용하면 반드시 compareTo()메서드를 재정의 해줘야함
	public int s, e; // s = 시작 시간, e = 끝나는 시간

	Time(int s, int e) {
		this.s = s;
		this.e = e;
	}

	@Override
	public int compareTo(Time o) {
		// TODO Auto-generated method stub
		if (this.e == o.e) { // 끝나는 시간이 같으면
			return this.s - o.s; // 시작하는 시간을 기준으로 정렬(오름차순)
		} else
			return this.e - o.e; // 끝나는 시간을 기준으로 정렬
	}
}

public class S902 { // 회의실 배정
	public int solution(ArrayList<Time> arr, int n) {
		int cnt = 0;

		Collections.sort(arr); // compareTo() 기준에 의해서 정렬
		
		int end_time = 0; //회의가 끝나는 시간
		for (Time ob : arr) {
			if (ob.s >= end_time) {
				cnt++;
				end_time = ob.e;
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		S902 S = new S902();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());

		ArrayList<Time> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr.add(new Time(x, y));
		}

		System.out.println(S.solution(arr, n));
		
		
	}

}
