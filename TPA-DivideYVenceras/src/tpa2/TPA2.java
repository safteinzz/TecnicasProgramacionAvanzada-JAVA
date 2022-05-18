/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpa2;

import java.util.Random;

/**
 *
 * @author SaFteiNZz
 */
public class TPA2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {        
        int[] a = new int[100];
        for (int i = 0; i < 100; ++i) {
            a[i] = i;
        }
        
        System.out.println(contarImpares (a, 0, 50));
        
        
        int[] b = {2,4,6,8,10,11,13,17};
        int[] c = {2,4,6,8,10,11,13,17};
        
        if (gemelos(b,c,0,7))
        {
            System.out.println("Son gemelos");            
        }
        else
        {
            System.out.println("NO son gemelos");  
        }
        
        int exp = 4;
        int N = (int) Math.pow(2, exp);          
        float[] d = new float[N];        
        
        Random rand = new Random(); 
        
        for (int i = 0; i < N; i++)
        {
            d[i] = rand.nextInt(10);
        }
        
        System.out.println(calcularMedia(d, 0, N - 1));
//        float[] e = {2,4,8,7};        
//        System.out.println(calcularMedia(e, 0, 3));


        int C = 8;
        System.out.println(multNxC(5, C));
        
        int e[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(busTer(e, 11, 0, 9));
    }
    
    /**
     * Funcion para comprobar si es impar
     * @param num
     * @return true si es impar
     */
    public static boolean esImPar (int num)
    {
        if(num % 2 != 0)
            return true;
        else
            return false;
    }
    
    /**
     * Contar impares DyV
     * @param array
     * @param inicio
     * @param fin
     * @return el total de impares en el array
     */
    public static int contarImpares (int[] array, int inicio, int fin)
    {
        if (inicio == fin)
        {
            if (esImPar(array[inicio]))
                return 1;
        }
        else if (inicio == fin - 1)
        {
            int ret = 0;
            if(esImPar(array[inicio])) 
                ret++;
            if(esImPar(array[fin])) 
                ret++;            
            return ret;
        }            
        else
        {
            int media = (fin + inicio) / 2;
            int totalIz = contarImpares(array, inicio, media);
            int totalDer = contarImpares(array, media + 1, fin);
            return totalIz + totalDer;
        }
        return 0;
    }   
    
    
    /**
     * Comparar arrays gemelos DyV
     * @param a
     * @param b
     * @param inicio
     * @param fin
     * @return 
     */
    public static boolean gemelos (int[] a, int[] b, int inicio, int fin)
    {
        if (inicio == fin)
        {
            if (!esImPar(a[inicio]) && !esImPar(b[inicio]) && esImPar(a[inicio + 1]) && esImPar(b[inicio + 1]))
                return true;
            else
                return false;
        }
        else if (inicio == fin - 1)
        {
            //Primero checkeo el fin porque buscamos la mas a la derecha
            if (!esImPar(a[fin]) && !esImPar(b[fin]) && esImPar(a[fin + 1]) && esImPar(b[fin + 1]))
                return true;
            if (!esImPar(a[inicio]) && !esImPar(b[inicio]) && esImPar(a[inicio + 1]) && esImPar(b[inicio + 1]))    
                return true;
            return false;
        }
        else
        {
            int media = ((fin + inicio) / 2) + 1;
            if (esImPar(a[media]))
                return gemelos(a, b, inicio, media - 1);
            else
                return gemelos(a, b, media, fin);
        }
    }
    
    /**
     * Calcular media DyV
     * @param a
     * @param inicio
     * @param fin
     * @return 
     */
    public static float calcularMedia(float[] a, int inicio, int fin)
    {
        if (inicio == fin)
        {
            return a[inicio];
        }
        else if (inicio == fin - 1)
        {
            return (a[inicio] + a[fin]) / 2;
        }
        else
        {
            int media = (fin + inicio) / 2;
            float mediaIz = calcularMedia(a, inicio, media);
            float mediaDer = calcularMedia(a, media + 1, fin);
            return (mediaIz + mediaDer) / 2;
        }
    }
    
    /**
     * Mutiplicar N por C DyV
     * 
     * Implementar en Java una función que reciba como entrada un número N, y
        que calcule el producto de N·C, siendo C otro número constante preestablecido. Se pide
        resolver el problema como una repetición de sumas utilizando el enfoque de divide y
        vencerás, y teniendo en cuenta que el orden de magnitud de la función propuesta debe
        ser obligatoriamente O(log N). Calcular de manera razonada su complejidad. 
        *
     * @param N
     * @param C
     * @return 
     */
    public static int multNxC(int N, int C)
    {
        if (N == 1)
        {
            return C;
        }
        else
        {
            int p1 = multNxC(N / 2, C);
            
            if (N % 2 == 0)
                return p1 + p1;
            else
                return p1 + p1 + C;    
        }        
    }
    
    /**
     * Busqueda ternaria
     * @param array
     * @param x
     * @param inicio
     * @param fin
     * @return 
     */
    public static int busTer(int[] array, int x, int inicio, int fin)
    {
        if (fin > 0 && fin >= inicio) 
        {
            //Dividir array en 3 partes y crear dos puntos medios
            int punto1 = inicio + (fin - inicio) / 3;
            int punto2 = fin - (fin - inicio) / 3;
            
            //Comprobar si alguno de los puntos medios contiene lo buscado
            if (array[punto1] == x)
            {
                return punto1;
            }
            else if (array[punto2] == x)
            {
                return punto2;
            }

            //Mirar en cual de las 3 partes esta el numero
            if (x < array[punto1]) 
            {
                return busTer(array, x, inicio, punto1 - 1); 
            } 
            else if (x > array[punto2]) 
            { 
                return busTer(array, x, punto2 + 1, fin); 
            } 
            else 
            { 
                return busTer(array, x, punto1 + 1, punto2 - 1); 
            } 
        }
        return -1;
    }
    
    
    
    
    //------------------------- ITER
    
    public static int contarImparesIter (int[] array, int inicio, int fin)
    {
        int totalImpares = 0;
        for(int i = inicio; i <= fin ; i++)
        {
            if(array[i] % 2 != 0)
                totalImpares++;
        }
        return totalImpares;
    }
}
