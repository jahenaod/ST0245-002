
/**
 * Write a description of class linkedList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class linkedList
{
    private Node first;
    private int size;
    public linkedList()
    {
        size = 0;
        first = null;
    }

    /**
     * Returns the node at the specified position in this list.
     * @param index - index of the node to return
     * @return the node at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    private Node getNode(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size) {
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    public int get(int index) throws IndexOutOfBoundsException {
        Node temp = getNode(index);
        return temp.data;
    }

    // Retorna el tamaño actual de la lista
    public int size()
    {
	    return size;
    }

    // Inserta un dato en la posición index
    public void insert(int data, int index)
    {
        Node puntero = first;
        Node nuevo = new Node(data);
        if (index == 0){
            first = nuevo;
            first.next = puntero;
        }else if(index>=0 && index<=size){
            for(int i = 0; i <index;i++){
                puntero = puntero.next;
            }
            nuevo.next = puntero.next;
            puntero.next = nuevo;
        }
        size++;
    }

    // Borra el dato en la posición index
    public void remove(int index)
    {
        if(index == 0){
            first = null;
            first.next = first;
        } else if (index>=0 && index<=size){
            Node temp = first;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            Node temp2 = temp.next;
            temp.next = temp2.next;
            temp2.next = null;
        }
        size--;
    }

    // Verifica si está un dato en la lista
    public boolean contains(int data)
    {
        Node temp = first;
        while(temp != null) {
            if (temp.data == data){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }


}
