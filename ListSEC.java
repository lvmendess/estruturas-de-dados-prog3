public class ListSEC{
    private Cell head;

    public ListSEC() {
        Cell head = new Cell(-1);
        head.setNext(head);
        this.head = head;
    }

    public void print(){
        if(empty()){System.out.println("empty list");}
        else{
            Cell aux = head.getNext();
            while(aux!=head){
                System.out.println(aux.getValue());
                aux = aux.getNext();
            }
        }
    }

    public void insertAtStart(Cell c){
        c.setNext(head.getNext());
        head.setNext(c);
    }
    

    public void insertAtEnd(Cell c) {
        if(empty()){
            head.setNext(c);
            c.setNext(head);
        }else{
            Cell aux = head.getNext();
            while(aux.getNext()!=head){
                aux = aux.getNext();
            }
            aux.setNext(c);
            c.setNext(head);
        }
    }

    public boolean removeAtEnd(){
        if(empty()){return false;}
        else{
            Cell aux = head.getNext();
            if(aux.getNext()!=head){
                while(aux.getNext().getNext()!=head){
                    aux = aux.getNext();
                }
                Cell aux2 = aux.getNext();
                aux.setNext(head);
                aux2.setNext();
            } 
            return true;
            }     
    }

    public boolean removeAtStart() {
        if(empty()){return false;}
        else{
            Cell aux = head.getNext();
            head.setNext(aux.getNext());
            aux.setNext(); //points to null
            return true;
        }
    }
     
    public boolean empty(){
        return (head.getNext()==head);
    }

    public Cell search(int v){
        if(empty()){return null;}
        else{
            Cell aux = head.getNext();
            while(aux.getNext()!=head && aux.getValue()!=v){
                aux = aux.getNext();
            }
            return aux;
        }
    }

    public int size(){
        if(empty()){return 0;}
        else{
            int size = 0;
            Cell aux = head;
            while(aux.getNext()!=head){
                size++;
                aux = aux.getNext();
            }
            return size;
        }
    }

    public boolean exists(int v) {
        if(empty()){return false;}
        else{
            Cell aux = head;
            while((aux.getNext()!=head && aux.getValue()!=v)){
                aux = aux.getNext();
            }
            if(aux.getValue()==v){
                return true;
            }else{
                return false;
            }
        }
    }

    public void removeSpecific(int v){
        if (empty()) {System.out.println("empty list");}
        else{
            Cell aux = head;
            if(exists(v)){
                while(aux.getNext()!=head && aux.getNext().getValue()!=v){
                    aux = aux.getNext();
                }
                aux.setNext(aux.getNext().getNext());
            }else{
                System.out.println("404: cell not found");
            }
        }
    }

    public void assemble(ListSEC list){
        if(list.empty()){System.out.println("empty list");}
        else{
            Cell aux = list.head.getNext();
            while(aux.getNext()!=head){
                insertAtEnd(aux);
                aux = aux.getNext();
            }
            print();
        }
    }
    
}