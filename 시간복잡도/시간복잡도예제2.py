# 주어진 길이 N의 int 배열 arr에서 합이 100인 서로 다른 위치의
# 원소가 존재하면 1을, 존재하지 않으면 0을 반환하는 함수
# func2(int arr[], int N)을 작성하라. 
# arr의 각 수는 0 이상 100 이하이고 N은 1000 이하이다.

# func2({1, 52, 48}, 3) = 1,
# func2({50, 42}, 2) = 0,
# func2({4, 13, 63, 87}, 4) = 1

def func2(list, x):
    for i in range(0, x):
        for j in range(i+1, x):
            if(list[i] + list[j] == 100): return 1
    return 0

print(func2([1, 52, 48], 3))
print(func2([50, 42], 2))

# i가 0일 때 x-1 번 비교하고, i가 1일 때 x-2 번 비교하고, 
# i가 x-2일 때 1번 비교하니 총 x-1번 반복이 진행된다. 
# (x-1) + (x-2) + ... + 3 + 2 + 1 = x(x-1)/2 ==> O(N^2)