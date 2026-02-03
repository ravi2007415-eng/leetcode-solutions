class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        boolean[] vis = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(strs, vis, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(String[] strs, boolean[] vis, int i) {
        vis[i] = true;
        for (int j = 0; j < strs.length; j++) {
            if (!vis[j] && similar(strs[i], strs[j])) {
                dfs(strs, vis, j);
            }
        }
    }

    private boolean similar(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff > 2) return false;
            }
        }
        return diff == 0 || diff == 2;
    }
}
