func isEulerCircuit( V int,  adj [][]int ) int  {
        // code here
        count := 0
        for i:=0; i<V; i++ {
            if ((len(adj[i]) & 1) == 1) {
                count++
            }
        }
        if count == 0 {
            return 2
        }
        if count == 2 {
			return 1
		}
		return 0
    }