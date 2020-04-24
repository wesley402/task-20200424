// "static void main" must be defined in a public class.
public class Permutation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(permutate(arr, arr.length));
        
        arr = new int[] {1,2,3,4,6};
        System.out.println(permutate(arr, arr.length));

    }
    
    public static int permutate(int[] arr, int n) {
        if(arr == null || arr.length == 0 || n == 0) {
            return 1;
        }
        
        int min = 1, max = n;
        Set<Integer> set = new HashSet<>();
        for(int num : arr) {
            if(num < min || num > max) {
                return 0;
            }
            set.add(num);
        }
        
        if(set.size() != n) {
            return 0;
        }
        
        return 1;
        
    }
}
