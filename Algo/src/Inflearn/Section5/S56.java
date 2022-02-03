package Inflearn.Section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S56 {//���� ���ϱ�
	public int solution(int n, int k) {
		int answer = 0;
		
		/*Queue(First In First Out) : ���� ���� �����Ͱ� ���� ����! 
		    offer(): Queue�� �����͸� ���� �ִ� �Լ�
		    poll() : Queue���� �����͸� ������ �Լ�
		    size() : Queue�� ���� ������ ���� �˾Ƴ��� �Լ�
		    contanins(*) : *���� Queue�� �ִ����� ������ T/F�� �����ϴ� �Լ� 
		 */
		 	
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 0; i<n; i++) { //Queue�� n������ �� ����
			q.offer(i+1);
		}
		
		while(!q.isEmpty()) {
			for(int i = 1; i<k; i++) {
				q.offer(q.poll()); //k ������ ���ڵ��� ������ ���ÿ� �ٽ� Queue�� �� �ڿ� ����!
			}
			q.poll(); //k��° �� �� poll();
			if(q.size() == 1) { //Queue�� ���� ���ڰ� �ϳ� �� ��
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
