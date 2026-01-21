import java.util.*;

public class Main {

    static void main() {

        List<Map.Entry<Integer, String>> data = new ArrayList<>();

        data.add(Map.entry(1930, "Uruguay"));
        data.add(Map.entry(1934, "Italy"));
        data.add(Map.entry(1938, "Italy"));
        data.add(Map.entry(1950, "Uruguay"));
        data.add(Map.entry(2006, "Italy"));
        data.add(Map.entry(2010, "Spain"));

        Map<String, List<Integer>> stringListMap = footWorldCup(data);

        System.out.println("\n");
        System.out.println(stringListMap);
    }

    public static Map<String, List<Integer>> footWorldCup(List<Map.Entry<Integer, String>> lf) {

        Comparator<Integer> descendingYears = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b.compareTo(a);
            }
        };

        Map<String, List<Integer>> listMap = new HashMap<>();

        for (int i = 0; i < lf.size(); i++) {
            String country = lf.get(i).getValue();

            if(!listMap.containsKey(country)){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(lf.get(i).getKey());
                listMap.put(country,list);
            }else{
                List<Integer> list = listMap.get(country);
                list.add(lf.get(i).getKey());
            }
        }

        //Usando o comparator para sortc
        for(List<Integer> years: listMap.values()){
            years.sort(Comparator.reverseOrder());
        }

        //Usando a minha declaraçao de comparator acima
//        for(List<Integer> years : listMap.values()){
//            years.sort(descendingYears);
//        }

        return listMap;
    }
}
