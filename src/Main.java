
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Double> myList = List.of(10d, 2d, 3d, 45d, 1d, 23d, 4d, 23d);

        Result<Double> myResult = findMinMax(myList);
        System.out.println("Max Value = " + myResult.max());
        System.out.println("Min Value = " + myResult.min());
    }

    public static <T extends Comparable<T>> Result<T> findMinMax(Collection<T> elements) {
        return findMinMax(elements, Comparable::compareTo);
    }

    public static <T> Result<T> findMinMax(Collection<T> elements, Comparator<T> comparator) {

        T min = elements.iterator().next();
        T max = elements.iterator().next();

        for (T element :
                elements) {
            if (comparator.compare(element, min) < 0) {
                min = element;
            } else if (comparator.compare(element, max) > 0) {
                max = element;
            }
        }
        return new Result<>(min, max);
    }
}