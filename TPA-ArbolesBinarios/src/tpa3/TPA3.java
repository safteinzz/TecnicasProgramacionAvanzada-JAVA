/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpa3;

/**
 *
 * @author SaFteiNZz
 */
public class TPA3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //CREACION ARBOL INTEGERS (NO LLENO)
        ArbolBin <Integer> g = new ArbolBin(null,8,null);
        ArbolBin <Integer> f = new ArbolBin(null,2,null);
        ArbolBin <Integer> e = new ArbolBin(null,8,null);
        ArbolBin <Integer> d = new ArbolBin(g,2,null);
        ArbolBin <Integer> c = new ArbolBin(f,2,null);
        ArbolBin <Integer> b = new ArbolBin(d,8,e);
        ArbolBin <Integer> a = new ArbolBin(b,8,c);
        
        //CREACION ARBOL INTEGERS (LLENO)
        ArbolBin <Integer> ag = new ArbolBin(null,10,null);
        ArbolBin <Integer> af = new ArbolBin(null,2,null);
        ArbolBin <Integer> ae = new ArbolBin(null,9,null);
        ArbolBin <Integer> ad = new ArbolBin(null,1,null);
        ArbolBin <Integer> ac = new ArbolBin(af,9,null);
        ArbolBin <Integer> ab = new ArbolBin(ad,7,ae);
        ArbolBin <Integer> aa = new ArbolBin(ab,8,ac);
        
        //CREACION ARBOL INTEGERS (LLENO)
        ArbolBin <Integer> aii = new ArbolBin(null,10,null);
        ArbolBin <Integer> ahh = new ArbolBin(null,2,null);
        ArbolBin <Integer> agg = new ArbolBin(null,10,null);
        ArbolBin <Integer> aff = new ArbolBin(null,2,null);
        ArbolBin <Integer> aee = new ArbolBin(null,9,null);
        ArbolBin <Integer> add = new ArbolBin(ahh,1,aii);
        ArbolBin <Integer> acc = new ArbolBin(aff,9,agg);
        ArbolBin <Integer> abb = new ArbolBin(ad,7,ae);
        ArbolBin <Integer> aaa = new ArbolBin(abb,8,acc);
        
        System.out.println("El arbol \"a\" tiene un total de " + contarNodos(a) + " nodos");
        System.out.println("El arbol \"b\" tiene un total de " + contarNodos(aa) + " nodos");
        
        if (todosPares(a))
            System.out.println("Todos son pares");
        else
            System.out.println("Alguno es impar");
        
        if (esLleno(aaa))
            System.out.println("El arbol del prof esta lleno");
        else 
            System.out.println("El arbol del prof no esta lleno");
        
        if (esLleno(aa))
            System.out.println("El arbol LLENO esta lleno");
        else 
            System.out.println("El arbol LLENO no esta lleno");
        
        if (esLleno(a))
            System.out.println("El arbol NO LLENO esta lleno");
        else 
            System.out.println("El arbol NO LLENO no esta lleno");        
        
        if (esArbolBin(aa))
            System.out.println("Es arbolbin BST");
        else 
            System.out.println("No es arbolbin BST");
    }
    
    /**
     * Funcion para comprobar si es impar
     * @param num
     * @return true si es impar
     */
    public static boolean esImpar(Integer num)
    {
        if(num % 2 != 0)
            return true;
        else
            return false;
    }
    
    /**
     * Contar nodos
     * @param arbol
     * @return 
     */
    private static int contarNodos(ArbolBin<Integer> arbol)
    {
        if(arbol.esVacio()) return 0;
	else
	{            
            int sumaIzq = contarNodos(arbol.hijoIzq());
            int sumaDcho = contarNodos(arbol.hijoDcho());
            //suma 1 por cada recurvidad (osea cada nodo) y se lo sumas a lo que ya tenias
            return 1 + sumaIzq + sumaDcho; 
	}
    }
    
    /**
     * Comprobar si todos pares
     * @param arbol
     * @return 
     */
    private static boolean todosPares (ArbolBin<Integer> arbol)
    {
        if (!arbol.esVacio())
        {            
            if (!esImpar(arbol.raiz()))
            {
                boolean v = true;
                //Si ningun caso de recurrencia es impar todo sigue true por lo que todos son pares
                if (!todosPares(arbol.hijoIzq()) || !todosPares(arbol.hijoDcho())) v = false;
                return v;
            }
            else return false;
        }
        else return true;
    }
    
    /**
     * Arbol esta lleno
     * @param arbol
     * @return 
     */
    public static < T > boolean esLleno (ArbolBin<T> arbol)
    {
        if (!arbol.esVacio())
        {
            //Si es hijo unico (hoja) retornas true
            if(arbol.hijoIzq().esVacio() && arbol.hijoDcho().esVacio()) return true;
            //Si tiene ambos hijos retornas true si se repite recursivamente
            if ((!arbol.hijoIzq().esVacio() && !arbol.hijoDcho().esVacio())) return esLleno(arbol.hijoIzq()) && esLleno(arbol.hijoDcho());
        }
        return false;
    }
    
    /**
     * Arbol es de busqueda BST
     * @param arbol
     * @return 
     */
    public static boolean esArbolBin (ArbolBin<Integer> arbol)
    {
        if (!arbol.esVacio())
        {
            boolean v = true;
            //Si tiene hijo izquierdo y el izquierdo es menor que raiz sigue true 
            if (!arbol.hijoIzq().esVacio()) if(!(arbol.hijoIzq().raiz() < arbol.raiz())) v = false;
            //Si tiene hijo derecho y es mayor que la raiz sigue true
            if (!arbol.hijoDcho().esVacio() && v) if(!(arbol.hijoDcho().raiz() > arbol.raiz())) v = false;
            //Si ambas condiciones anteriores se repiten en todos los hijos de manera recursiva sigue true
            if (v) if (!esArbolBin(arbol.hijoIzq()) || !esArbolBin(arbol.hijoDcho())) v = false;
            return v;
        }
        return true;
    }

}
