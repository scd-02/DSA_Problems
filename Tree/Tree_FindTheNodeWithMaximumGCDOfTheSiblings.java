import java.util.LinkedList;
import java.util.Queue;

public class Tree_FindTheNodeWithMaximumGCDOfTheSiblings {
  
    int maxGCD(Node root) {
        
        int maxGCD = 0;
        int ans = 0;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            Node u = q.poll();
            
            boolean left = false, right = false;
            
            if(u.left != null){
                q.add(u.left);
                left = true;
            }
            
            if(u.right != null){
                q.add(u.right);
                right = true;
            }
            
            if(left && right){
                int gcd = gcd(u.left.data, u.right.data);
                if(gcd >= maxGCD){
                    maxGCD = gcd;
                    ans = u.data;
                }
            }
        }
        
        return ans;
        
    }
    
    int gcd(int a, int b){
        
        if(a % b == 0) return b;
        
        if(a < b) return gcd(b, a);
        
        return gcd(b, a % b);
        
    }

}
