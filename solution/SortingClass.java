import java.util.Random;
//@ Ahmet Gürbüz-1509510002-Section A
public class SortingClass {
    public static void heapSort (int Array[]){
       //Heapsort

        for (int i = (Array.length/2)-1; i >= 0; i--)//takes => O(n) time.
        {
            heapify(Array,Array.length,i);}

            for (int i = Array.length - 1; i >= 0; i--) {
                //swapping (reversing)
                int temp = Array[0];
                Array[0] =Array[i];
                Array[i] = temp;
                heapify(Array,i,0);
            }
        //System.out.print("Sorted Array: ");
        //for (int i = 0; i < Array.length; i++) System.out.print(Array[i] + " | ");   //This lines used for testing sorting algorithm.
        //System.out.print("\n");
    }
    static void heapify(int Array[],int length ,int i) {//takes => O (log(n)) time because this fuction edits the whole series.
        int min = i;
        int leftchild = (2 * i) + 1;
        int rightchild = (2 * i) + 2;

        if (leftchild < length && Array[min] > Array[leftchild]) {min = leftchild;}    //burada max iþleminide denedim ama sonuçlar tam düzgün gelmiyor bunun
        if (rightchild < length && Array[min] > Array[rightchild]) {min = rightchild;} // örneðin burada Array[max] < Array[leftchild] gibi bir yazým ugularsak
                                                                                       //basit bir index için 4 3 2 0 1 sonucnu alýyoruz.(Bunu kodladým).
                                                                                    //
        if (min!= i){
            int temp = Array[i];
            Array[i] = Array[min];
            Array[min] = temp;
        heapify(Array,length,min);}
    }
    public static void shellSort(int Array[]) {
        int length = Array.length;
        for(int gap=length/2;gap>=1;gap/= 2){
            for(int r = gap;r<length;r++){
                for(int l = r-gap;l>=0;l -=gap){
                   if(Array[l]>Array[l+gap]){

                       int temp =Array[l];
                       Array[l]=Array[l+gap];
                       Array[l+gap]=temp;
                   }else{
                       break;
                   }
                }
            }

        }
        //System.out.print("Sorted Array: ");
        //for (int i = 0; i < Array.length; i++) System.out.print(Array[i] + " | ");  // This lines used for testing sorting algorithm.
        //System.out.print("\n");
    }
    private static void dualQuickSort(int Array[],int left,int right) {


    if (right>left){
        if(Array[left]>Array[right]){
            int tmp = Array[left];
            Array[left] = Array[right];
            Array[right] = tmp;
        }
        int p = Array[left];
        int q = Array[right];

        int l = left+1;
        int g = right-1;
        int k = l;
        while (k<=g){
            if(Array[k]<p){
                int tmp = Array[k];
                Array[k] = Array[l];
                Array[l] = tmp;
                l++;
            }else {
                if (Array[k]>q) {
                    while (Array[g] > q && k < g){
                        --g;}
                    int tmp = Array[k];
                    Array[k] = Array[g];
                    Array[g] = tmp;
                    g--;
                    if (Array[k] < p) {
                        tmp = Array[k];
                        Array[k] = Array[l];
                        Array[l] = tmp;
                        ++l;
                    }
                }
            }
            ++k;
        }
        --l;
        ++g;

        int tmp = Array[left];
        Array[left] = Array[l];
        Array[l] = tmp;

        tmp = Array[right];
        Array[right] = Array[g];
        Array[g] = tmp;

        dualQuickSort(Array,left,l-1);
        dualQuickSort(Array,l+1,g-1);
        dualQuickSort(Array,g+1,right);
    }
    }
    private static void dualPivotQuickSort(int[] Array) {
        int a = 0;
        int b = Array.length-1;
        dualQuickSort(Array,a,b);
        //System.out.print("Sorted Array: ");
        //for (int i = 0; i < Array.length; i++) System.out.print(Array[i] + " | ");  // This lines used for testing sorting algorithm.
        //System.out.print("\n");
    }

    public static void main (String[]args) {
        long estimatedTime;

        Random rand = new Random();
        int n=1000;// array size
        int[] arrayToSort = new int[n];
        for(int i = 0 ; i < n ; i++)
            arrayToSort[i] = i; //rand.nextInt();
        //System.out.print("Before Array: ");
        //for (int i = 0; i < arrayToSort.length; i++) System.out.print(arrayToSort[i] + " | ");
        //System.out.print("\n");
        long startTime = System.nanoTime();

        try {
            heapSort(arrayToSort);
            //shellSort(arrayToSort); // run one of the sorting methods
            //dualPivotQuickSort (arrayToSort);
            estimatedTime = System.nanoTime() - startTime;
            System.out.println("estimatedTime : " + estimatedTime);
        }catch (StackOverflowError e){
            Runtime.getRuntime().gc();
            estimatedTime = System.nanoTime() - startTime;
            System.out.println("estimatedTime : " + estimatedTime);
        }

    }




}
//java.lang.System.nanoTime()
//System.currentTimeMillis()