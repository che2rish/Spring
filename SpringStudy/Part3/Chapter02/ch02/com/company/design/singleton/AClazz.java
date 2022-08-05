package com.company.design.singleton;

public class AClazz {

    private SocketClient socketClient;

    public AClazz(){
        // default생성자를 막아놔서 new SocketClient() 사용 X
        this.socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient(){
        return this.socketClient;
    }
}
