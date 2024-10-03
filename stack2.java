public class stack2{
    private Cell3 top;
    private int quant;

    public stack2() {
        this.top = null;
        this.quant = 0;
    }

    public Cell3 getTop() {
        return top;
    }

    public void setTop(Cell3 top) {
        this.top = top;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant += quant;
    }

    public boolean empty(){
        return top==null;
    }

    public void toStack(Cell3 c){
        c.setNext(top);
        setTop(c);
        setQuant(1);
    }

    public Cell3 unstack(){
        if(empty()){return null;}
        else{
            Cell3 aux = top;
            top = top.getNext();
            aux.setNext(null);
            setQuant(-1);
            return aux;
        }
    }

    public void clear(){
        setTop(null);
    }

    public void display(){
        if(empty()){return;}
        else{
            Cell3 aux = top;
            while(aux!=null){
                System.out.println(aux.getNode());
                aux = aux.getNext();
            }
        }
    }
}