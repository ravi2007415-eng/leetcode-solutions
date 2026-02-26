class Solution {
    public int createSortedArray(int[] instructions) {
        int MOD = 1000000007;
        HashMap<Integer, Integer> frq = new HashMap<>();

        ArrayList<Integer> list = new ArrayList<>();
        long ans = 0;
        for(int ele: instructions){
            int ind = binaryS(list, 0, list.size()-1, ele);
            int right = list.size()-ind;

            ans = (ans + Math.min(ind-frq.getOrDefault(ele, 0), right)) % MOD;
            list.add(ind, ele);
            frq.put(ele, frq.getOrDefault(ele, 0) + 1);
        }

        return (int) ans;
    }

    public int binaryS(ArrayList<Integer> arr, int st, int ed, int tar){
        while(st<=ed){
            int mid = (st+ed)/2;
            if(arr.get(mid) <= tar){
                st = mid+1;
            }
            else ed = mid-1;
        }

        return st;
    }
}