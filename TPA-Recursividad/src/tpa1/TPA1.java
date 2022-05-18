/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpa1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author SaFteiNZz
 */
public class TPA1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int size = 20;
        
        int[][] a,b,c;
        a = new int[size][size];
        b = new int[size][size];
        c = new int[size][size];
        
        for (int i = 0; i < size; i++)
        {
            for (int o = 0; o < size; o++)
            {
                a[i][o]= i;
                b[i][o]= i;
            }            
        }
        
        a[19][19] = 123123;
        for(int[] x: a)
            System.out.println(Arrays.toString(x));
        
        System.out.println("\n");
        
        for(int[] x: b)
            System.out.println(Arrays.toString(x));
        
        System.out.println("\n");
        
        
        size--;
        int n[] = {size, size};
        
        
        if(comparar( a, b, n))
            System.out.println("IGUALES");
        else
            System.out.println("NO IGUALES");
        
//        System.out.println("\n");
//        for(int[] x: c)
//            System.out.println(Arrays.toString(x));
    }
    
    /**
     * Codificar en Java una función recursiva que reciba como parámetros de
     * entrada tres matrices A, B y C de dimensiones NxN de números enteros. 
     * Debe modificar C, almacenando en ella el resultado de sumar las matrices A y B. Calcular su complejidad de
     * manera razonada, utilizando para ello la correspondiente ecuación de reducción.
     * @param a matriz sumador
     * @param b matriz sumador
     * @param c matriz resultado
     * @param n tamaño matriz NxN
     *  -n[0] es la fila
     *  -n[1] es la columna
     * @return parametro resultado de la suma de arrays a y b
     */
    public static int[][] sumar(int[][] a, int[][] b, int[][] c, int [] n)
    {
        //DEBUG
        System.out.println(n[0] + ",  " + n[1]);         
        //SUMA
        c[n[0]][n[1]] = a[n[0]][n[1]] + b[n[0]][n[1]];
        //CASO BASE
        if (n[0] <= 0 && n[1] <= 0)
            return c;
        
        //CASO GENERAL
        //COLUMNA MAYOR QUE 0 -> SIGUE 
        if(n[1] > 0)
            n[1]--;    
        //COLUMNA MENOR ó IGUAL A 0 -> RESET + SIGUE COLUMNA
        else 
        {
            n[1] = a.length - 1;
            n[0]--;                  
        }        
        //RELLAMAR
        c = sumar(a,b,c,n); 
        //RETORNO DE SUBLLAMADAS
        return c;                  
    }
    
    /**
     * Se tiene la siguiente función que compara si dos matrices cuadradas son
     * iguales. Se pide implementar en Java una nueva versión más eficiente, que optimice el
     * número de veces que se repite cada instrucción. Calcular a continuación la complejidad
     * de ambas versiones, para justificar la mejora propuesta.
     * @param a matriz comparar
     * @param b matriz comparar
     * @param n tamaño matriz NxN
     *  -n[0] es la fila
     *  -n[1] es la columna
     * @return true o false, false si no son iguales, true si lo son
     */
    public static boolean comparar(int[][] a, int[][] b, int [] n)
    {
        boolean resultado = true;
        //DEBUG
//        System.out.println(a[n[0]][n[1]] + " = " + b[n[0]][n[1]] + "?");  
        //COMPARAR
        if (a[n[0]][n[1]] == b[n[0]][n[1]])
            resultado = true;
        else
            resultado = false;
        //CASO BASE
        if ((n[0] <= 0 && n[1] <= 0) || !resultado)
            return resultado;
        //CASO GENERAL
        //COLUMNA MAYOR QUE 0 -> SIGUE 
        if(n[1] > 0)
            n[1]--;    
        //COLUMNA MENOR ó IGUAL A 0 -> RESET + SIGUE COLUMNA
        else 
        {
            n[1] = a.length - 1;
            n[0]--;                  
        }        
        //RELLAMAR
        resultado = comparar(a,b,n); 
        //RETORNO DE SUBLLAMADAS
        return resultado;                  
    }
}
