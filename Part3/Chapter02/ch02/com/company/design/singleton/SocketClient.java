package com.company.design.singleton;

public class SocketClient {

    private static SocketClient socketClient;

    private SocketClient(){

    }

    // 최초 한번만 생성
    public static SocketClient getInstance(){
        if(socketClient == null){
            socketClient = new SocketClient();
        }
        return socketClient;
    }

    public void connect(){
        System.out.println("connect");
    }
}
