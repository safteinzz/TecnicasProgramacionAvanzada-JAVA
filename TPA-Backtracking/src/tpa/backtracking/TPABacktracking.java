/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpa.backtracking;

/**
 *
 * @author SaFteiNZz
 */
public class TPABacktracking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //hacer la matriz de adyacencia        
        int[][] matrizGrafo = new int[6][6];        
        for (int i = 0; i < matrizGrafo.length; i++) {
            for (int j = 0; j < matrizGrafo.length; j++) {
                matrizGrafo[i][j] = 0;                
            }            
        }
        
        matrizGrafo[0][1] = 1;
        matrizGrafo[1][3] = 1;
        matrizGrafo[1][4] = 1;
        matrizGrafo[1][5] = 1;
        matrizGrafo[3][0] = 1;
        matrizGrafo[3][4] = 1;
        matrizGrafo[4][3] = 1;
        matrizGrafo[5][2] = 1;
        
        int[][] arr = new int[8][8];


        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[0].length; j++)
            {
                arr[i][j] = 0;
            }
        }
        
        int columnas = 2;
        if (backtracking_torres(arr, 0, columnas))
        {
            System.out.println("Se puede");
        }
        else
        {
            System.out.println("No se puede");
        }
    }
    
    /**
     * Funcion para comprobar si la posicion es aceptable
     * No es aceptable si ya hay uno en fila o columna
     * @param arr
     * @param i
     * @param etapa
     * @return 
     */
    public static boolean aceptable(int arr[][], int i, int etapa)
    {
        //filas
        for (int j = 0; j <= i; j++)
        {
            if(arr[j][etapa] == 1)
                return false;
        }
        //columnas
        for (int j = 0; j <= etapa; j++)
        {
            if(arr[i][j] == 1)
                return false;
        }
        return true;
    }
    
    /**
     * Funcion imprimir el tablero de torres
     * @param arr 
     */
    public static void imprimir (int arr[][])
    {
        System.out.println();
        for (int i = 0; i < arr.length; i++)
        {
                for (int j = 0; j < arr[0].length; j++)
                {
                        System.out.print(arr[i][j] + " ");
                }
                System.out.println();
        }
        System.out.println();
    }
    
    /**
     * Ejercicio 3. Se dispone de un tablero de ajedrez donde cada celda está etiquetada con un número
        natural generado de manera aleatoria. Se pretende colocar k torres en el tablero de forma que no se
        amenacen entre ellas. Explicar el enfoque y diseñar el pseudocódigo de un algoritmo de vuelta atrás que
        determine cómo se deben colocar las k torres, o devuelva un error si no es posible
     * @param arr
     * @param etapa
     * @param torresRestantes
     * @return 
     */
    public static boolean backtracking_torres(int arr[][], int etapa, int torresRestantes)
    {
        if (torresRestantes == 0) //por si el usuario mete un 0
        {
            imprimir(arr);
            return true;
        }
        
        for (int i = 0; i< arr.length; i++) //iterar fila
        {
            if (aceptable(arr,i, etapa)) //comprobar si algo amenazaria a una torre en esta posicion
            {
                arr[i][etapa] = 1; //si no la amenaza la ponemos
                torresRestantes--; //y quitamos una torre
                if(etapa == arr.length - 1 || torresRestantes == 0) //si estamos en la ultima columna o ya hemos puesto todas las torres
                    //ya no podemos poner ninguna mas
                {
                    if (torresRestantes == 0) //comprobar si hemos gastado todas las torres   
                    {
                        imprimir(arr);
                        return true; //si cabian
                    }
                }
                else //si no estamos en la ultima
                {
                    if (backtracking_torres(arr,etapa + 1, torresRestantes)) //si lo anterior da true todo ok
                        return true;
                }                
            }
        }
        return false;
    }
    

    /**
     * Ejercicio 5. Se quiere utilizar un grafo dirigido etiquetado para representar las calles de una ciudad. Los
        vértices representan intersecciones y cruces, mientras las aristas contienen la distancia entre dichos
        cruces. Implementar en Java un método que, a partir de dicho grafo, un vértice origen O y un vértice
        destino D, determine el camino más corto utilizando un enfoque de ramificación y poda.
     
     * Voy a suponer que grafo tiene un metodo grafo.coste que devuelve el valor del coste de todas sus aristas
     
     * Planteamiento: puedo hacerlo recursivo devolviendo grafos a modo de rutas,
        los grafos devueltos se compararian en coste y se devolveria el de menos coste,
        de modo que al llegar al nodo padre se compararian los hijos almacenados en lista
        en base a ese valor grafo.coste y así tendriamos la mejor ruta almacenada en un grafo
        * Como los vertices pueden tener varios hijos tengo que hacer listas de hijos
        * Vertice O tiene que ir cambiando al vertice sucesor actual
	
     * @param graf
     * @param O
     * @param D
     * @return 
     */
    public static Grafo shortestPathBranchBound(Grafo graf, Vertice O, Vertice D)
    {        
        if (!graf.esVacio())
        {
            List<Grafo> listaGrafos = new ArrayList<>();
            for (Vertice v : O.getSucesores())
            {
                listaGrafos.add(shortestPathBranchBound(graf, v, D));
            }
            Grafo rutaMasCorta = listaGrafos[0]; //necesito poner una para comparar
            for (Grafo ruta : listaGrafos)
            {
                if(ruta.coste < rutaMasCorta)
                    rutaMasCorta = ruta;
            }
            return rutaMasCorta;
        }
        return null;
    }
    
    
    
    
    
    
    
}
