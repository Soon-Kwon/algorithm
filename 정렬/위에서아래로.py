# 수열을 내림차순으로 정렬하는 프로그램을 만드시오

# 입력 조건
# 첫째 줄에 수열에 속해 있는 수의 개수 N이 주어진다.
# 둘째 줄부터 N+1번째 줄까지 N개의 수가 입력된다. 
# 수의 범위는 1이상 100,000 이하의 자연수 이다

# 출력 조건
# 입력으로 주어진 수열이 내림차순으로 정렬된 결과를 공백으로 구분하여 출력한다.

# 입력 예시
# 3
# 15
# 27
# 12

# 출력 예시
# 27 15 12

n = int(input())
array = []
for _ in range(n):
    array.append(int(input()))

array.sort()
array.reverse()

# 위 과정을 한꺼번에
# array = sorted(array, reverse=True)

for i in array:
    print(i, end=' ')