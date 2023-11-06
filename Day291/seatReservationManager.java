class SeatManager {
    public int l;
     public PriorityQueue<Integer> priorityQueue; 
    public SeatManager(int n) {
      this.l =0;
      this.priorityQueue = new PriorityQueue<>();
    }
    
    public int reserve() {
        if (priorityQueue.isEmpty()) {
            return ++l;
        } 
        return priorityQueue.poll();
    }
    
    public void unreserve(int seatNumber) {
        if (seatNumber == l) {
            l--;
        }
        else {
            priorityQueue.offer(seatNumber);
        }
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */