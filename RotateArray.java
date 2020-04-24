// "static void main" must be defined in a public class.
public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(Arrays.toString(rotateArray(arr, arr.length, -1)));
        System.out.println(Arrays.toString(rotateArray(arr, arr.length, 1)));
    }
    
    public static int[] rotateArray(int[] arr, int n, int k) {
        
        if(arr == null || n == 0) {
            return arr;
        } 
        
        if(k < 0) {
            k = n + k;
        }
        k = k % n;
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            res[(i + k) % n] = arr[i];
        }
        
        
        return res;
    }
}
