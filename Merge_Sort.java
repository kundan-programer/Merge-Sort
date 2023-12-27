import java.util.Scanner;

public class Merge_Sort {

  // public class merge {

  void merge1(int a[], int start, int mid, int end) {
    int l = mid - start + 1;
    int r = end - mid;
    int left[] = new int[l];
    int right[] = new int[r];

    for (int i = 0; i < l; i++)
      left[i] = a[start + i];

    for (int j = 0; j < r; j++)
      right[j] = a[mid + 1 + j];

    int i = 0, j = 0;
    int k = start;

    while (i < l && j < r) {

      if (left[i] <= right[j]) {
        a[k] = left[i];
        i++;
      }

      else {
        a[k] = right[j];
        j++;
      }
      k++;
    }

    while (i < l) {
      a[k] = left[i];
      i++;
      k++;
    }

    while (j < r) {
      a[k] = right[j];
      j++;
      k++;
    }
  }

  void mergesort(int a[], int start, int end) {
    if (start < end) {
      int mid = (start + end) / 2;
      mergesort(a, start, mid);
      mergesort(a, mid + 1, end);
      merge1(a, start, mid, end);
    }
  }

  public static void main(String[] args) {
    int a[], n;
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the size of array: ");
    n = sc.nextInt();

    a = new int[n];

    System.out.println("Enter elements: ");
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }

    Merge_Sort ob = new Merge_Sort();
    ob.mergesort(a, 0, n - 1);

    System.out.print("The sorted array is: ");
    for (int i = 0; i < n; i++) {
      System.out.print(a[i] + " ");
    }
  }
}