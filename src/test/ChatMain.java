package test;

public class ChatMain {
    public static void main(String[] args) {
        ChatReceive chatReceive = new ChatReceive();
        ChatSender chatSender = new ChatSender();

        chatReceive.start();
        chatSender.start();
    }
}
