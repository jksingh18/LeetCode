class Solution {
    // int dp[][]=new int[1000+1][1000+1] ;
    public int longestCommonSubsequence(String s1, String s2) {
        int[] next = new int[s2.length()+1], curr = new int[s2.length()+1];
    
    for( int i = s1.length()-1; i >= 0 ; i-- ){
        for( int j = s2.length()-1; j >=0; j-- ){
            if( s1.charAt(i) == s2.charAt(j) ){
                curr[j] = 1+next[j+1];
            }else{
                curr[j] = Math.max(curr[j+1], next[j]);
            }                
        }
        next = curr.clone();
    }
    
    return next[0];
        
//         int l1=a.length(),l2=b.length();
        
//         for(int i=0;i<=l1;i++)
//         dp[i][0]=0;
        
//         for(int i=0;i<=l2;i++)
//         dp[0][i]=0;
        
//         for(int i=1;i<=l1;i++)
//         {
//             for(int j=1;j<=l2;j++)
//             {
//                 if(a.charAt(i-1)==b.charAt(j-1))
//                 dp[i][j]=1+dp[i-1][j-1];
                
//                 else dp[i][j]=Math.max(dp[i-1][j] , dp[i][j-1]);
//             }
//         }
//         return dp[l1][l2];
        
        
    }
}