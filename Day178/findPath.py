from collections import deque
class myQueue:
    def __init__(self):
        self.Q = deque()
    def deQueue(self):
        return self.Q.popleft()
    def enQueue(self, x):
        return self.Q.append(x)
    def isEmpty(self):
        return False if self.Q else True
    
def findComponents_undirectedGraph(vertices, edges):

    GList = {}
    for i in vertices:
        GList[i]=[]
    for (i,j) in edges:
        GList[i].append(j)
        GList[j].append(i)
# Mark every vertex not visited.
    visited = {v:False for v in vertices}
    
    q = myQueue()
    componentsCount = 0
# 1. Select some vertex v
# 2. Start traversing the graph from v, till all vertices are visited in this component. Increment component count.
# 3. Search for any unvisited vertex v, go to step 2
    for v in vertices:
        if not visited[v]:
            q.enQueue(v)
            while not q.isEmpty():
                v = q.deQueue()
                if not visited[v]:
                    for i in GList[v]:
                        if(not visited[i]):
                            q.enQueue(i)
                    visited[v]=True
            componentsCount += 1
    return componentsCount