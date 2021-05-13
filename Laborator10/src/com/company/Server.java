package com.company;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class Server {

    public static int PORT = 5128;

    public Server() throws IOException {
        ServerSocket serverSock = null;
        try {
            serverSock = new ServerSocket(PORT);
            boolean flag = true;
            while (flag) {
                System.out.println("Waiting for a client ...");
                Socket sock = serverSock.accept();
                new ClientThread(sock).run();
            }
        } catch (IOException e) {
            System.err.println("Error: " + e);
        } finally {
            serverSock.close();
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server ();
    }
}