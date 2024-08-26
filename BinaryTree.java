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

    /*private boolean remove(int v){
        if(empty()){return false;}
        else{
            Node father;
            Node son;
            if(getRoot().getValue() != v){
                father = 
            }
        }
    }*/

    void InOrder(Node n){}
}
