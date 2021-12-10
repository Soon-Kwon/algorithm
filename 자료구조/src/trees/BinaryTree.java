package trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<Key extends Comparable<Key>>{
	private Node<Key> root;
	
	// 트리 생성자
	public BinaryTree() {
		root=null;
	}
	
	public Node<Key> getRoot() {
		return root;
	}
	
	public void setRoot(Node<Key> newroot) {
		this.root = newroot;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	// 전위 순회
	public void preorder(Node n) {
		if(n != null) {
			System.out.print(n.getKey() + " ");
			preorder(n.getLeft());
			preorder(n.getRight());
		}
	}
	
	// 중위 순회
	public void inorder(Node n) {
		if(n != null) {
			inorder(n.getLeft());
			System.out.print(n.getKey() + " ");
			inorder(n.getRight());
		}
	}
	
	// 후위순회
	public void postorder(Node n) {
		if(n != null) {
			postorder(n.getLeft());
			postorder(n.getRight());
			System.out.print(n.getKey() + " ");
		}
	}
	
	// 레벨순회
	public void levelorder(Node root) {
		Queue<Node> q = new LinkedList<Node>();	// 큐 자료구조 이용
		Node t;
		q.add(root); // 루트 노드 큐에 삽입
		
		while(!q.isEmpty()) {
			t = q.remove();	// 큐에서 가장 아에 있는 노드 제거하고 그것을 반환
			System.out.println(t.getKey() + " ");
			if(t.getLeft() != null) {
				q.add(t.getLeft());
			}
			if(t.getRight() != null) {
				q.add(t.getRight());
			}
		}
	}
	
	// n을 루트로 하는 (서브)트리에 있는 노드 수
	public int size(Node n) {
		if(n == null) {
			return 0;
		}else {
			return (1 + size(n.getLeft()) + size(n.getRight()));
		}
	}
	
	// n을 루트로 하는 (서브)트리의 높이
	public int height(Node n) {
		if(n == null) {
			return 0;
		}else {
			return (1 + Math.max(height(n.getLeft()), height(n.getRight())));
		}
	}
	
	// 두 트리의 동일성 검사(전위 순회 이용)
	public static boolean isEqual(Node n, Node m) {
		if(n == null || m == null) {
			return n == m;
		}
		
		if(n.getKey().compareTo(m.getKey()) != 0) {
			return false;
		}
		
		return (isEqual(n.getLeft(), m.getLeft())) && 
				isEqual(n.getRight(), n.getRight());
	}
}
