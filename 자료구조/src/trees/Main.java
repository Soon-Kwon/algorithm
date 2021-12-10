package trees;

public class Main {
	public static void main(String[] args) {
		Node n1 = new Node(100, null, null);
		Node n2 = new Node(200, null, null);
		Node n3 = new Node(300, null, null);
		Node n4 = new Node(400, null, null);
		Node n5 = new Node(500, null, null);
		Node n6 = new Node(600, null, null);
		Node n7 = new Node(700, null, null);
		Node n8 = new Node(800, null, null);
		
		n1.setLeft(n2);
		n1.setRight(n3);
		n2.setLeft(n4);
		n2.setRight(n5);
		n3.setLeft(n6);
		n3.setRight(n7);
		n4.setLeft(n8);
		
		BinaryTree t = new BinaryTree();
		t.setRoot(n1);
		
		System.out.println("트리 노드 수: " + t.size(t.getRoot())
			+ "\n트리높이: " + t.height(t.getRoot()));
		
		System.out.print("전위 순회: ");
		t.preorder(t.getRoot());
		
		System.out.print("\n중위 순회: ");
		t.inorder(t.getRoot());
		
		System.out.print("\n후위 순회: ");
		t.postorder(t.getRoot());
		
		Node n11 = new Node(100, null, null);
		Node n12 = new Node(200, null, null);
		Node n13 = new Node(300, null, null);
		Node n14 = new Node(400, null, null);
		Node n15 = new Node(500, null, null);
		Node n16 = new Node(600, null, null);
		Node n17 = new Node(700, null, null);
		Node n18 = new Node(800, null, null);
		
		n11.setLeft(n12);
		n11.setRight(n13);
		n12.setLeft(n14);
		n12.setRight(n15);
		n13.setLeft(n16);
		n13.setRight(n17);
		n14.setLeft(n18);
		
		BinaryTree t2 = new BinaryTree();
		t2.setRoot(n11);
		
		System.out.println();
		System.out.println("동일성 검사: " + BinaryTree.isEqual(t.getRoot(), t2.getRoot()));
	}
}
