import heapq
#const that is bigger than biggest edge
INF = 10**9 + 1

with open('input.txt', 'r') as input:
    points, connection = map(int, input.readline().split())
    graph = []
    for node in range(points):
        graph.append([])
    clients = set(map(lambda x: int(x) - 1, input.readline().split()))

    for distance in range(connection):
        startnode, endnode, latency = map(int, input.readline().split())
        startnode -= 1
        endnode -= 1
        graph[startnode].append((endnode, latency))
        graph[endnode].append((startnode, latency))

def algorithmD(start):
    global max_distace
    global clients
    heap_list = []
    element_trans = [-1]*points
    element_trans[start] = 0
    heapq.heappush(heap_list, (0, start))
    while len(heap_list)>0:
        cur_dist, cur_node = heapq.heappop(heap_list)
        for index in range(len(graph[cur_node])):
            action_one = graph[cur_node][index][0]
            distances = graph[cur_node][index][1]
            if(element_trans[action_one] == -1 or element_trans[action_one] > distances + element_trans[cur_node]):
                element_trans[action_one] = distances + element_trans[cur_node]
                heapq.heappush(heap_list, (element_trans[action_one], action_one))
    for second_trans in range(len(element_trans)):
        if second_trans in clients and (max_distace[start] == -1 or max_distace[start] < element_trans[second_trans]):
            max_distace[start] = element_trans[second_trans]





max_distace = [-1] * points
server_node = -1

for node in range(points):
    if not node in clients:
        algorithmD(node)

min = max_distace[0]
server_node = 1

for node in range(points):
    if min == -1:
        min = max_distace[node]
        server_node = node + 1
    elif max_distace[node] != -1 and max_distace[node] < min:
        min = max_distace[node]
        server_node = node + 1


with open('output.txt', 'w+') as output:
    output.write(str(min))
