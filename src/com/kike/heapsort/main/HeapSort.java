package com.kike.heapsort.main;

public class HeapSort {
    
    // Función principal para ordenar un array usando Heap Sort
    public void heapSort(int arr[]) {
        int n = arr.length;

        // Construir un heap máximo. comenzamos con el último nodo que no es una hoja, es decir el índice n / 2 - 1)
        // y vamos hacia atrás
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extraer elementos del heap uno por uno y se colocan en la posición correcta en el array ordenado
        for (int i = n - 1; i > 0; i--) {
            // Mover el elemento actual al final del array, ya que ahora es elemento máximo.
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Llamar a heapify en el subárbol reducido (comenzamos en la raíz del heap)
            // Convertimos 
            heapify(arr, i, 0);
        }
    }

   
    /**
     * Heapify.
     *
     * @param arr La primera variable es al array a ordenar.  El método heapify trabaja en este array para reorganizarlo y mantener la propiedad del montículo.
     * @param n Es el tamaño actual del montículo o subárbol que se está procesando en la llamada actual a heapify. Esta variable es importante porque le indica a la función cuántos elementos del array deben ser considerados en el montículo. En cada llamada recursiva o iteración de heapify, el tamaño del montículo se reduce, generalmente disminuyendo en 1. 
     * 			La variable n asegura que solo se procesen los elementos válidos del array.
     * @param i Este parámetro representa la posición del nodo actual en el montículo o subárbol que se está procesando en la llamada actual a heapify. En otras palabras, i es el índice del nodo que se está considerando en ese momento. La función heapify comienza su trabajo desde un nodo en particular y se asegura de que ese nodo y 
     * 					sus descendientes cumplan con la propiedad del montículo máximo.
     */
    void heapify(int arr[], int n, int i) {
        int elMasGrande = i; // inicializar la variable elMasGrande con el valor de i, que representa la posición de un nodo en el montículo (heap).
        int hijoIzquierdo = 2 * i + 1; // Índice del hijo izquierdo
        int hijoDerecho = 2 * i + 2; // Índice del hijo derecho

        // Si el hijo izquierdo es más grande que la raíz
        if (hijoIzquierdo < n && arr[hijoIzquierdo] > arr[elMasGrande]) {
            elMasGrande = hijoIzquierdo;
        }

        // Si el hijo derecho es más grande que el más grande hasta ahora
        if (hijoDerecho < n && arr[hijoDerecho] > arr[elMasGrande]) {
            elMasGrande = hijoDerecho;
        }

        // Si el nodo más grande no es el del índice i, lo intercambiamos
        if (elMasGrande != i) {
            int swap = arr[i];
            arr[i] = arr[elMasGrande];
            arr[elMasGrande] = swap;

            // Llama recursivamente a heapify en el subárbol afectado
            heapify(arr, n, elMasGrande);
        }
    }

    // Función de utilidad para imprimir un array
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Método principal para probar el algoritmo
    public static void main(String args[]) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        int n = arr.length;

        System.out.println("Array original:");
        printArray(arr);

        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(arr);

        System.out.println("Array ordenado:");
        printArray(arr);
    }
}
