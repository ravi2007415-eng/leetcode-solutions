class Solution {
   public String Helper(String s,int idx,int num)
{
    StringBuilder sb=new StringBuilder();
   
    for(int i=idx;i<s.length();i++){
    
        char ch=s.charAt(i);
        
        if(ch>='1' && ch<='9'){
            
            int nexpand=0;
            
            while(s.charAt(i)>='0' && s.charAt(i)<='9'){
                nexpand=nexpand*10+s.charAt(i)-'0';
                i+=1;
            }
            
            i+=1;
            int l=i;
            int cnt=1;
            while(cnt!=0){
                if(s.charAt(i)==']'){
                    cnt-=1;
                }
                else if(s.charAt(i)=='['){
                    cnt+=1;
                }
                if(cnt==0){break;}
                i++;
            }
            String expand=s.substring(l,i);
            // System.out.print(expand);
            String res=Helper(expand,0,nexpand);
           sb.append(res.toString());
        }
        else{
            sb.append(ch);
        }
    }
    
        String add=sb.toString();
        
    for(int i=1;i<num;i++){
            sb.append(add);
        }
    
    return sb.toString();

}

public String decodeString(String s) {
        
   return Helper(s,0,1);

}}