package com.company;

import java.io.BufferedReader;
import java.net.Socket;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.UnknownHostException;


public class Client {

    String serverAddress = "127.0.0.1";

    int PORT = 5128;

    private Client() throws IOException {
        try (
                Socket sock = new Socket(serverAddress, PORT);
                PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
                BufferedReader in = new BufferedReader (new InputStreamReader(sock.getInputStream())) ) {

            Scanner scan = new Scanner(System.in);
            System.out.print("Please enter your name: ");

            String req = scan.nextLine();
            out.println(req);

            String response = in.readLine ();
            System.out.println(response);

            boolean flag = true;
            while(flag) {
                System.out.print(" > ");

                req = scan.nextLine();
                if(req.equals("exit")) {
                    flag = false;
                }
                out.println(req);
                response = in.readLine();

                System.out.println(response);
            }
        } catch (UnknownHostException e) {
            System.err.println("No server open for recieving " + e);
        }
    }
    public static void main (String[] args) {
        try {
            Client client = new Client();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}