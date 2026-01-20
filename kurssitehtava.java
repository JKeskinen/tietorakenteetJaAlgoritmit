
// https://www.gregorygaines.com/blog/how-to-use-function-pointers-in-java/


import java.util.Random;

public class kurssitehtava {
    

    // RANDOMARRYN LUONTI//
    public static int[] makeRandomArray(int n)
    {
        int[] array = new int[n];
        Random gen = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = gen.nextInt(n);
        }
        return array;
    }
    //TULOSTETAAN ARRAY//
    public static void printArray(int[] array)
    {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


        //--------insertionSort-------//
    public static void insertionSort(int[] arr)
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            // Siirretään suuremmat alkiot oikealle
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
        //--------bubbleSort---------//
    public static void bubbleSort(int[] arr)
    {
        int n = arr.length;
        int i, j, temp;   
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    
                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
            }
        
    }    
        //---------shellSort--------//
    public static void shellSort(int[] arr)
    {
        int n = arr.length;

        // Start with a large gap, then reduce it step by step
        for (int gap = n / 2; gap > 0; gap /= 2) {

            // Perform a "gapped" insertion sort for this gap size
            for (int i = gap; i < n; i++) {
                
                // Current element to be placed correctly
                int temp = arr[i]; 
                int j = i;

                // Shift earlier elements that are greater than temp
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }

                // Place temp in its correct position
                arr[j] = temp;
            }
        }  
    }    




        //---------arraySort-------//
    public static void arraySort(int[] arr)
    {
        java.util.Arrays.sort(arr);
    }    







    //----QUICKSORT-partition osuus--------//
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    // Vaihtaa kahden alkion paikat
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

            //-------quickSort--------//
    public static void quickSort(int[] arr,int low, int high)
    {
        if (low < high) {
            
            // pi is the partition return index of pivot
            int pi = partition(arr, low, high);

            // recursion calls for smaller elements
            // and greater or equals elements
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }    



        //----selectionSort------//
    public static void selectionSort(int[] arr)
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
          
            // Assume the current position holds
            // the minimum element
            int min_idx = i;

            // Iterate through the unsorted portion
            // to find the actual minimum
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                  
                    // Update min_idx if a smaller element
                    // is found
                    min_idx = j;
                }
            }

            // Move minimum element to its
            // correct position
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }  
    }



    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    static void merge(int arr[], int l, int m, int r){
        
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy arr to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays
        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }





        //------mergeSort-------//
    public static void mergeSort(int[] arr, int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }   



    

    public static void quickMethod(int[] arr)
    {
        //quickMethodVarsinainen(arr, 0, arr.length-1);
    }        

    // Wrapper quickSortille 
    public static void quickSortWrapper(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
    //Wrapper mergeSortille
    public static void mergeSortWrapper(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }


    private interface FunctionPointer {
        // Method signatures of pointed method
        void methodSignature(int[] arr);
    }

    public static void SortMethodTester(FunctionPointer methodToBeTested, String methodName, int n)
    {
        // Tehdään satunnainen taulukko.
        // Oikeastaan taulukon luomismetodi (satunnainen, nouseva, laskeva)
        // voitaisiin antaa myös parametrina.
        int[] array = makeRandomArray(100000);

        // otetaan alkuaika
        //long start = System.nanoTime();
        long millisStart = System.currentTimeMillis();

        // Kutsutaan parametrina annettua testattavaa metodia.
        methodToBeTested.methodSignature(array);

        // otetaan loppuaika
        //long end = System.nanoTime();
        long millisEnd = System.currentTimeMillis();

        //long kesto = end - start;
        long millisKesto = millisEnd - millisStart;

        // tulostetaan kestoaika
        //System.out.println(methodName + ": " + kesto);
        System.out.println(methodName + ": " + millisKesto + "ms");
    }

    public static void main(String[] args) {

        // nämä voisivat olla taulukossa
        FunctionPointer insertionSort = kurssitehtava::insertionSort;
        //FunctionPointer methodA = FunctionRef::sortMethodA;
        FunctionPointer bubbleSort = kurssitehtava::bubbleSort;
        FunctionPointer shellSort = kurssitehtava::shellSort;
        FunctionPointer arraySort = kurssitehtava::arraySort;
        FunctionPointer quickSort = kurssitehtava::quickSortWrapper;
        FunctionPointer selectionSort = kurssitehtava::selectionSort;
        FunctionPointer mergeSort = kurssitehtava::mergeSortWrapper;
        
        // ja näitä voisi kutsua silmukassa
        SortMethodTester(bubbleSort, "bubbleSort", 1);
        SortMethodTester(insertionSort, "insertionSort",1);
        //SortMethodTester((arr) -> sortMethodA(arr), "Method A", 100000);
        SortMethodTester(selectionSort, "selectionSort", 1);
        SortMethodTester(arraySort, "arraySort", 1);
        SortMethodTester(shellSort, "shellSort", 1);
        SortMethodTester(quickSort, "quickSort",1);
        SortMethodTester(mergeSort, "mergeSort", 1);

        // https://www.gregorygaines.com/blog/how-to-use-function-pointers-in-java/
    }
}








