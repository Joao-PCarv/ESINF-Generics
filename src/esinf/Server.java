package esinf;

import java.util.*;

public class Server {

    private List<Message> Inbox;
    private List<Message> Outbox;

    public List<Message> getInbox() {
        return Inbox;
    }

    public void setInbox(List<Message> inbox) {
        Inbox = inbox;
    }

    public List<Message> getOutbox() {
        return Outbox;
    }

    public void setOutbox(List<Message> outbox) {
        Outbox = outbox;
    }

    public Map<String, Map<String, Integer>> NumberMessagesSent() {

        Map<String, Map<String, Integer>> map = new HashMap<>();
        Map<String, Integer> receiverCount;

        for (Message m : Outbox) {
            String sender = m.getSenderEmail();

            if (!map.containsKey(sender)) {
                receiverCount = new HashMap<>();
                map.put(sender, receiverCount);
            } else {
                receiverCount = map.get(sender);
            }

            for (String receiver : m.getRecipientList()) {
                if (!receiverCount.containsKey(receiver)) {
                    receiverCount.put(receiver, 1);
                } else {
                    receiverCount.replace(receiver, receiverCount.get(receiver) + 1);
                }
            }
        }
        return map;
    }


}
