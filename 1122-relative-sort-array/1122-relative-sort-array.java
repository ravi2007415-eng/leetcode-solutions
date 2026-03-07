class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
     int res[]=new int[arr1.length];
     int index=0;
    List<Integer>list=new ArrayList<>();
     for(int i=0;i<arr2.length;i++){
        for(int j=0;j<arr1.length;j++){
            if(arr2[i]==arr1[j]){
                list.add(arr1[j]);
            }
        }
     }
     List<Integer>ans=new ArrayList<>();
     for(int i:arr1){
        if(!list.contains(i)){
            ans.add(i);
        }
     }
     Collections.sort(ans);
     for(int k:ans){
        list.add(k);
     }
     for(int k:list){
        res[index++]=k;
     }
     return res;
    }
}