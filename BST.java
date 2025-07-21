public class BST{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    public static Node insert(Node root, int val){
        
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data > val){
            root.left = insert(root.left, val);
        }
 
        else{
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static boolean search(Node root, int val){
        if(root == null){
            return false;
        }

        if(root.data == val){
            return true;
        }
        else if(root.data > val){
            return search(root.left, val);
        }

        else{
            return search(root.right, val);
        }
    }
    public static void main(String[] args) {
        int[] val = {5,3,7,9,1,2,4,8};
        Node root = null;

        for(int i = 0; i < val.length; i++){
            root = insert(root, val[i]);
        }
        
        inorder(root);
        System.out.println();

        if(search(root, 1)){
            System.out.println("Found!");
        }

        else{
            System.out.println("Not found.");
        }
    }
}