package lists;

// 단순연결리스트의 노드 클래스
public class SNode <E>{
	private E item;
	private SNode<E> next;
	
	public SNode(E newItem, SNode<E> node) {	// 노드 생성자
		item = newItem;
		next = node;
	}
	
	public E getItem() {return item;}
	public SNode<E> getNext() {return next;}
	public void setItem(E newItem) {item = newItem;}
	public void setNext(SNode<E> node) {next = node;}
	
}