package Inflearn.Section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
S607 좌표정렬 부분 복습하기!! 
객체 비교 -> Comparable<>는 객체간의 비교를 가능하게 해주는 인터페이스
*/
class Body implements Comparable<Body> {
	// **Comparable 인터페이스를 사용하면 반드시 compareTo()메서드를 재정의 해줘야함
	public int h, w;

	Body(int h, int w) {
		this.h = h;
		this.w = w;
	}

	@Override
	public int compareTo(Body o) {
		// TODO Auto-generated method stub
		return o.h - this.h; // 내림차순 정렬
	}
}

public class S901 { // 씨름선수 (그리디 알고리즘)
	// 그리디(탐욕) 알고리즘 : 현재 상황에서 가장 좋은 것을 선택해나가는 알고리즘 -> 전체 결과에서 가장 좋은 것이라는 보장은 없음!
	public int solution(ArrayList<Body> arr, int n) {
		int cnt = 0; // 선발되는 인원 수
		Collections.sort(arr); // 정렬!
		int max = Integer.MIN_VALUE;
		for (Body b : arr) {
			if (b.w > max) {
				max = b.w;
				cnt++;
			}
		}

		return cnt;
	}

	public static void main(String[] args) throws IOException {
		S901 S = new S901();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());

		ArrayList<Body> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr.add(new Body(h, w));
		}

		System.out.println(S.solution(arr, n));

	}

}
