import java.util.Stack;

public class String_MinimumDeletionsToMakeStringBalanced {
  
  // t(n) = O(n) s(n) = O(1)
  class Solution1PassUsingDPOptimizedSpace {
    public int minimumDeletions(String s) {
        int n = s.length();
        
        int deletions = 0;
        int b_count = 0;

        for(int i = 0; i < n; i++){
            if(s.charAt(i) == 'b'){
                b_count++;
            }else{
                deletions = Math.min(deletions + 1, b_count);
            }
        }

        return deletions;
    }
}

  // t(n) = O(n) s(n) = O(n)
  class Solution1PassUsingDP {
    public int minimumDeletions(String s) {
        int n = s.length();

        int dp[] = new int[n + 1];
        int b_count = 0;

        for(int i = 0; i < n; i++){
            if(s.charAt(i) == 'b'){
                b_count++;
                dp[i + 1] = dp[i];
            }else{
                dp[i + 1] = Math.min(dp[i] + 1, b_count);
            }
        }

        return dp[n];
    }
}

  // t(n) = O(n) s(n) = O(n)
  class Solution1PassUsingStack {
    public int minimumDeletions(String s) {
        int n = s.length();

        Stack<Character> stk = new Stack<>();
        int deletions = 0;

        for(int i = 0; i < n; i++){
            if(!stk.isEmpty() && stk.peek() == 'b' && s.charAt(i) == 'a'){
                stk.pop();
                deletions++;
            }else{
                stk.push(s.charAt(i));
            }
        }

        return deletions;
    }
}

  // t(n) = O(2n) s(n) = O(1)
  class SolutionT2Pass {
    public int minimumDeletions(String s) {
        int n = s.length();

        int a_count = 0;

        for(int i = 0; i < n; i++){
            if(s.charAt(i) == 'a') a_count++;
        }

        int b_count = 0;
        int deletions = n;

        for(int i = 0; i < n; i++){
            if(s.charAt(i) == 'a') a_count--;
            deletions = Math.min(deletions, a_count + b_count);
            if(s.charAt(i) == 'b') b_count++;
        }

        return deletions;
    }
}

// t(n) = O(3n) s(n) = O(2n)
  class Solution3Pass {
    public int minimumDeletions(String s) {
        int n = s.length();

        int counta[] = new int[n];
        int countb[] = new int[n];

        int b_count = 0;

        for(int i = 0; i < n; i++){
            countb[i] = b_count;
            if(s.charAt(i) == 'b') b_count++;
        }

        int a_count = 0;
        for(int i = n - 1; i >= 0; i--){
            counta[i] = a_count;
            if(s.charAt(i) == 'a') a_count++;
        }

        int deletions = n;

        for(int i = 0; i < n; i++){
            deletions = Math.min(deletions, counta[i] + countb[i]);
        }

        return deletions;
    }
}
}
