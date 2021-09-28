graph = [[] for i in range(10)]
distance = [int(1e9)] * (10)
graph[5] = [(2,3)]
for j in graph[5]:
    distance[j[0]] = j[1]