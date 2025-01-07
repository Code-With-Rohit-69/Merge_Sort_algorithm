public class MergeSort {

    public static void mergeSort(int arr[], int si, int ei) {
        // Base case
        if (si >= ei) {
            return;
        }

        int mid = si + (ei - si) / 2;

        mergeSort(arr, si, mid); // left part of the array
        mergeSort(arr, mid + 1, ei); // right part of the array
        merge(arr, si, mid, ei); // merging after sorting
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si; // for left
        int j = mid+1; // for right part
        int k = 0; // for index of temp array

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) { // agar arr[i] hamara chotta hota hai tho ham temp k andhar arr[i] ki value insert kareng
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++ ;
            }
            k++; // uske baad temp array ke index (k) ko increase karedenge by 1
        }

        // agar koi element rah gya hai left array ka
        while (i <= mid) {
            temp[k] = arr[i];
            k++; i++;
        }

        // agar koi element rah gya hai right array ka
        while (j <= ei) {
            temp[k] = arr[j];
            k++; j++;
        }

        // copy temp to original Array

        for(k=0, i=si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }

    }

    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 6, 3, 9, 5, 2, 8 };
        mergeSort(arr, 0, arr.length - 1);
        print(arr);
    }
}