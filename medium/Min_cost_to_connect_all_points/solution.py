def minCostConnectPoints(points) -> int:
    points_num = len(points)
    visited = {}
    for i in range(points_num):
        try:
            visited[points[i][0]][points[i][1]] = False
        except KeyError:
            visited[points[i][0]] = {}
            visited[points[i][0]][points[i][1]] = False
    cost = 0
    for i in range(points_num):
        j = 0

        cur_point = points[i]
        if visited[cur_point[0]][cur_point[1]]:
            continue
        lowest = 0
        min_j = 0
        while j < points_num:
            if i == j:
                j += 1
                continue
            next_point = points[j]
            man = abs(cur_point[0]-next_point[0]) + \
                abs(cur_point[1]-next_point[1])
            if lowest == 0:
                lowest = man
            else:
                if man < lowest:
                    min_j = j
                    lowest = man
            j += 1
        cost += lowest
        visited[points[min_j][0]][points[min_j][1]] = True

    return cost


minCostConnectPoints([[-1000000, -1000000], [1000000, 1000000]])
