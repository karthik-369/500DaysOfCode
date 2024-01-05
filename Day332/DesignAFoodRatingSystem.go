type Pair struct {
    cuisine string
    rating int
    food string
    index int
}
type PriorityQueue []*Pair

func (pq PriorityQueue) Len() int {return len(pq)}
func (pq PriorityQueue) Less(i, j int) bool {
    if pq[i].rating != pq[j].rating {
        return pq[i].rating >= pq[j].rating
    }
    return pq[i].food <= pq[j].food;
}
func (pq PriorityQueue) Swap(i, j int) {
    pq[i], pq[j] = pq[j], pq[i]
    pq[i].index=i
    pq[j].index=j
}
func (pq *PriorityQueue) Push(x any) {panic("not implemented")}
func (pq *PriorityQueue) Pop() any {panic("not implemented")}
type FoodRatings struct {
    pq map[string]*PriorityQueue
    dic map[string]*Pair
}


func Constructor(foods []string, cuisines []string, ratings []int) FoodRatings {
    fr := FoodRatings{}
    fr.pq   =map[string]*PriorityQueue{}
    fr.dic = map[string]*Pair{}
    for i:=0; i<len(foods); i++ {
        if fr.pq[cuisines[i]] == nil {
            fr.pq[cuisines[i]] = &PriorityQueue{}
        }
        arr := fr.pq[cuisines[i]]
        temp := &Pair{
            cuisines[i], ratings[i], foods[i], len(*arr),
        }
        *arr = append(*arr, temp)
        fr.dic[foods[i]]=temp
    }
        for _,fp := range fr.pq {
            heap.Init(fp)
        }
        return fr
}


func (fr *FoodRatings) ChangeRating(food string, newRating int)  {
    temp := fr.dic[food]
    temp.rating=newRating
    heap.Fix(fr.pq[temp.cuisine], temp.index)
}


func (fr *FoodRatings) HighestRated(cuisine string) string {
    return (*fr.pq[cuisine])[0].food
}


/**
 * Your FoodRatings object will be instantiated and called as such:
 * obj := Constructor(foods, cuisines, ratings);
 * obj.ChangeRating(food,newRating);
 * param_2 := obj.HighestRated(cuisine);
 */