
class DFS{
    public static boolean hayCaminoDFS(Graph g, int origen, int destino){
        boolean[] visitados = new boolean[g.size];
        return hayCaminoAuxDFS(g, origen, destino, visitados);
    }

    private static boolean hayCaminoAuxDFS(Graph g, int origen, int destino, boolean[] v){
        v[origen] = true;
        if(origen == destino){
            return true;
        }
        for(Integer s : g.getSuccessors(origen)){
            if(!v[s]){  
              if(hayCaminoAuxDFS(g, s, destino, v)){
                  return true;
              }
            }
        }
        return false;
    }
}