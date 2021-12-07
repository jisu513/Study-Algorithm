package Baekjoon;

import java.io.*;
import java.util.*;

public class BJ1157 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int[] alpha = new int[26];
		int max = 0;
		char c = '?';

		for (int i = 0; i < str.length(); i++) { // 대-소문자 상관 없이 같은 index에서 count!
			if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
				alpha[str.charAt(i) - 'A']++;
			} else if ('a' <= str.charAt(i) && str.charAt(i) <= 'z') {
				alpha[str.charAt(i) - 'a']++;
			}

		}

		for (int i = 0; i < alpha.length; i++) {
			if (alpha[i] > max) {
				max = alpha[i];
				c = (char) (i + 65);

			} else if (alpha[i] == max) {
				c = '?';
			}
		}

		System.out.println(c);

	}

}
