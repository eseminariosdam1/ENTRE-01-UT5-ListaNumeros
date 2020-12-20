
/**
 * La clase representa a una lista de 
 * números enteros
 * 
 * @author - Eneko Seminario
 * 
 */
import java.util.Arrays;

public class ListaNumeros 
{
    // definir atributos
    int [] listaNumeros;
    int pos;
   

    /**
     * Constructor de la clase ListaNumeros 
     * Crea e inicializa adecuadamente los
     * atributos
     * 
     * @param n el tamaño máximo de la lista
     */
    public ListaNumeros(int n) {
        listaNumeros = new int[n]; 
        pos = 0;
         
    }

    /**
     * Añade un valor siempre al principio de la lista
     * 
     * @param numero el valor que se añade. No se hace nada si la lista está
     *               completa
     * @return true si se ha podido añadir, false en otro caso
     */
    public boolean addElemento(int numero) {
        if(!estaCompleta()){
            for(int i = pos; i > 0; i--){
                listaNumeros[i] = listaNumeros[i - 1];
            }
            listaNumeros[0] = numero;
            pos++;
            return true;
                }
            return false;
}

    /**
     * devuelve true si la lista está completa, false en otro caso
     * Hacer sin if
     */
    public boolean estaCompleta() {
         
        return listaNumeros.length == pos;

    }

    /**
     * devuelve true si la lista está vacía, false en otro caso. 
     * Hacer sin if
     */
    public boolean estaVacia() {
         return listaNumeros.length == 0;
    }

    /**
     * devuelve el nº de elementos realmente guardados en la lista
     */
    public int getTotalNumeros() {
        return pos;

    }

    /**
     * Vacía la lista
     */
    public void vaciarLista() {
         for (int i = pos - 1; i >= 0; i--) {
          listaNumeros[i] = 0;
               
}
}
   
     /**
     * Representación textual de la lista de la forma indicada 
     * (leer enunciado)
     * 
     * Si la lista está vacía devuelve ""
     */
    public String toString() {
                String str = "";
        if (!estaVacia()){
            for (int i = 0; i < listaNumeros.length; i++){
                str += String.format("%8d", listaNumeros[i]);
            }
            str += "\n";
            for (int i = 0; i < listaNumeros.length; i++){
                str+= String.format("%8d", i);
            }
            return str;
        }
        return "";
    }
            
    /**
     * Mostrar en pantalla la lista
     */
    public void escribirLista() {
        System.out.println(this.toString());
    }

    /**
     * Búsqueda lineal de numero en la lista
     * @param numero el nº a buscar
     * @return un array con las posiciones en las que se ha encontrado
     *  
     */
    public int[] buscarPosicionesDe(int numero) {
        int [] posicionesDeNumero = new int [listaNumeros.length];
        int contador = 0;
        for(int i = 0; i <= pos; i++){
            if(numero == listaNumeros[i] ){
                posicionesDeNumero[contador] = i;
                contador++;
            }
        }
        return posicionesDeNumero;
    } 


    /**
     * Hace una búsqueda binaria del numero indicado devolviendo -1 si no se
     * encuentra o la posición en la que aparece
     * 
     * El array original lista no se modifica 
     * Para ello crea previamente una copia
     * de lista y trabaja con la copia
     * 
     * Usa exclusivamente métodos de la clase Arrays
     * 
     */
    public int buscarBinario(int numero) {
         int [] copiaListaNumeros = new int [listaNumeros.length];
         System.arraycopy(listaNumeros, 0, copiaListaNumeros, 0,  numero);
         Arrays.sort(copiaListaNumeros);
         int posicionDeNumero = Arrays.binarySearch(copiaListaNumeros, numero);
         if(posicionDeNumero >= 0){
            return posicionDeNumero;
            }else
            
            return -1;
    }

   

    /**
     * borra el primer elemento de la lista
     */
    public void borrarPrimero(){
        int numero = 0;
       
        if (numero >= 0 && numero < pos) {
            for (int i = numero + 1; i < pos; i++){
            listaNumeros[i - 1] = listaNumeros[i];
            }
            pos++;
        } 
    }
         
 
 
    
     /**
     *  Invierte cada uno de los grupos de n elementos que hay en lista
     *  
     *  Si el nº de elementos en lista no es divisible entre n los elementos restantes 
     *  quedan igual
     *  
     *  (leer enunciado)
     *  
     */
    public void invertir(int n) {
         

    }

   
  
    /**
     * devuelve un ragged array de 2 dimensiones con tantas filas como valores
     * tenga el atributo lista y rellena el array de la forma indicada
     * (leer enunciado)
     * 
     */
    public int[][] toArray2D() {
        int [][] raggedArray = new int [listaNumeros.length][];
        for(int i = 0; i < listaNumeros.length; i++){
            raggedArray[i] = new int [i + 1];
            raggedArray[i][raggedArray.length - 1] = 1;
            raggedArray[i][0] = 1;
            for(int j = 0; j < listaNumeros.length; j++){
                raggedArray[i][j + 1] = raggedArray[i -1][j] + raggedArray [i - 1][j + 1];
                
            }
            
        }
        return raggedArray;
    }

    /**
     * Punto de entrada a la aplicación 
     * Contiene código para probar los métodos de ListaNumeros
     */
    public static void main(String[] args) {
        ListaNumeros lista = new ListaNumeros(20);

        System.out.println("--- addElemento() y toString() -------");
        int[] valores = {21, -5, 6, -7, 21, -17, 21, 15, 22, 21, 77};
        for (int i = 0; i < valores.length; i++) {
            lista.addElemento(valores[i]);
        }
        System.out.println(lista.toString());

        System.out.println("--- buscarPosiciones() -------");
        int numero = 21;
        System.out.println(lista.toString());
        System.out.println("\t" + numero + " aparece en posiciones ");
        // seguir completando
        
        int[] posicionBuscada = lista.buscarPosicionesDe(numero);
        for(int i = 0; i < posicionBuscada.length; i++){
            System.out.print(posicionBuscada[i]);
        }
        System.out.println();
        
        System.out.println("--- buscarBinario() ---");
        if(lista.buscarBinario(numero) >= 0){
            System.out.println("El numero solicitado aparece en la lista");
        }else{
            System.out.println("El numero solicitado no aparece en la lista");
        }
        System.out.println();
        
        //falta invertir
        
        
        
        System.out.println("---toArray2D() ---");
         int[][] raggedArray = lista.toArray2D();
        for(int i = 0; i < raggedArray.length; i++){
            for(int j = 0; j < raggedArray[i].length; j++){
                System.out.printf("%8d",raggedArray[i][j]);
            }
            System.out.println();
        }
        
        
        
}
    
}

