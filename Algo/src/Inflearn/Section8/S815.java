package Inflearn.Section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point1 { // ��ǥ
	public int x, y;

	Point1(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class S815 { // ���� ��� �Ÿ�(DFS)
	/*        1-��, 2-������
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
			int sum = 0; // �� ����� ������ ���ڹ�� �Ÿ�
			for(Point1 h : house) {
				int dis = Integer.MAX_VALUE;
				for(int i : combi) { // i�� ���õ� ������ (len���� ������ �� ���õ� m���� ���������� ����)
					dis = Math.min(dis, Math.abs(h.x - pizza.get(i).x) + Math.abs(h.y - pizza.get(i).y));
					/*
					 abs(): ���ڰ��� ���� ���밪�� ��ȯ�ϴ� �Լ�!
					 pizza.get(i).x => ArrayList pizza �� i��° �ε����� �ִ� ������ ���� �� �� ���� x��ǥ
					 */
				} // dis�� h�� ���ڹ�ްŸ�
				sum += dis; // ������ ���ڹ�ްŸ�
			}
			answer = Math.min(answer, sum);
		}else {
			for(int i = s; i < len; i++) { //S809 ���ձ��ϱ� (**�ܿ��**)
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
		m = Integer.parseInt(st.nextToken()); // m���� ������
		
		pizza = new ArrayList<>();
		house = new ArrayList<>();

	  // n*nũ��
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int tmp = Integer.parseInt(st.nextToken()); // ���� �о���̱�
				if(tmp == 1) {
					house.add(new Point1(i,j));
				}else if(tmp == 2) {
					pizza.add(new Point1(i,j));
				}
			}
		}
		len = pizza.size(); // �Է¹��� ����� ������ ���� --> len���� ������ �߿��� m�� ���� = lenCm (����)
		combi = new int[m];
		S.DFS(0, 0);
		System.out.println(answer);
		

	}

}
