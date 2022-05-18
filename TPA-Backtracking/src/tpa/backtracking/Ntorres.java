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
public class Ntorres {
    private int[][] solucion = new int[2][2];

    public Ntorres(){
        for (int i = 0; i < solucion.length; i++)
        {
            for (int j = 0; j < solucion[0].length; j++)
            {
                solucion[i][j] = 0;
            }
        }
    }

    public void imprimir ()
    {
        System.out.println();
        for (int i = 0; i < solucion.length; i++)
        {
                for (int j = 0; j < solucion[0].length; j++)
                {
                        System.out.print(solucion[i][j] + " ");
                }
                System.out.println();
        }
        System.out.println();
    }

    public boolean vuelta_atras(int arr[][], int etapa, int torresRestantes)
    {
        for (int i = 0; i< arr.length; i++)
        {
            if (aceptable(i, etapa))
            {
                arr[i][etapa] = 1;
                torresRestantes--;
                if(etapa == arr.length - 1 || torresRestantes == 0)
                {
                    if (torresRestantes == 0)
                    {
                        imprimir();        
                        return true;
                    }
                }
                else
                {
                    if (vuelta_atras(arr,etapa + 1, torresRestantes))
                        return true;
                }
                arr[i][etapa] = 0;
                torresRestantes++;
            }
        }
        return false;
    }

    public boolean aceptable(int i, int etapa)
    {
        //filas
        for (int j = 0; j <= i; j++)
        {
            if(solucion[j][etapa] == 1)
                return false;
        }
        //columnas
        for (int j = 0; j <= etapa; j++)
        {
            if(solucion[j][etapa] == 1)
                return false;
        }
        return true;
    }
}
