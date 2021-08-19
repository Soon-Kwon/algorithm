a = [[1,2,3],4,5]
b = [[6,7,8],1,2]

print(id(a))
print(id(b))
print(id(a[0]))

a = b.copy()

print(id(a))
print(id(b))
print(id(a[0]))

