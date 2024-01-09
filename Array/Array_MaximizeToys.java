import java.util.Arrays;

class Array_MaximizeToys{
  static int toyCount(int N, int K, int arr[])
    {
        // code here
        
        Arrays.sort(arr);
        
        int count=0;
        
        int i=0;
        while(i<N && K>=arr[i] ){
            K -= arr[i];
            count++;
            i++;
        }
        
        return count;
    }
}