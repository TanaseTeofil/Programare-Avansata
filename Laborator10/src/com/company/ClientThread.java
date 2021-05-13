package com.company;

import java.io.BufferedReader;
import java.net.Socket;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class ClientThread extends Thread {

    private Socket sock;
    public ClientThread(Socket socket) {
        this.sock = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));

            String req = in.readLine();

            PrintWriter out = new PrintWriter(sock.getOutputStream());

            System.out.println("Client named " + req + " connected.");
            String raspuns = "Hello, " + req + "!";

            out.println(raspuns);
            out.flush();

            boolean flag = true;
            while(flag) {
                req = in.readLine();
                System.out.println("Recieved command: " + req);
                if(req.equals("exit")){
                    flag = false;
                    raspuns = "Server Stopped";
                }
                else {
                    raspuns = "Recieved command: " + req;
                }
                out.println(raspuns);
                out.flush();
            }

        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                sock.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}