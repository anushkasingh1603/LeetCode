class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int light=Integer.MIN_VALUE;
        for(int i : lights){
            light=Math.max(i,light);
        }
        int ans=0;
        for(int i:arrivalTime){
            int r=i%period;
            if(r>=light){
                ans=Math.max(ans,period-r);
            }
        }
        return ans;
    }
}