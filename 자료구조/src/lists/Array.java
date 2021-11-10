package lists;

import java.util.NoSuchElementException;

public class Array<E> {
	private E a[];	// 리스트의 항목들을 저장할 배열
	private int size;	// 리스트의 항목 수
	
	public Array() {
		a = (E[]) new Object[1];	// 최초로 1개의 원소를 가진 배열 생성
		size = 0;
	}
	
	// k번째 항목을 리턴, 단순히 읽기만 한다
	public E peek(int k) {	
		if(size == 0)
			throw new NoSuchElementException();	// underflow 경우에 프로그램 정지
		return a[k];
	}
	
	// 가장 뒤에 새 항목 삽입
	public void insertLast(E newItem) {	
		if(size == a.length)	// 배열에 빈 공간이 없으면
			resize(2*a.length);	// 배열 크기 2배로 확장
		a[size++] = newItem;	// 새 항목 삽입
	}
	
	// 새 항목을 배열의 k번째에 삽입
	public void insert(E newItem, int k) { 
		if(size == a.length)
			resize(2*a.length);
		for(int i = size-1; i >= k; i--)	// 한 칸씩 뒤로 이동
			a[i+1] = a[i];
		a[k] = newItem;
		size++;
	}
	
	// 배열 크기 조정
	private void resize(int newSize) {	
		Object[] t = new Object[newSize];
		for(int i = 0; i < size; i++)
			t[i] = a[i];	// 배열 a를 배열 t로 복사
		a = (E[]) t;	// 배열 t를 배열 a로 복사 => 기존의 배열 a가 가비지 컬렉션에 의해 처리된다.
	}
	
	// k번째 항목 삭제
	public E delete(int k) {	
		if(isEmpty()) throw new NoSuchElementException();
		E item = a[k];
		for(int i = k; i < size; i++)
			a[i] = a[i+1];	// 한 칸씩 앞으로 이동
		size--;
		if(size > 0 && size == a.length/4)	//배열에 항목들이 1/4만 차지한다면
			resize(a.length/2);	// 배열을 1/2 크기로 축소
		return item;
	}
	
	// 배열이 비었나 확인
	private boolean isEmpty() {
		return size == 0;
	}
}
