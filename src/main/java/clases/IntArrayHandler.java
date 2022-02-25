package clases;

import java.util.Random;

import helpers.Helper;

public class IntArrayHandler {
    
    
    private IntArrayHandler() {
    }
    
    /**
     * <p>Este metodo realiza una busqueda lineal creciente de
     * un elemento en un array.<p/>
     *
     * <p>Devuelve el indice del elemento en el array o -1 si no se encuentra</p>
     * @param elemento numero entero a buscar en el array
     * @param array array en el que se busca el elemento
     * @return Indice del elemento en el array [0-length-1].<br/>
     *            -1 si no se encuentra el elemento
     */
	public static int busquedaLineal(int elemento, int[] array) {
		int retorno = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == elemento) {
				retorno = i;
				return retorno;
			}
		}
		return retorno;
	}
    
    /**
     * Busqueda dicotomica o binaria
     * <p>Este metodo realiza una busqueda dicotomica de un entero en un array ordenado
     * de forma creciente<p/>
     *
     * <p>Devuelve el indice del elemento en el array o -1 si no se encuentra</p>
     * @param elemento numero entero a buscar en el array
     * @param vector array en el que se busca el elemento
     * @return Indice del elemento en el vector [0-length].<br/>
     *            -1 si no se encuentra el elemento
     */
       
    public static int busquedaDicotomica(int dato,int  array[]){
    	int f = -1;

		int izquierda = 0;
		int centro;
		int derecha = array.length - 1;
		
		if(array.length==1) {
            return 0;
        }
		
		do {
			centro = (izquierda + derecha) / 2;

			if (array[centro] == dato) {
				return centro;
			} 
			else if (dato < array[centro]) {
				derecha = centro - 1;
			} 
			else {
				izquierda = centro + 1;
			}
			
		} while (izquierda <= derecha);

		return f;
  	  }
/*
    public static int busquedaBinaria(int elemento, int []array) {
    	int tamanyo = array.length;
        int medio = tamanyo/2;
        
        if(array.length==1) {
            return 0;
        }
        if(array[medio]<elemento) {
            for(int i = medio;i<array.length;i--) {
            	if(array[i]==elemento) {
            		return i;
            	}
            }
        }
        if(array[medio]>elemento) {
        	for(int i = medio;i<array.length;i++) {
        		if(array[i]==elemento) {
        			return i;
        		}
        	}
        }
        return medio;
    } 
*/   
    /**
     * <p>El metodo devuelve un array de las dimensiones que se pasen como parametro</p>
     * <p> Cada elemento del array de entrada indica la cantidad de elementos de cada dimension</p>
     *
     * @param entrada Array con el numero de elementos de cada dimension
     * @return El array creado o null en caso de valores no validos
     */
    public static Object creaArray(int[] entrada) {    
        Object retorno = null;
        if(entrada.length==1) {
        retorno = new int[entrada[0]];
        }
        else if(entrada.length==2) {
        retorno = new int[entrada[0]][entrada[1]];
        }
        else if(entrada.length==3){
        retorno = new int[entrada[0]][entrada[1]][entrada[2]];
        }
        return retorno;
    }
    
    /**
     * El metodo rellena un array de numeros aleatorios que se pasa como parametro
     *
     * Los valores aleatorios deben estar comprendidos entre -50 y 50
     * @param ret array a rellenar
     */
	public static void rellenaAleatorio(int[] ret) {
		Random r = new Random();
		for (int i = 0; i < ret.length; i++) {
			ret[i] = r.nextInt((101) - 50);
		}
	}
    
    /**
     * <p>El metodo comprueba si el contenido de dos Arrays de enteros es el mismo.
     * Los arrays que se pasan como objetos, pueden tener hasta tres dimensiones</p>
     * </p>Para que los arrays se consideren iguales, pueden ser el mismo objeto
     * o tener exactamente el mismo contenido</p>
     * @param a Array 1 de enteros a comparar
     * @param b Array 2 de enteros a comparar
     * @return true si son iguales, false en caso contrario
     * @throws RuntimeException si los tipos no permiten comparar
     */
	 public static boolean equals(Object a, Object b) {
	        
	        if(a instanceof int[] || a instanceof int[][] || a instanceof int[][][]) {
	        }
	        else {
	            throw new ClassCastException("El valor de a no es valido");
	        }
	            
	        if(b instanceof int[] || b instanceof int[][] || b instanceof int[][][]){
	        }
	        else {
	            throw new ClassCastException("El valor de b no es valido");
	        }

	        boolean ret = false;
	        if (a instanceof int [] && b instanceof int[]) {
	            ret = equals((int[])a, (int[])b);
	        }
	        if(a instanceof int[][] && b instanceof int[][]) {
	            ret = equals((int[][])a, (int[][])b);
	        }
	        if(a instanceof int[][][] && b instanceof int[][][]) {
	            ret = equals((int[][][])a, (int[][][])b);
	        }
	        return ret;
	    }
	    
		private static boolean equals(int[] a, int[] b) {
			boolean ret = false;
			if (a == b) {
				ret = true;
			}
			if (a.length == b.length) {
				ret = true;
				for (int i = 0; i < a.length; i++) {
					if (a[i] != b[i]) {
						ret = false;
						break;
					}
				}
			}
			return ret;
		}
	    
/*VERSION 2
	    private static boolean equals(int[] a, int[] b) {
	        boolean ret = false;
	        if (a == b) {
	            ret = true;
	        }
	        if (a.length == b.length) {
	            for (int i = 0; i < a.length; i++) {
	
	                if (a[i] == b[i]) {
	                    ret = true;
	                } else {
	                    ret = false;
	                    return ret;
	                }
	            }
	        }
	        return ret;
	    }
*/
	    
		private static boolean equals(int[][] a, int[][] b) {
			boolean ret = false;
			if (a == b) {
				ret = true;
			}
			if (a.length == b.length) {
				ret = true;
				for (int fila = 0; fila < a.length && ret == true; fila++) {
					ret = equals(a[fila], b[fila]) ? true : false;
				}
			}
			return ret;
		}

/*VERSION 2
	    private static boolean equals(int[][]a,int[][]b) {
	        boolean ret = false;
	        if (a == b) {
	            ret = true;
	        }
	        if (a.length == b.length) {
	            ret = true;
	                for (int fila = 0; fila < a.length && ret==true; fila++) {
	                    if (a[fila].length == b[fila].length) {
	                        for (int columna = 0; columna < a[fila].length && ret==true; columna++) {
	                            if(a[fila][columna]!=b[fila][columna])
	                                ret = false;
	                        }
	                    }else {
	                        ret = false;
	                    }
	                }
	            }
	        return ret;
	        }
*/ 

		private static boolean equals(int[][][] a, int[][][] b) {
			boolean ret = false;
			if (a == b) {
				ret = true;
			} else {
				if (a.length == b.length) {
					ret = true;
					for (int cara = 0; cara < a.length && ret; cara++) {
						if (a[cara].length == b[cara].length) {
							for (int fila = 0; fila < a[cara].length && ret; fila++) {
								if (a[cara][fila].length == b[cara][fila].length) {
									for (int columna = 0; columna < a[cara][fila].length && ret; columna++) {
										if (a[cara][fila][columna] != (b[cara][fila][columna])) {
											ret = false;
										}
									}
								} else {
									ret = false;
								}
							}
						} else {
							ret = false;
						}
					}
		
				}
			}
		
			return ret;
		}

    /**
     * <p>El metodo rellena un array previamente creado y correctamente dimensionado</p>
     * <p>El array se rellena de forma aleatoria haciendo uso de la funcion
     * <i>rellenaArray(Object)</i></p>
     * <p><b>PISTA: </b> para saber de que tipo es el array usa el operador
     * <i>intanceof</i>. Ejemplo: <i>if(array instanceof int[][]).</i></p>
     * @param array Array a rellenar pasado como Object
     * @see IntArrayHandler void rellenaAleatorio(int len)
     */
    public static void rellenaArray(Object array) {    
        if(array instanceof int[]) {
            rellenaArray((int[])array);
        }
        else if (array instanceof int[][]) {
            rellenaArray((int[][])array);
        }
        else if(array instanceof int[][][]) {
            rellenaArray((int[][][])array);
        }
        
    }
    
	    private static void rellenaArray(int[] array) {    
	            rellenaAleatorio(array);
	        }
	    
	    private static void rellenaArray(int[][] array) {    
	        for(int i = 0;i<array.length;i++) {
	            rellenaAleatorio(array[i]);
	        }
	    }
	    
	    private static void rellenaArray(int[][][]array) {    
	        for(int i = 0;i<array.length;i++) {
	            for(int j = 0;j<array[i].length;j++) {
	                rellenaAleatorio(array[i][j]);
	            }
	        }
	    }
    
    /**
     * <p>Metodo que ordena un array Mediante el metodo por <b>Intercambio</b>.
     * </br>Este metodo recorre una a una todas las posiciones del array,
     *  comparando con todas y cada una de las restantes.</br>
     * Intercambia siempre que el elemento con el que esta comparando
     * es menor que el de la posicion en la que se esta trabajando.</p>
     * <p><b>OBLIGATORIO:</b> Hacer los intercambios llamando a <i>Helper.swap(int [] array, int i, int j)</i></p>
     * @param array a ordenar
     * @see Helper
     */
	public static void ordenaIntercambio(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					int temporal = array[i];
					Helper.swap(array, i, j);
					array[j] = temporal;
				}
			}
		}
	}
    
    /**
     * <p>Metodo que ordena un array Mediante el metodo por <b>Selección</b>.
     * </br>Este metodo recorre una a una todas las posiciones del array,
     * buscando el índice del menor elemento restante</br>
     * Intercambia al final de cada iteración si ha encontrado
     * un elemento menor que que el que ocupa la posicion
     * de la iteracion en la que se esta trabajando.</p>
     * <p><b>OBLIGATORIO:</b> Hacer los intercambios llamando a
     * <i>Helper.swap(int [] array, int i, int j)</i></p>
     * @param array a ordenar
     * @see Helper
     */
	public static void ordenaSeleccion(int[] array) {
		int menor, pos, intercambio;
		for (int i = 0; i < array.length - 1; i++) { // tomamos como menor el primero
			menor = array[i]; // de los elementos que quedan por ordenar
			pos = i; // y guardamos su posición
			for (int j = i + 1; j < array.length; j++) { // buscamos en el resto
				if (array[j] < menor) { // del array algún elemento
					menor = array[j]; // menor que el actual
					pos = j;
				}
			}
			if (pos != i) { // si hay alguno menor se intercambia
				intercambio = array[i];
				Helper.swap(array, i, pos);
				array[pos] = intercambio;
			}
		}
	}
    
    /**
     * <p>Metodo que ordena un array Mediante el metodo por <b>Selección</b>.
     * </br>Este metodo recorre una a una todas las posiciones del array menos la ultima,
     * haciendo que en cada iteracion el mayor vaya al final del array.
     * </br>En cada iteracion trataremos un elemento menos del final.</br>
     * Intercambia siempre que elemento apuntado sea mayor que el siguiente.</p>
     * <p><b>OBLIGATORIO:</b> Hacer los intercambios llamando a
     * <i>Helper.swap(int [] array, int i, int j)</i></p>
     * <p><b>MEJORA:</b> Parar la ordenacion si no hay intercambios en una pasada</i></p>
     * @param array a ordenar
     * @see Helper
     */
	public static void ordenaBurbuja(int[] array) {
		int cuentaintercambios = 0;

		for (boolean ordenado = false; !ordenado;) {
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {

					int variableauxiliar = array[i];
					Helper.swap(array, i, i + 1);
					array[i + 1] = variableauxiliar;

					cuentaintercambios++;
				}
			}

			if (cuentaintercambios == 0) {
				ordenado = true;
			}

			cuentaintercambios = 0;
		}
	}

    /*
     * segun se va creando el array se va ordenando
     * helper swap obligatorio
     *
     */
    public static void ordenaInsercion(int [] array) {
    	//TODO ordenaInsercción
		int i, j;
		int aux;
		for (i = 1; i < array.length; i++) {
			/*
			 * indice j es para buscar la posicion correcta del elemento destino
			 */
			j = i;
			aux = array[i];
			// se localiza el punto de inserción explorando hacia abajo
			while (j > 0 && aux < array[j - 1]) {
				// desplazar elementos hacia arriba para hacer espacio
				array[j] = array[j - 1];
				j--;
			}
			array[j] = aux;
		}
	}

    
    /**
     *
     * @param array array a ordenar, arrays vacios y de un solo elemento sin errores.
     */
    public static void quicksort(int [] array) {
    	if (array.length == 0 || array.length ==1) {
    		System.out.println("No se permite arrays vacios o de un solo elemento");
    	}
    	else {
    		qs(array,0,array.length-1);
    	}
    }
    
    /**
     * Metodo auxiliar de Quicksort que realiza la recursividad
     * @param array a ordenar
     * @param inicio inicio del rango a ordenar
     * @param fin del rango a ordenar
     */
    public static void qs (int [] array, int inicio, int fin) {
    	int pivote = array[inicio];
    	int i = inicio;
    	int j = fin;
    	
    	while(i<j) {
    		while(array[i]<= pivote && i<j) {
    			i++;
    		}
    		while(array[j]>pivote) {
    			j--;
    		}
    		if(i<j) {
    			Helper.swap(array, i, j);
    		}
    	}
    	array[inicio] = array[j];
    	array[j]=pivote;
    	
    	if(inicio < j-1) {
    		qs(array,inicio,j-1);
    	}
    	if(j+1<fin) {
    		qs(array,j+1,fin);
    	}
    }
    
}
