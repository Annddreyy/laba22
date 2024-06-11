import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        User user1 = new User("Petrov P. P.", 2001);
        User user2 = new User("Ivanov I. I.", 2006);

        Group group1 = new Group("Group 1");
        Group group2 = new Group("Group 2");
        Group group3 = new Group("Group 3");
        Group group4 = new Group("Group 4");

        group1.subscribe(user1);
        group2.subscribe(user1);
        group3.subscribe(user1);

        group1.subscribe(user2);
        group2.subscribe(user2);
        group3.subscribe(user2);
        group4.subscribe(user2);

        group1.notifyObservers("Message 1");
        group2.notifyObservers("Message 2");
        group3.notifyObservers("Message 3");
        group4.notifyObservers("Message 4");
    }
}

class Group implements Notifier {
    String title;
    List<Observer> users = new ArrayList<>();

    public Group(String title) {
        this.title = title;
    }

    public void subscribe(Observer user) {
        users.add(user);
    }
    public void unsubscribe(Observer user) {
        users.remove(user);
    }

    public void notifyObservers(String message){
        for (Observer user: users) {
            user.getMessage(message);
        }
    }
}

interface Notifier {
    void notifyObservers(String message);
    void subscribe(Observer user);
    void unsubscribe(Observer user);
}

class User implements Observer {
    String FIO;
    int year;

    public User(String FIO, int year){
        this.FIO = FIO;
        this.year = year;
    }

    public void getMessage(String message){
        System.out.printf("Пользователь %s получил сообщение: %s\n", FIO, message);
    }
}

interface Observer {
    void getMessage(String message);
}