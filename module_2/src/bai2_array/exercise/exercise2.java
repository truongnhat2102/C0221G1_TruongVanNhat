package bai2_array.exercise;

        import java.util.Scanner;

public class exercise2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
            System.out.println(arr[i]);
        }
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("enter element add to array: ");
        int add = scanner1.nextInt();
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("enter index of add to array: ");
        int index = scanner2.nextInt();
        for (int j = 0; j < arr.length + 1; j++) {
            System.out.println(add1Element(arr, add, index)[j]);
        }
    }

    public static int[] add1Element(int[] arr, int add, int index) {
        int arrNew[] = new int[arr.length + 1];
        for (int i = 0; i < arrNew.length; i++) {
            if (i < index - 1) {
                arrNew[i] = arr[i];
            } else if (i == index - 1) {
                arrNew[i] = add;
            } else {
                arrNew[i] = arr[i - 1];
            }
        }
        return arrNew;
    }
}
