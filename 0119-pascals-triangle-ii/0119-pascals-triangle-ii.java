class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        List<Integer> ans=new ArrayList<>();
        for(int i=1;i<=rowIndex+1;i++)
        {
            long count=1;
            for(int k=1;k<=i;k++)
            {
                if(i==rowIndex+1)ans.add((int)count);
                count=count*(i-k)/k;
            }
        }
        return ans;
    }
}