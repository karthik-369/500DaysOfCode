func winnerOfGame(colors string) bool {
    alice_plays, bob_plays, count := 0, 0, 0
    
    for i := 1; i < len(colors); i++ {
        if colors[i] == colors[i-1] {
            count++
        } else {
            if colors[i-1] == 'A' {
                alice_plays += max(0, count - 1)
            } else {
                bob_plays += max(0, count - 1)
            }
            count = 0
        }
    }

    if colors[len(colors)-1] == 'A' {
        alice_plays += max(0, count - 1)
    } else {
        bob_plays += max(0, count - 1)
    }
    
    return alice_plays > bob_plays
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
