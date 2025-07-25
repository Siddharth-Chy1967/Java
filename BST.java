public class BST{
    public static class Node{
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
        else if(root.data < val){
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

        if(root.data > val){
            return search(root.left, val);
        }

        else if(root.data == val){
            return true;
        }

        else{
            return search(root.right, val);
        }
    }
    public static void main(String[] args) {
        int[] val = {5,4,7,8,12,3,5,1};
        Node root = null;

        for(int i = 0; i < val.length; ++i){
            root = insert(root, val[i]);
        }

        inorder(root);
        System.out.println();
        if(search(root, 5)){
            System.out.println("Found!");
        }
        else{
            System.out.println("Not Found :( ");
        }
    }

}