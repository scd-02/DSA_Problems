public class rough {
  
  public static void check(int s, int n){
    if(n == 0)return;
    s = s+1;
    System.out.print(s+" ");
    check(s, n-1);
    System.out.print(s+" ");
    
  }
  public static void main(String[] args) {
    int sum = 0;
    check(sum, 3);
    System.out.println(sum);
  }
}
