class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> list = new ArrayList<int[]> ();
        
        list.add(newInterval);
        for(int i=0; i<intervals.length; i++) {
            list.add(intervals[i]);
        }
        
        Collections.sort(list, (arr1,arr2) -> (arr1[0]-arr2[0]));
        
        int[][] arr = list.toArray(new int[list.size()][2]);
        list.clear();
        
        for(int i=1; i<arr.length; i++) {
            
            int[] prev = arr[i-1];
            int[] curr = arr[i];
            
            if (prev[1] >= curr[0]) {
                //Merge these two intervals
                prev[1] = Math.max(prev[1], curr[1]);
                curr[0] = prev[0];
                curr[1] = prev[1];
            } 
            
            // else {
            //     continue;
            // }
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<arr.length; i++) {
            if (!map.containsKey(arr[i][0])) {
                map.put(arr[i][0], Integer.MIN_VALUE);
            }
            map.put(arr[i][0], Math.max(map.get(arr[i][0]), arr[i][1]));
        }
        
        
        int[][] result = new int[map.size()][2];
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result[count++] = new int[] {entry.getKey(), entry.getValue()};
        }
        
        Arrays.sort(result, (arr1,arr2) -> (arr1[0]-arr2[0]));
        
        return result;
    }
}