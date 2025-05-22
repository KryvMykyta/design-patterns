package hw17.task17_3_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatMediator {
    private Map<String, User> users = new HashMap<>();
    private Map<String, List<User>> groups = new HashMap<>();

    public void registerUser(User user, String group) {
        users.put(user.getUserId(), user);
        groups.computeIfAbsent(group, k -> new ArrayList<>()).add(user);
    }

    public void sendMessageAll(String message, String userFrom) {
        for (User user : users.values()) {
            if (!user.getUserId().equals(userFrom)) {
                user.receiveMessage(message, userFrom);
            }
        }
    }

    public void sendMessage(String message, String userFrom, String userTo) {
        User recipient = users.get(userTo);
        if (recipient != null) {
            recipient.receiveMessage(message, userFrom);
        } else {
            System.out.println("User " + userTo + " not found.");
        }
    }

    public void sendMessageToGroup(String message, String userFrom, String group) {
        List<User> groupMembers = groups.get(group);
        if (groupMembers != null) {
            for (User user : groupMembers) {
                if (!user.getUserId().equals(userFrom)) {
                    user.receiveMessage(message, userFrom);
                }
            }
        } else {
            System.out.println("Group " + group + " not found.");
        }
    }
}