func arrayStringsAreEqual(word1 []string, word2 []string) bool {
    w1,w2 := word1[0], word2[0]
    for i:=1; i<len(word1); i++ {
        w1+=word1[i]
    }
    for i:=1; i<len(word2); i++ {
        w2 += word2[i]
    }
    return w1 == w2
}