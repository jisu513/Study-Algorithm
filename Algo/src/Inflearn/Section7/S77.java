package Inflearn.Section7;

import java.util.LinkedList;
import java.util.Queue;

class NewNode{ // ��Ű���� �ߺ� Ŭ������ ��� X
	int data;
	NewNode lt, rt;
	public NewNode(int val) {
		data = val;
		lt = rt = null;
	}
}
public class S77 { // ����Ʈ�� ��ȸ (���� �켱 Ž��)
	NewNode root;

	public void BFS(NewNode root) {
		Queue<NewNode> Q = new LinkedList<>();
		Q.offer(root);
		int L = 0;
		while (!Q.isEmpty()) {
			int len = Q.size();
			System.out.print(L + " : "); // Node�� Level
			for (int i = 0; i < len; i++) {
				NewNode current = Q.poll();
				System.out.print(current.data + " ");
				if (current.lt != null) { // �ڽĳ��
					Q.offer(current.lt);
				}
				if (current.rt != null) { // �ڽĳ��
					Q.offer(current.rt);
				}
			}
			L++;
			System.out.println(); // �ٹٲ�
		}

	}

	public static void main(String[] args) {
		S77 tree = new S77();

		tree.root = new NewNode(1);
		tree.root.lt = new NewNode(2);
		tree.root.rt = new NewNode(3);
		tree.root.lt.lt = new NewNode(4);
		tree.root.lt.rt = new NewNode(5);
		tree.root.rt.lt = new NewNode(6);
		tree.root.rt.rt = new NewNode(7);

		tree.BFS(tree.root);

	}

}
