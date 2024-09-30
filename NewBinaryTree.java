public class NewBinaryTree {
    private Node root;

    public NewBinaryTree() {
        this.root = null;
    }

    private Node insertNew(Node n, Node current){
        if(current==null){return n;}
        else{
            if(current.getValue()>n.getValue()){
                current.setLeft(insertNew(n, current.getLeft()));
            }else{
                current.setRight(insertNew(n, current.getRight()));
            }
            return current;
        }
    }

    void insert(Node n){
        if(!nodeExists(n)){
            root = insertNew(n, root);
        }else{
            System.out.println("node already exists");
        }
    }

    private boolean exists(Node n, Node m){
        if(m==null){return false;}
        else if(m.getValue()==n.getValue()){return true;}
        else{
            if(m.getValue()>n.getValue()){
                return exists(n, m.getLeft());
            }else{
                return exists(n, m.getRight());
            }
        }
    }

    boolean nodeExists(Node n){
        return exists(n, root);
    }

    private Node find(Node current, int v){
        if(current==null){return null;}
        else if(current.getValue()==v){return current;}
        else{
            if(current.getValue()>v){
                return find(current.getLeft(), v);
            }else{
                return find(current.getRight(), v);
            }
        }
    }

    Node findNode(int v){
        return find(root, v);
    }

    boolean remove(int v){
        if(root==null){return false;}
        else{
            Node p, n;
            if(root.getValue()==v){
                p = root;
                n = root;
            }
        }
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

    public void printPreOrder(){
        preOrder(root);
    }

    public void printInOrder(){
        inOrder(root);
    }

    public void printPostOrder(){
        postOrder(root);
    }

    
}
