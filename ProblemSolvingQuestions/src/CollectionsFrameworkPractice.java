import java.util.*;
import java.util.stream.Collectors;

public class CollectionsFrameworkPractice {
    public static void main(String[] args) {
        List<Integer> arr = List.of(1, 2, 3, 4, 5, 6, 2, 8, 9);
        System.out.println(arr.stream().allMatch(num -> num % 2 == 0));
        System.out.println(arr.stream().anyMatch(num -> num % 2 == 0));
        System.out.println(arr.stream().distinct().count());
        System.out.println();
        arr.parallelStream().filter(num -> num % 2 == 0).forEach(System.out::println);
        
        arr.stream().filter(num -> num % 2 == 0).forEach(System.out::println);
        List<Integer> arr2 = arr.parallelStream().filter(num -> num % 2 == 0).collect(Collectors.toList());
        arr2.stream().forEach(System.out::println);

        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 2, 9};
        System.out.println(Arrays.stream(arr1).allMatch(num -> num % 2 == 0));
        System.out.println(Arrays.stream(arr1).anyMatch(num -> num % 2 == 0));
        System.out.println(Arrays.stream(arr1).distinct().count());
        Arrays.stream(arr1).filter(num -> num % 2 == 0).forEach(System.out::println);
    }
}
