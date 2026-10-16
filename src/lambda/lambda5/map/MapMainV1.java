package lambda.lambda5.map;

import java.util.ArrayList;
import java.util.List;

public class MapMainV1 {
    public static void main(String[] args) {

        List<String> list = List.of("1", "12", "123", "1234");

        //문자열을 숫자로 변환
        List<Integer> numbers = mapStringToInteger(list);
        System.out.println("numbers = " + numbers);

        //문자열의 길이로 변환
        List<Integer> lengths = mapStringToLength(list);
        System.out.println("lengths = " + lengths);
    }

    private static List<Integer> mapStringToInteger(List<String> list) {
        List<Integer> toNumbers = new ArrayList<>();
        for (String s : list) {
            toNumbers.add(Integer.valueOf(s));
        }
        return toNumbers;
    }

    private static List<Integer> mapStringToLength(List<String> list) {
        List<Integer> lengths = new ArrayList<>();
        for (String s : list) {
            lengths.add(s.length());
        }
        return lengths;
    }
}
