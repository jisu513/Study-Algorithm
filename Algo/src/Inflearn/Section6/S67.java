package Inflearn.Section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

//객체 비교 -> Comparable<>는 객체간의 비교를 가능하게 해주는 인터페이스!
class Point implements Comparable<Point> {
	// **Comparable 인터페이스를 사용하면 반드시 compareTo()메서드를 재정의 해줘야함!!
	public int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Point o) {
		if (this.x == o.x) {// x좌표의 값이 같으면 y좌표값을 기준으로 정렬
			return this.y - o.y; // 오름차순 정렬! (내림차순으로 하려면 o.y - this.y) --> 결과값은 무조건 음수여야함
		} else {
			return this.x - o.x;
		}
	}

} // 패턴 외우기

public class S67 {// 좌표정렬 (2차원 배열 정렬) - 오름차순

	public static void main(String[] args) throws IOException {
		S67 S = new S67();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());
		ArrayList<Point> arr = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			arr.add(new Point(x, y));
		}
 
		Collections.sort(arr); // compareTo로 정의해 놓은 것을 기준으로 정렬할 때 사용

		for (Point o : arr) {
			System.out.println(o.x + " " + o.y);
		}

	}

}
