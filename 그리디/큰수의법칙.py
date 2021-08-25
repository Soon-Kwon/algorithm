# 큰 수의 법칙
# 다양한 수로 이루어진 배열이 있을 때, 주어진 수들을 M번 더하여 가장 큰 수를 만드는 법칙
# 단, 배열의 특정한 인덱스(번호)에 해당하는 수가 연속해서 K번 초과하여 더해질 수 없다.
# 또한, 서로 다른 인덱스에 해당하는 수가 같은 경우에도 서로 다른 것으로 간주

# -입력 조건-
# 첫째 줄에 N, M, K의 자연수가 주어지며, 각 자연수는 공백으로 구분한다
# (2≤N≤1,000, 1≤M≤10,000, 1≤K≤10,000)
# 둘째 줄에 N개의 자연수가 주어진다. 각 자연수는 공백으로 구분한다.
# 단, 각각의 자연수는 1이상 10,000이하의 수로 주어진다
# 입력으로 주어지는 K는 항상 M보다 작거나 같다

# -출력 조건-
# 첫째 줄에 큰 수의 법칙에 따라 더해진 답을 출력한다

# 생각해보자... 최대값을 K번 더하고 두번째로 큰 수가 1번 더해지는 패턴이 반복된다.
# 그것을 총 M번 반복한다. 
# 다만 최대값이 다른 인덱스에 있는 경우도 생각해주어야 한다. 

n, m, k = map(int, input().split())
arr = list(map(int, input().split()))

# arr에서 최대값을 찾자
first_max = max(arr)
# arr 에서 최대값을 가진 맨 앞 인덱스를 삭제하자 
arr.remove(first_max)
# 두 번째로 큰 값을 찾자 
second_max = max(arr)

sum = 0
repeat = 0
for i in range(m):
    repeat += 1
    if(k < repeat):
        repeat = 0
        sum += second_max 
    else: 
        sum += first_max

print(sum)

# 수학적 방식을 통한 접근 
n, m, k = map(int, input().split())
data = list(map(int, input().split()))

data.sort() 
first = data[n-1]
second = data[n-2]
'''
가장 큰 수가 더해지는 횟수 계산
int(m/(k+1)) 은 반복되는 수열이 몇 번 등장하는지 나타내고,
그 안에 가장 큰 수가 k번 반복등장하므로 k를 곱해준다 
'''
count = int(m/(k+1)) * k    
# 나머지만큼 가장 큰 수가 더 등장한다. 
count += m % (k+1)

result = 0
result += count * first
result += (m-count) * second

print(result)