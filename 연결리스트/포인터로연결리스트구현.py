from __future__ import annotations
from typing import Any, Type    

class Node:
    # 연결 리스트용 노드 클래스

    def __init__(self, data: Any = None, next: Node = None):
        self.data = data
        self.next = next

class LinkedList:
    # 연결 리스트 클래스

    def __init__(self) -> None:
        self.no = 0    # 리스트에 등록되어 있는 노드의 개수
        self.head = None    # 머리 노드에 대한 참조
        self.current = None     # 현재 주목하고 있는 노드에 대한 참조. 
    
    def __len__(self) -> int:
        # 연결 리스트의 노드 개수 반환
        return self.no

    def search(self, data: Any) -> int:
        # data와 값이 같은 노드를 검색
        cnt = 0
        ptr = self.head
        while ptr is not None:
            if ptr.data == data:
                self.current = ptr
                return cnt
            cnt += 1
            ptr = ptr.next
        return -1

    def __contains__(self, data: Any) -> bool:
        # 연결 리스트에 data가 포함되어 있는지 확인
        return self.search(data) >= 0
    
    def add_first(self, data: Any) -> None:
        # 맨 앞에 노드를 삽입
        ptr = self.head # 삽입하기 전의 머리 노드
        self.head = self.current = Node(data, ptr) # Node(data, ptr)은 삽입하기 전의 머리 노드를 참조하는 노드를 생성한다
        self.no += 1

    def add_last(self, data: Any) -> None:
        # 맨 끝에 노드를 삽입
        if self.head is None:   # 연결 리스트가 비어 있는 것이므로
            self.add_first(data)    # 그냥 맨 앞에 노드를 삽입
        else:
            ptr = self.head     # 삽입하기 전의 머리 노드 
            while ptr.next is not None:     # 머리 노드 부터 시작해서 다음 노드가 있는지 탐색하고
                ptr = ptr.next      # ptr.next가 없다는 것은 마지막(꼬리) 노드라는 뜻
            ptr.next = self.current = Node(data, None)
    
    def remove_first(self) -> None:
        # 머리 노드를 삭제
        if self.head is not None: # 리스트가 비어 있지 않으면
            self.head = self.current = self.head.next   # 머리 노드가 참조하고 있던 다음 노드를 참조한다. 
        self.no -= 1

    def remove_last(self) -> None:
        # 꼬리 노드를 삭제
        if self.head is not None: 
            if self.head.next is None: # 노드가 한 개 뿐이라면
                self.remove_first()
            else:
                ptr = self.head
                pre = None
                
                while ptr.next is not None:
                    pre = ptr
                    ptr = ptr.next
                pre.next = None
                self.current = pre
                self.no -= 1
                
    def remove(self, p: Node) -> None:
        # 노드 p를 삭제
        if self.head is not None:
            if p is self.head:      # p가 머리 노드이면 머리 노드를 삭제
                self.remove_first()
            else:
                ptr = self.head 

                while ptr.next is not p:
                    ptr = ptr.next
                    if ptr is None:     # 연결 리스트에 ptr이 존재하지 않음
                        return
                ptr.next = p.next
                self.current = ptr
                self.no -= 1

    def remove_current_node(self) -> None:
        # 주목 노드를 삭제
        self.remove(self.current)
    
    def clear(self) -> None: 
        # 전체 노드를 삭제
        while self.head is not None:
            self.remove_first()
        self.current = None
        self.no = 0
    
    def next(self) -> bool:
        # 주목 노드를 한 칸 뒤로 이동
        if self.current is None or self.current.next is None:
            return False
        self.current = self.current.next
        return True

    def print_current_node(self) -> None:
        # 주목 노드를 출력
        if self.current is None:
            print('주목 노드가 존재하지 않습니다.') 
        else:
            print(self.current.data)
        
    def print(self) -> None:
        # 모든 노드를 출력
        ptr = self.head
        
        while ptr is not None:
            print(ptr.data) 
            ptr = ptr.next
    
    def __iter__(self) -> LinkedListIterator:
        # 이터레이터를 반환
        return LinkedListIterator
    
class LinkedListIterator:

    def __init__(self, head:None):
        self.current = head

    def __iter__(self) -> LinkedListIterator:
        return self
    
    def __next___(self) -> Any:
        if self.current is None:
            raise StopIteration
        else:
            data = self.current.data
            self.current = self.current.next
            return data