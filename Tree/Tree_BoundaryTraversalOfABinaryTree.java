import java.util.ArrayList;

public class Tree_BoundaryTraversalOfABinaryTree {
  ArrayList <Integer> boundary(Node root)
	{
	    ArrayList<Integer> ans = new ArrayList<>();
	    ans.add(root.data);
	    
	    leftSide(root.left, ans);
	    
	    if(root.left != null) leafNodes(root.left, ans);
	    if(root.right != null) leafNodes(root.right, ans);
	    
	    rightSide(root.right, ans);
	    
	    return ans;
	}
	
	static boolean leafNode(Node root){
	    return root.left == null && root.right == null;
	}
	
	static void leftSide(Node root, ArrayList<Integer> ans){
	    
	    if(root == null) return;
	    
	    if(!leafNode(root)){
	        ans.add(root.data);
	    }
	    
	    if(root.left != null){
	        leftSide(root.left, ans);
	    }else{
	        leftSide(root.right, ans);
	    }
	    
	}
	
	static void leafNodes(Node root, ArrayList<Integer> ans){
	    
	    if(leafNode(root)){
	        ans.add(root.data);
	        return;
	    }
	    
	    if(root.left != null) leafNodes(root.left, ans);
	    if(root.right != null) leafNodes(root.right, ans);
	    
	}
	
	static void rightSide(Node root, ArrayList<Integer> ans){
	    
	    if(root == null) return;
	    
	    if(root.right != null){
	        rightSide(root.right, ans);
	    }else{
	        rightSide(root.left, ans);
	    }
	    
	    if(!leafNode(root)){
	        ans.add(root.data);
	    }
	    
	}
}
