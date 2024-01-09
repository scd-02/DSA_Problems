class LL_Node {
  int data;
  LL_Node left, right;

  LL_Node(int d) {
    data = d;
    left = right = null;
  }
}

public class CDLL_BinaryTreeToCDLL {

  LL_Node head = null, tail = null;
    LL_Node bTreeToClist(LL_Node root)
    {
        inorder(root);
        
        head.left = tail;
        tail.right = head;
        
        return head;
    }
    
    void inorder(LL_Node root){
        
        if(root == null)
            return ;
            
        inorder(root.left);
        
        LL_Node newLL_Node = new LL_Node(root.data);
        
        if(head == null && tail == null){
            head = tail = newLL_Node;
        }else{
            tail.right = newLL_Node;
            newLL_Node.left = tail;
        }
        
        tail = newLL_Node;

        inorder(root.right);
        
    }
}
