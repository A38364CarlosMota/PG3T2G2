package T2;

import java.util.*;
import java.util.function.Supplier;

public class AlgorithUtils {

    static public <V, C extends Collection<V> > List<C> getSubsequences (Iterable<V> sequence, Comparator<V> compareValue,
                                                                       Supplier<C> supplierList) {
        List<C> resultado = new ArrayList<>();

        V b = null;
        C sublista = null;

        for (V a: sequence ) {
            if (b == null){
                sublista = supplierList.get(); //vai nos dar um novo C
                sublista.add(a);
                resultado.add(sublista);
                b = a;

            }
            else if(compareValue.compare(a, b) < 0) {
                sublista = supplierList.get(); //vai nos dar um novo C
                sublista.add(a);
                resultado.add(sublista);
                b = a;
            }
            else{
                sublista.add(a);
                b = a;
            }

        }

    return resultado;}

    public static void main(String[] args) {
        List<Integer> seq = Arrays.asList(10,20,20,30,12,13,8,1,2,3);

        Supplier<ArrayList<Integer>> s = new Supplier<ArrayList<Integer>>() {
            @Override
            public ArrayList<Integer> get() {
                return new ArrayList<>();
            }
        };

        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };

        List<ArrayList<Integer>> res = getSubsequences (seq, cmp, s);

        System.out.println(res);

        Supplier<TreeSet<Integer>> s2 = new Supplier<>() {
            @Override
            public TreeSet<Integer> get() {
                return new TreeSet<>();
            }
        };

        List<TreeSet<Integer>> res2 = getSubsequences (seq, cmp, s2);

        System.out.println(res2);

    }

}


