class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int[][] ans = new int[n][2];

        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        int i = 0, ii = 0;

        while(i < n) {
            int s = intervals[i][0];
            int e = intervals[i][1];
            int j = i + 1;

            while(j < n && intervals[j][0] <= e) {
                e = Math.max(e, intervals[j][1]);
                j++;
            }

            ans[ii][0] = s;
            ans[ii][1] = e;
            ii++;
            i = j;
        }

        return Arrays.copyOf(ans, ii);
    }
}