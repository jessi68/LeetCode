class Solution {
    public int findKthLargest(int[] nums, int k) {
         if(nums==null || nums.length==0){
             return 0;
         }
        sort(nums,k);
        minHeapSolution(nums,k);
        return quickSelect(nums,k);
    }

    private int sort(int[] nums,int k){
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
 
    private int minHeapSolution(int[] nums,int k){
        PriorityQueue<Integer> pq = new PriorityQueue();
        int n = nums.length;
        for(int i=0; i< n;i++){
            pq.add(nums[i]);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
    
  
    private int quickSelect(int[] nums,int k){

        int n = nums.length;
       
        k = n-k;
        int left=0,high=n-1;
        int pivot;
        while(left<high){
           
            pivot = partition(nums,left,high);
            
            if(pivot<k) {
                left = pivot+1;
            }
           
            else if(pivot>k) {
                high = pivot-1;
            }
         
            else return nums[pivot];
        }
        return nums[left];
    }
    private int partition(int[] nums,int low,int high) {
        
        int pivot = high;
        for(int i=low;i<high;i++){
            if(nums[i]<=nums[pivot]){
                swap(nums,low,i);
                low++;
            }
        }
        swap(nums,low,high);
        return low;
    }

    private void swap(int[] a,int i,int j){
        int temp = a[j];
        a[j]=a[i];
        a[i]=temp;
    }
}