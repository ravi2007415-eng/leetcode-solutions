class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length > 1) Arrays.sort(intervals, 
            (a, b) -> (a[0] - b[0])
        );

        List<int[]> result = new ArrayList<>();
        boolean inserted = false;

        for(int[] curr: intervals) {
            // case 1: curr is before newInterval, no overlap
            if (curr[1] < newInterval[0]) {
                result.add(curr);
            }

            // case 3: curr is after newInterval, no overlap
            else if (curr[0] > newInterval[1]) {
                if (!inserted) {
                    result.add(newInterval);
                    inserted = true;
                }
                result.add(curr);
            }

            // case 2: newInterval and curr has overlap / can be merged
            else {
                newInterval[0] = Math.min(newInterval[0], curr[0]);
                newInterval[1] = Math.max(newInterval[1], curr[1]);
            }    
        }

        if (!inserted) result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }
}