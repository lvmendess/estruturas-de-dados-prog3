public class stack{
    private Cell top;
    private int quant;

    public stack() {
        this.top = null;
        this.quant = 0;
    }

    public Cell getTop() {
        return top;
    }

    public void setTop(Cell top) {
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

    public void toStack(Cell c){
        c.setNext(top);
        setTop(c);
        setQuant(1);
    }

    public Cell unstack(){
        if(empty()){return null;}
        else{
            Cell aux = top;
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
            Cell aux = top;
            while(aux!=null){
                System.out.println(aux.getValue());
                aux = aux.getNext();
            }
        }
    }

}