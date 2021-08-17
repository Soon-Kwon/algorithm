# 문제
# 알파벳 소문자로만 이루어진 단어 S가 주어진다. 각 알파벳이 단어에 몇 개가 포함되어 있는지 구하는 프로그램을 작성하시오.

# 입력
# 첫째 줄에 단어 S가 주어진다. 단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.

# 출력
# 단어에 포함되어 있는 a의 개수, b의 개수, …, z의 개수를 공백으로 구분해서 출력한다.

from string import ascii_lowercase
S = list(input())
A = list(ascii_lowercase)
for x in A:
    count = 0
    for i in S:
        if(x==i): count += 1
    print(count) 

# 숏코딩 print(*map(input().count,map(chr,range(97,123)))) 

# s = input()
# result = [0]*26
# for i in range(len(s)):
#     result[ord(s[i]) - 97] += 1
# print(' '.join(map(str,result)))

# ord(유니코드문자) <-> chr(숫자)  