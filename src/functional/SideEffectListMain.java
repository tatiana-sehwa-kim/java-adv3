package functional;

import java.util.ArrayList;
import java.util.List;

public class SideEffectListMain {
    public static void main(String[] args) {

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("apple");     // apple -> apple_complete
        list1.add("banana");    // banana -> banana_complete

        System.out.println("before list1 = " + list1);
        changeList1(list1);
        System.out.println("after list1 = " + list1);

        List<String> list2 = new ArrayList<>();
        list2.add("apple");
        list2.add("banana");

        System.out.println("before list2 = " + list2);
        List<String> result = changeList2(list2);
        System.out.println("after list2 = " + list2);
        System.out.println("result = " + result);

    }

    private static void changeList1(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + "_complete");
        }
    }

    private static List<String> changeList2(List<String> list2) {
        ArrayList<String> newList = new ArrayList<>();
        for (String s : list2) {
            newList.add(s + "_complete");
        }
        return newList;
    }
}

//    before list1 = [apple, banana]
//    after list1 = [apple_complete, banana_complete]
//    before list2 = [apple, banana]
//    after list2 = [apple, banana]
//    result = [apple_complete, banana_complete]

//    changeList1 함수는 리스트 원본을 직접 변경함으로써 부수 효과를 일으킨다.
//    반면 changeList2 함수는 새로운 리스트를 생성해서 반환함으로써, 원본 리스트를 변경하지 않는다.
//    함수형 프로그래밍에서는 changeList2 와 같은 방식이 권장된다.