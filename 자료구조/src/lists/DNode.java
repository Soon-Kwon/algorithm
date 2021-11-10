package lists;

public class DNode<E>{
	private E item;
	private DNode previous;
	private DNode next;
	
	public DNode(E newItem, DNode p, DNode q) {
		item = newItem;
		previous = p;
		next = q;
	}

	public E getItem() {
		return item;
	}

	public void setItem(E item) {
		this.item = item;
	}

	public DNode getPrevious() {
		return previous;
	}

	public void setPrevious(DNode previous) {
		this.previous = previous;
	}

	public DNode getNext() {
		return next;
	}

	public void setNext(DNode next) {
		this.next = next;
	}
	
	
}
