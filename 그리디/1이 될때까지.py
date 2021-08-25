# 어떤수 N이 1이 될 때까지 다음의 두 과정 중 하나를 반복적으로 선택하여 수행하려고한다. 
# 단, 두번째 연산은 N이 K로 나누어떨어질 때만 선택할 수 있다.

# 1. N에서 1을 뺀다.
# 2. N을 K로 나눈다.

# 예를 들어 N = 17, K = 4일 경우
# 1) 17 - 1 = 16
# 2) 16 // 4 = 4
# 3) 4 // 4 = 1

# 전체 과정을 실행한 횟수는 3이 된다. 이는 N을 1로 만드는 최소 횟수이다. 

n, k = map(int, input().split())

count = 0

while(n != 1): 
    if(n % k == 0):
        n //= k
        count += 1
    else:
        n -= 1
        count += 1

print(count)

# 수학적으로 풀어보기 
n, k = map(int, input().split())
result = 0

while(True):
    # n이 k로 나누어 떨어질 때까지 1씩 빼기위한 계산
    target = (n//k) * k 
    result += (n-target)
    n = target 
    # n이 k보다 작을 때 -> 항상 1씩 빼게된다.
    if n < k: 
        break
    # k로 나눠지는 수가 되었으니 k로 나눈다. 
    result += 1
    n //= k 

    # 나눠지지 않고 마지막으로 남은 수는 항상 1로 빼게되니까 n-1 번의 과정을 거친다
result += (n-1)
print(result)
    