# N이 제곱수이면 1을 반환하고 제곱수가 아니면 0을 반환하는 함수
# func3(int N)을 작성하라. N은 10억 이하의 자연수이다. 

# func3(9) = 1,
# func3(693953651) = 0,
# func3(756580036) = 1

# def func3(x):
#     sum = 0
#     for i in range(1, x + 1):
#         if(x % i == 0): sum += 1
#     if(sum % 2 != 0): return 1
#     return 0

# print(func3(693953651))

def func3(x):
    i = 1
    while i * i <= x:
        if(i * i == x): return 1
        i += 1
    return 0

print(func3(693953651))

# 위의 함수는 시간 복잡도가 O(√N)으로 표현할 수 있다. 