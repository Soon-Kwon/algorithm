# N 이하의 수 중에서 가장 큰 2의 거듭제곱수를 반환하는 함수
# func4(int N)을 작성하라. N은 10억 이하의 자연수이다.

# func4(5) = 4,
# func4(97615292) = 67108864,
# func4(1024) = 1024

def func4(x):
    val = 1
    while 2 * val <= x:
        val *= 2
    return val

print(func4(5))
print(func4(97615292)) 

# 위의 함수는 시간 복잡도가 O(lgN)으로 표현할 수 있다. 
    