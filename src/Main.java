import esinf.Message;
import esinf.Server;

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

        LinkedList<Integer> series = new LinkedList<>();
        series.add(2);
        series.add(4);
        series.add(3);
        series.add(7);
        series.add(8);
        series.add(10);

        System.out.println("\n");
        System.out.println(series);

        LinkedList<Integer> newSeries = calcMMS(series, 3);
        System.out.println(newSeries);

        String[] valid = {
                "<body>", "<h1>", "</h1>", "<p>", "<a>", "</a>", "</p>", "</body>"
        };

        String[] invalid = {
                "<body>", "<h1>", "</h1>", "<p>", "<a>", "</p>", "</a>", "</p>", "<body>"
        };

        System.out.println(XHTMLValidator(valid));    // true
        System.out.println(XHTMLValidator(invalid));  // false

        //Deque example
        Deque<String> deque = new LinkedList<>();

        deque.push("A");
        deque.push("B");
        deque.push("C");
        deque.push("D");
        deque.push("E");
        deque.push("F");

        System.out.println(deque);
        for (String s : deque) {
            System.out.println(s);
        }

        Message m1 = new Message(
                "alice@mail.com",
                Set.of("bob@mail.com", "carol@mail.com"),
                "Meeting",
                "Let's meet"
        );

        Message m2 = new Message(
                "alice@mail.com",
                Set.of("bob@mail.com"),
                "Reminder",
                "Don't forget"
        );

        Message m3 = new Message(
                "alice@mail.com",
                Set.of("dave@mail.com"),
                "Info",
                "FYI"
        );

        Message m4 = new Message(
                "bob@mail.com",
                Set.of("alice@mail.com"),
                "Re",
                "Reply"
        );

        Message m5 = new Message(
                "carol@mail.com",
                Set.of("alice@mail.com", "bob@mail.com", "dave@mail.com"),
                "Party",
                "You're invited"
        );

        Message m6 = new Message(
                "dave@mail.com",
                Set.of("bob@mail.com"),
                "Question",
                "Quick question"
        );

        Message m7 = new Message(
                "alice@mail.com",
                Set.of("bob@mail.com", "carol@mail.com"),
                "Follow-up",
                "Another mail"
        );

        // Criar servidor e colocar mensagens na Outbox
        Server server = new Server();
        server.setOutbox(List.of(m1, m2, m3, m4, m5, m6, m7));

        Map<String, Map<String, Integer>> result = server.NumberMessagesSent();

        for (String sender : result.keySet()) {
            System.out.println("Sender: " + sender);

            for (Map.Entry<String, Integer> entry :
                    result.get(sender).entrySet()) {

                System.out.println("  To " + entry.getKey()
                        + " -> " + entry.getValue() + " messages");
            }
        }

    }

    /**
     * Validates if the given array of XHTML tags is properly nested.
     * It works by using a stack (implemented with a LinkedList) to keep track of opening tags.
     * When a closing tag is encountered, it checks if it matches the most recent opening tag.
     * On this case, the opening tag is popped from the stack. If there is a mismatch or if a closing tag is found when the stack is empty,
     * the function returns false. At the end, if the stack is empty, it means all tags were properly nested.
     *
     * @param tags An array of strings representing XHTML tags.
     * @return true if the tags are properly nested, false otherwise.
     */
    public static boolean XHTMLValidator(String[] tags) {

        LinkedList<String> list = new LinkedList<>();

        for (String tag : tags) {

            if (!tag.startsWith("</")) {
                list.push(tag);
            } else {
                if (list.isEmpty()) {
                    return false;
                }

                String openTag = list.pop();
                String openName = openTag.substring(1, openTag.length() - 1);
                String closeName = tag.substring(2, tag.length() - 1);

                if (!openName.equals(closeName)) {
                    return false;
                }

            }

        }

        return list.isEmpty();
    }

    public static Map<String, List<Integer>> footWorldCup(List<Map.Entry<Integer, String>> lf) {

        Map<String, List<Integer>> listMap = new HashMap<>();

        for (int i = 0; i < lf.size(); i++) {
            String country = lf.get(i).getValue();

            if (!listMap.containsKey(country)) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(lf.get(i).getKey());
                listMap.put(country, list);
            } else {
                List<Integer> list = listMap.get(country);
                list.add(lf.get(i).getKey());
            }
        }
        for (List<Integer> years : listMap.values()) {
            years.sort(Comparator.reverseOrder());
        }


        return listMap;
    }

    public static LinkedList<Integer> calcMMS(LinkedList<Integer> serie, Integer period) {

        LinkedList<Integer> averageList = new LinkedList<>();


        for (int i = 0; i < serie.size(); i++) {
            System.out.println("I: " + i);
            if (i >= period - 1) {
                int sum = 0;
                for (int j = i - period + 1; j <= i; j++) {
                    System.out.println("j: " + j);
                    sum += serie.get(j);
                }
                averageList.add(sum / period);
            } else {
                averageList.add(0);
            }
        }

        return averageList;

    }
}


