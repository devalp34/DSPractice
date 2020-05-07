class Solution {
    public int largestPerimeter(int[] A) {
        int ans = 0;
        Arrays.sort(A);
        for(int i = A.length - 3 ; i >= 0 ; i--)
        {
            for(int j = i+1 ; j < A.length; j++)
            {
                for(int k = j+1 ; k < A.length ; k++)
                {
                    if(A[k] >= A[i]+A[j]) continue;
                    if(A[j] >= A[i]+A[k]) continue;
                    if(A[i] >= A[j]+A[k]) continue;
                    return A[k]+A[i]+A[j];
                }
            }
        }
        return 0;
    }
}
