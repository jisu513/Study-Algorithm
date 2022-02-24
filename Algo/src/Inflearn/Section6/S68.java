package Inflearn.Section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S68 { // 이진검색
	public int solution(int n, int m, int[] arr) {
		int answer = 0;
		Arrays.sort(arr);
		
		// 순차검색 -> 시간복잡도 O(n)
		/*for(int i = 0; i<n; i++) {
			if(arr[i] == m) {
				answer = i+1;
				break;
			}
		}*/
		
		//이분 검색(무조건 먼저 정렬이 되어 있어야함!) -> 시간복잡도는 O(logn)
		int lt = 0, rt = n-1;
		while(lt <= rt) {
			int mid = (lt+rt)/2;
			if(arr[mid] == m) {
				answer = mid+1;
				break;
			}
			if(arr[mid] > m) {
				rt = mid-1;
			}else {
				lt = mid+1;
			}
		}
		
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S68 S = new S68();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(S.solution(n, m, arr));

	}

}
