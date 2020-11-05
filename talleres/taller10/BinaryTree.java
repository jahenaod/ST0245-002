public class BinaryTree {
    //Sirve como raíz del árbol
    public Node root;
    //Insertar un elemento
    public void insertar(int n) {
        if (root == null) {
            root = new Node(n);
        } else {
            insertarAux(root, n);
        }
    }

    //Meodo auxiliar para eliminar un elemento
    private void insertarAux(Node node, int n) {
        if (node == null) {
            node = new Node(n);
        }
        if (n > node.data) {
            if (node.right == null) {
                node.right = new Node(n);
            }
            insertarAux(node.right, n);
        }
        if (n < node.data) {
            if (node.left == null) {
                node.left = new Node(n);
            }
            insertarAux(node.left, n);
        }
    }
    
    //Crear Arbol
      public void creaArbol(){
        System.out.println("Busque http://www.webgraphviz.com/ y envie los datos recibidos");
        crearArbolAux(root);
    }
    
    private void crearArbolAux(Node nodo){
        if(nodo.left == null){
            return;
        }else{
            System.out.println("\"" + nodo.data + "\""  + "->" + "\"" + nodo.left.data + "\"");
        }

        if(nodo.right == null){
            return;
        }else{
            System.out.println("\"" + nodo.data + "\""  + "->" + "\"" + nodo.right.data + "\"");
        }
        crearArbolAux(nodo.left);
        crearArbolAux(nodo.right);
    }

    //Buscar un elemento en el arbol
    public boolean buscar(int n) {
        return buscarAux(root, n);
    }

    //Metodo auxiliar para la busqueda
    private boolean buscarAux(Node node, int n) {
        if(node == null){
            return false;
        }else if(node.data == n){
            return true;
        }else if(node.data < n){
            return buscarAux(node.left, n);
        }
        return buscarAux(node.right, n);
    }
}
