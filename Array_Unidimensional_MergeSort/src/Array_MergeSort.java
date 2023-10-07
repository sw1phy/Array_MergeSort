import java.util.Scanner;

public class Array_MergeSort {
    public static int[] MergeSort(int[] vector){
        //Método recursivo
        if(vector.length < 2){
            return vector;
        }else{
            //Definir tamaños de divisiones del arreglo
            int mitad = vector.length/2;
            //Lado izquierdo recibe la mitad
            int[] mitadIzqda = new int[mitad];
            int[] mitadDcha;
            //Se valida si el tamaño del arreglo es par o impar
            //Si es par, recibe la mitadIzqda, de lo contrario, se le suma un espacio a la mitadDcha
            if(vector.length % 2 == 0){
                mitadDcha = new int[mitad];
            }else{
                mitadDcha = new int[mitad+1];
            }
            //llenamos las mitades con los datos del arreglo original
            for(int i=0; i<mitad; i++){
                mitadIzqda[i] = vector[i];
            }
            for(int i=0; i<mitadDcha.length; i++){
                mitadDcha[i] = vector[mitad+i];
            }
            //Se llama el método para volver a dividir nuestros lados del arreglo
            mitadIzqda = MergeSort(mitadIzqda);
            mitadDcha = MergeSort(mitadDcha);
            //Se llama la función Merge para ordenar el arreglo
            return merge(mitadIzqda, mitadDcha);
        }
    }

    private static int[] merge(int[] mitadIzqda, int[] mitadDcha){
        //Se crea el arreglo donde se guardaran los datos ordenados
        int[] arregloOrdenado = new int[mitadIzqda.length + mitadDcha.length];
        //Se inicializan los punteros para cada arreglo de datos ordenados y las mitades
        int i = 0, j = 0, k = 0;
        /*
        El ciclo se cierra hasta que los punteros lleguen al mayor
        tamaño; dentro del ciclo los datos se mueven de una mitad a otra, comprobando
        que dato es menor a otro, para luego guardar ese dato en el arreglo vacio
         */

        while(i < mitadIzqda.length || j < mitadDcha.length){
            if(i < mitadIzqda.length && j < mitadDcha.length){
                //Se captura el número menor y se guarda en el arreglo ordenado vacio
                if(mitadIzqda[i] < mitadDcha[j]){
                    arregloOrdenado[k++] =  mitadIzqda[i++];
                }else{
                    arregloOrdenado[k++] = mitadDcha[j++];
                }
                /*
                Cuando un puntero llega a su tamaño sale y solo la mitad se ha completado
                Con los else if, nos aseguramos que la otra mitad de los datos que no seleccionamos
                anteriormente como "menor" sean guardados en el arreglo
                 */
            }else if(i < mitadIzqda.length){
                arregloOrdenado[k++] = mitadIzqda[i++];
            }else{
                arregloOrdenado[k++] = mitadDcha[j++];
            }
        }
        return arregloOrdenado;

    }


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Ingrese el tamaño del vector: ");
        int tan = scn.nextInt();
        int[] vectorIngresado = new int[tan];
        for(int i = 0; i<tan; i++){
            System.out.print("Ingrese el número "+(i+1) +": ");
            vectorIngresado[i] = scn.nextInt();
        }
        int[] vectorOrdenado = Array_MergeSort.MergeSort(vectorIngresado);

        System.out.println("Arreglo Ingresado");
        for(int dato : vectorIngresado){
            System.out.print(" | "+dato);
        }
        System.out.println("|");
        System.out.println("Arreglo Ordenado");
        for(int dato : vectorOrdenado){
            System.out.print(" | " + dato);
        }
        System.out.println("|");

    }
}


