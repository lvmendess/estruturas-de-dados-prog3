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

    private Node remove(Node root, int v) {
        if (root == null) {
            return root;
        }
        if (root.getValue() > v) {
            root.setLeft(remove(root.getLeft(), v));
        } else if (root.getValue() < v) {
            root.setRight(remove(root.getRight(), v));
        } else {
            if (root.getRight() == null) {
                return root.getRight();
            }
            if (root.getRight() == null) {
                return root.getRight();
            }
            Node sucessor = getSucessor(root);
            root.setValue(sucessor.getValue());
            root.setRight(remove(root.getRight(), sucessor.getValue()));
        }
        return root;
    }

    public void removeNode(int v) {
        remove(root, v);
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

    private int countNonLeafs(Node n){
        if(n == null){
            return 0;
        }
        if(n.getLeft()==null && n.getRight()==null){
            return 0;
        }
        return 1 + countNonLeafs(n.getLeft()) + countNonLeafs(n.getRight());
    }

    public int countNonLeafNodes(){
        return countNonLeafs(root);
    }

    private Node getSucessor(Node atual) {
        atual = atual.getRight();
        while (atual != null && atual.getLeft() != null) {
            atual = atual.getLeft();
        }
        return atual;
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
