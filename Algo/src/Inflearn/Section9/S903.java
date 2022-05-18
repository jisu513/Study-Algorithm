package Inflearn.Section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class F_time implements Comparable<F_time> {
	// **Comparable 인터페이스를 사용하면 반드시 compareTo()메서드를 재정의 해줘야함
	public int s, e; // s = 친구 오는 시간, e = 가는 시간

	F_time(int s, int e) {
		this.s = s;
		this.e = e;
	}

	@Override
	public int compareTo(F_time o) {
		// TODO Auto-generated method stub
		if (this.e == o.e) { // 끝나는 시간이 같으면
			return this.s - o.s; // 시작하는 시간을 기준으로 정렬(오름차순)
		} else
			return this.e - o.e; // 끝나는 시간을 기준으로 정렬
	}
}

public class S903 { // 결혼식

	public static void main(String[] args) throws IOException {
		S903 S = new S903();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());

	}

}
