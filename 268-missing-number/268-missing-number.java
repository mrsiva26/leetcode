class Solution {
    public int missingNumber(int[] nums) {
        
        int num = 0;
        
        for(int i=1; i<=nums.length; i++) {
            
            num = num ^ (nums[i-1] ^ i);
        }
        
        return num;
    }
}