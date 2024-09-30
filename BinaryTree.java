public class BinaryTree {
    private Node root;

    public BinaryTree(){this.root = null;}

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public boolean empty(){return root==null;}

    private Node InsertNew(Node n, Node current){
        if(current == null){return n;}
        if(current.getValue() > n.getValue()){
            current.setLeft(InsertNew(n, current.getRight()));
        }else{
            current.setRight(InsertNew(n, current.getRight()));
        }
        return current;
    }

    void Insert(Node n){
        root = InsertNew(n, root);
    }

    void preOrder(Node n){
        if(n!=null){
            System.out.println(n.getValue()+"\n");
            preOrder(n.getLeft());
            preOrder(n.getRight());
        }
    }

    void inOrder(Node n){
        if(n!=null){
            inOrder(n.getLeft());
            System.out.println(n.getValue()+"\n");
            inOrder(n.getRight());
        }
    }

    void postOrder(Node n){
        if(n!=null){
            postOrder(n.getLeft());
            postOrder(n.getRight());
            System.out.println(n.getValue()+"\n");
        }
    }

    private Node find(Node current, int v){
        if(current==null){return null;}
        if(current.getRight()!=null){
            if((current.getRight().getValue()) == v){
                return current;
            }
        }
        if(current.getLeft()!=null){
            if((current.getLeft().getValue()) == v){
                return current;
            }
        }
        if(current.getValue()>v){
            return find(current.getRight(), v);
        }else{
            return find(current.getLeft(), v);
        }
    }

    private int count(Node n){
        if(n == null){return 0;}
        else{
            return 1 + count(n.getLeft()) + count(n.getRight());
        }
    }

    void countNodes(){
        System.out.println(count(root));
    }

    public void printPreOrder(){
        preOrder(root);
    }

    public void printInOrder(){
        inOrder(root);
    }

    public void printPostOrder(){
        postOrder(root);
    }

    private int countNonLeafs(Node n){
        if(n == null || n.getLeft()==null || n.getRight()==null){
            return 0;
        }
        else{
            return 1 + countNonLeafs(n.getLeft()) + countNonLeafs(n.getRight());
        }
    }

    public int countNonLeafNodes(){
        return countNonLeafs(root);
    }

}
