class Solution {
    public int largestRectangleArea(int[] heights) 
    {
        int n = heights.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++)
        {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i])
            {
                st.pop();
            }

            if(st.isEmpty())
            {
                pre[i] = -1;
            }
            else
            {
                pre[i] = st.peek();
            }

            st.push(i);
        }

        st.clear();

        for(int i = n - 1; i >= 0; i--)
        {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i])
            {
                st.pop();
            }

            if(st.isEmpty())
            {
                suf[i] = n;
            }
            else
            {
                suf[i] = st.peek();
            }

            st.push(i);
        }

        int max = 0;

        for(int i = 0; i < n; i++)
        {
            max = Math.max(max, heights[i] * (suf[i] - pre[i] - 1));
        }

        return max;
    }
}