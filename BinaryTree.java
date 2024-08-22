public class BinaryTree {
    private Node root;

    public BinaryTree(){this.root = null;}

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

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

    void InOrder(Node n){}
}
