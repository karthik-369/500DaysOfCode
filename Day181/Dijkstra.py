import numpy as np
def dijikstra(mat, s):
    (rows, cols, x) = mat.shape
    infinity = np.max(mat)*rows+1
    (visited, distance) = ({},{})
    for v in range(rows):
        (visited[v], distance[v]) = (False, infinity)
    distance[s] = 0
    for u in range(rows):
        nextD = min([distance[v] for v in range(rows) if not visited[v]])
        nextVList = [v for v in range(rows) if (not visited[v]) and distance[v]==nextD]
        if nextVList == []:
            break
        nextV = min(nextVList)
        visited[nextV] = True
        for v in range(nextVList):
            if(mat[nextV, v, 0]==1 and (not visited[v])):
                distance[v] = min(distance[v], distance[nextV]+mat[nextV, v, 1])

    return (distance)

mat = [[]]

def dijkstraAdjList(wlist, s):
    infinity = 1 + len(wlist.keys())*max([d for u in wlist.keys() for (v,d) in wlist[u]])
    (visited, distance) = ({},{})
    for v in wlist.keys():
        (visited[v], distance[v]) = (False, infinity)
        distance[s] = 0
        for u in wlist.keys():
            nextD = min([distance[v] for v in wlist.keys() if not visited[v]])
            nextVList = [v for v in wlist.keys() if (not visited[v]) and distance[v]==nextD]
            if(nextVList==[]):
                break
            nextV = min(nextVList)
            visited[nextV] = True
            for (v,d) in wlist[nextV]:
                if not visited[v]:
                    distance[v] = min(distance[v], distance[nextV])

    return distance