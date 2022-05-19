package Inflearn.Section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Ftime implements Comparable<Ftime> {
	// **Comparable 인터페이스를 사용하면 반드시 compareTo()메서드를 재정의 해줘야함
	public int time; // 시간
	public char state; // 오는시간(s) 인지 가는시간(e)인지

	Ftime(int time, char state) {
		this.time = time;
		this.state = state;
	}

	@Override
	public int compareTo(Ftime ob) { // 정렬 기준
		// TODO Auto-generated method stub
		if (this.time == ob.time) { // 시간이 같으면
			return this.state - ob.state; // 알파벳 기준으로 정렬
			//s는 오는시간 e는 가는시간! 두 시간이 같은경우 가는시간인 e를 먼저(-->알파벳상에서 e가 먼저)
			// 이유: s,e가 같을 때 s를 먼저하면 피로연장에 존재하는 사람 수를 셀 때 오류가 생김! (인원을 더 많게 셈)
		} else {
			return this.time - ob.time; // 시간순서로 정렬
		}
	}
}

public class S903 { // 결혼식
	public int solution(ArrayList<Ftime> arr) {
		int answer = Integer.MIN_VALUE;

		Collections.sort(arr); // compareTo() 기준에 의해서 정렬

		int cnt = 0; // 피로연장에 있는 사람 수
		for(Ftime ob : arr) {
			if(ob.state == 's') {
				cnt++;
			}else { //'e' 이면 감소
				cnt--;
			}
			answer = Math.max(answer, cnt);
		}
		
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S903 S = new S903();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());

		ArrayList<Ftime> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int sT = Integer.parseInt(st.nextToken()); // 오는 시간
			int eT = Integer.parseInt(st.nextToken()); // 가는 시간
			arr.add(new Ftime(sT, 's'));
			arr.add(new Ftime(eT, 'e'));
		}

		System.out.println(S.solution(arr));

	}

}
