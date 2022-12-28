import java.util.ArrayList;
import java.util.List;

public class TestLambda {
    public static void main(String[] args) {
        List<Integer> list =new ArrayList<>();
        list.add(0);
        Integer[] arr = list.stream().toArray(len -> new Integer[len]);
        System.out.printf("%s", arr);
        list.stream().toArray(Integer[]::new);
    }
}
