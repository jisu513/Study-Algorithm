package Inflearn.Section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point1 { // 좌표
	public int x, y;

	Point1(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class S815 { // 피자 배달 거리(DFS)
	/*        1-집, 2-피자집
	  0 1 2 0
      1 0 2 1
      0 2 1 2
      2 0 1 2
     */
	static int n, m, len, answer = Integer.MAX_VALUE;
	static int[] combi;
	static ArrayList<Point1> pizza, house;
	
	public void DFS(int L, int s) { 
		if(L == m) {
			int sum = 0; // 각 경우의 도시의 피자배달 거리
			for(Point1 h : house) {
				int dis = Integer.MAX_VALUE;
				for(int i : combi) { // i는 선택된 피자집 (len개의 피자집 중 선택된 m개의 피자집들의 조합)
					dis = Math.min(dis, Math.abs(h.x - pizza.get(i).x) + Math.abs(h.y - pizza.get(i).y));
					/*
					 abs(): 인자값에 대한 절대값을 반환하는 함수!
					 pizza.get(i).x => ArrayList pizza 의 i번째 인덱스에 있는 피자집 접근 후 그 집의 x좌표
					 */
				} // dis는 h의 피자배달거리
				sum += dis; // 도시의 피자배달거리
			}
			answer = Math.min(answer, sum);
		}else {
			for(int i = s; i < len; i++) { //S809 조합구하기 (**외우기**)
				combi[L] = i;
				DFS(L+1, i+1);
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		S815 S = new S815();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken()); // m개의 피자집
		
		pizza = new ArrayList<>();
		house = new ArrayList<>();

	  // n*n크기
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int tmp = Integer.parseInt(st.nextToken()); // 열로 읽어들이기
				if(tmp == 1) {
					house.add(new Point1(i,j));
				}else if(tmp == 2) {
					pizza.add(new Point1(i,j));
				}
			}
		}
		len = pizza.size(); // 입력받은 행렬의 피자집 개수 --> len개의 피자집 중에서 m개 선택 = lenCm (조합)
		combi = new int[m];
		S.DFS(0, 0);
		System.out.println(answer);
		

	}

}
