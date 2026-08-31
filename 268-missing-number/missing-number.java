class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int answer = n;
        for (int i=0; i<nums.length; i++){
            answer = answer^i^nums[i];

        }
        return answer;
    }
}