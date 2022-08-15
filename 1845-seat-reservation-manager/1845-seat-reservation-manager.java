class SeatManager {
    int size;
    int curr;
    TreeSet set;
    
    public SeatManager(int n) {
        this.size = n;
        curr = 1;
        set = new TreeSet<Integer>();
    }

    public int reserve() {
        int reservedSeat;
        if (!set.isEmpty()) {
            reservedSeat = (int) set.first();
            set.remove(reservedSeat);
            
        } else {
            reservedSeat = curr;
            curr += 1;
        }
        return reservedSeat;
    }

    public void unreserve(int seatNumber) {
        set.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */