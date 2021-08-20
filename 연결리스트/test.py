
a = [[1,2,3],4,5]
b = [[6,7,8],1,2]

a = b.copy()
a[0] = [11, 22]

print(a)
print(b)

a = [[1,2,3],4,5]
b = [[6,7,8],1,2]
a = b.copy()

a[0][1] = 2

print(a)
print(b)

import copy

a = copy.deepcopy(b)
a[0][1] = 4

print(a)
print(b)