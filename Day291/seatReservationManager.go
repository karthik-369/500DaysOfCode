import (
    "container/heap"
)
type IntHeap []int 
func (h IntHeap) Len() int {return len(h)}
func (h IntHeap) Less(i, j int) bool {return h[i] < h[j]}
func (h IntHeap) Swap(i, j int) {h[i], h[j] = h[j], h[i]}

func (h *IntHeap) Push(x interface{}) {
    *h = append(*h, x.(int))
}
func (h *IntHeap) Pop() interface{} {
    old := *h
    n := len(old)
    x := old[n-1]
    *h = old[0:n-1]
    return x
}
type SeatManager struct {
    last int
    priorityQueue IntHeap 
}


func Constructor(n int) SeatManager {
    return SeatManager {
        last : 0,
        priorityQueue : make(IntHeap, 0),
    }
}


func (this *SeatManager) Reserve() int {
   if len(this.priorityQueue) == 0 {
       this.last++
       return this.last
   }
   return heap.Pop(&this.priorityQueue).(int)
}


func (this *SeatManager) Unreserve(seatNumber int)  {
    if seatNumber == this.last {
        this.last--
    } else {
        heap.Push(&this.priorityQueue, seatNumber)
    }
}


/**
 * Your SeatManager object will be instantiated and called as such:
 * obj := Constructor(n);
 * param_1 := obj.Reserve();
 * obj.Unreserve(seatNumber);
 */