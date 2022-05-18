

/* EJERCICIO 1

*/
int gradoGrafo (Grafo graf)
{
	int grado = 0;
	if (!grafo.esVacio())
	{
		Lista<Vertices> listV = graf.listaVertices();//Saco lista de vertices en el grafo	
		for (Vertice v : listV) //Iterar la lista para sacar cada vertice
			grado += graf.gradoEntrada(v.clave) + gradoSalida(v.clave); //Sumar al total de grados del grafo el grado del vertice actual
	}
	else
		return grado;
}

/* EJERCICIO 2

1.Mirar sucesores
2.Listar sucesores
3.Comprobar si el sucesor esta en lista de visitados
	Si-> 
	NO-> 4.Ver si alguno es v2
			4.1Meter en la lista de visitados
				-> return true
				-> volver a 1.
*/
boolean verticeAlcanzable (Grafo graf, Vertice v1, Vertice v2)
{
	boolean sePuede = false;
	if (!grafo.esVacio())
	{	
		Cola<Vertice> c = new Cola<>();
		c.insertar(v1);
		
		List<Vertice> visitados = new List<>();
		
		while (! c.esVacia()) //Se saldra del bucle una vez se hayan visitado todos los vertices que sucedan a v1 o se encuentre v2 entre ellos.
		{
			a = c.frente();
			c.extraer();
			
			visitados.add(a);
			
			if (a == v2) //Si es igual, es que se puede llegar
			{
				sePuede = true;
				c.vaciar();	//Vacio para salir del bucle			
			}
			else //Si no buscas sucesores que no hayan sido visitados ya y los metes a la cola
			{
				List<Vertice> sucesores = grafo.listaSucesores(a.clave);
				for (Vertice v : sucesores) //iterar sucesores (n)
					if(!visitados.contains(v)) //iterar lista de visitados para buscar si existe y agregar a la cola (n)
						c.insertar(v);						
			}			
		}
	}
	return sePuede;
}



/* EJERCICIO 3

*/
void imprimirClaveAnexas(Grafo graf, Vertice v1)
{
	if (!grafo.esVacio())
	{
		Cola<Vertice> c = new Cola<>();
		c.insertar(v1);
		
		List<Vertice> visitados = new List<>();
		
		while (!c.esVacia()) //Se saldra del bucle una vez se hayan visitado todos los vertices adyacentes a v1
		{
			a = c.frente();
			c.extraer();	
			
			visitados.add(a);
			
			System.out.println(a.clave); //Imprimir clave en una linea
			
			List<Vertice> adyacentes = grafo.listaAdyacentes(a.clave);
			for (Vertice v : adyacentes) //iterar adyacentes (n)
				if(!visitados.contains(v)) //iterar lista de visitados para agregar a la cola (n)		
					c.insertar(v);											
		}
	}
}


/* EJERCICIO 5

Puedo hacer una copia del grafo, borrar todas las anexas al vertice que me piden y mostrar todas las componentes del grafo que serian las no anexas
ya que las anexas no estarian porque las he borrado
*/
void imprimirClaveNoAnexas(Grafo graf, Vertice v1)
{
	if (!grafo.esVacio())
	{
		Grafo grafCopia = graf;
		
		Cola<Vertice> c = new Cola<>();
		c.insertar(v1);
		
		//List<Vertice> visitados = new List<>(); No hace falta guardar visitados ya que los visitados se van borrando
		
		while (!c.esVacia()) //Se saldra del bucle una vez se hayan visitado todos los vertices adyacentes a v1
		{
			a = c.frente();
			c.extraer();	
						
			List<Vertice> adyacentes = grafo.listaAdyacentes(a.clave);
			
			for (Vertice v : adyacentes) //iterar adyacentes (n)	
				c.insertar(v);							
			
			grafCopia.eliminarVertice(a); //eliminamos el vertice ya que esta adjunto y no lo queremos
		}
		
		//una vez ha terminado de borrar todas las anexas
		Lista<Vertices> listV = grafCopia.listaVertices(); //Saco lista de vertices en el grafo (en el grafo solo quedan vertices no anexos a v1)
		
		
		for (Vertice v : listV)
			System.out.println(v.clave); //imprimir los vertices
	}
}



