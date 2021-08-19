from __future__ import annotations
from typing import Any, Type    

class Node:
    # 연결리스트용 노드 클래스

    def __init__(self, data: Any = None, next: Node = None):
        self.data = data
        self.next = next