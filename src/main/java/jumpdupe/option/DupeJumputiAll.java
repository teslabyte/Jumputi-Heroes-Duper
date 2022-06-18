package main.java.jumpdupe.option;

import main.java.jumpdupe.Handler;
import main.java.jumpdupe.network.ServerConnection;
import main.java.jumpdupe.Main;

public class DupeJumputiAll extends Thread{

    public void run(){
        long start = System.currentTimeMillis();
        ServerConnection serverConnection = new ServerConnection();
        serverConnection.setServerUrl(Main.url);
        serverConnection.request("/" + Handler.version + "/giftbox/receive_gift_all","POST");
        long end = System.currentTimeMillis();
        System.out.println("Took " + (end-start) + " milliseconds, response length " + serverConnection.getResponse().length());
    }
}
