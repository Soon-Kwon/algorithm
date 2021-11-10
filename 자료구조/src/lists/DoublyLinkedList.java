package lists;

public class DoublyLinkedList<E> {
	protected DNode head, tail;
	protected int size;
	
	public DoublyLinkedList(){
		head = new DNode(null, null, null);
		tail = new DNode(null, head, null);	// tail 이전 노드를 head로 만든다
		head.setNext(tail);	// head의 다음 노드를 tail로 만든다
		size = 0;
	}
	
	// p가 가르키는 노드 앞에 삽입
	public void insertBefore(DNode p, E newItem) {
		DNode t = p.getPrevious();	
		DNode newNode = new DNode(newItem, t, p);
		t.setNext(newNode);
		p.setPrevious(newNode);
		size++;
	}
	
	// p가 가르키는 노드 뒤에 삽입
	public void insertAfter(DNode p, E newItem) {
		DNode t = p.getNext();
		DNode newNode = new DNode(newItem, p, t);
		p.setNext(newNode);
		t.setPrevious(newNode);
		size++;
	}
	
	// x가 가르키는 노드 삭제
	public void delete(DNode x) {
		x.getPrevious().setNext(x.getNext());
		x.getNext().setPrevious(x.getPrevious());
		size--;
	}
	
}
