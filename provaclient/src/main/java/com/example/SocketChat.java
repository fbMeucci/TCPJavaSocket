package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketChat {
    private String hostname = null;
    private int port = 0;
    private Socket s = null;
    private InputStreamReader in = null;
    private BufferedReader br = null;
    private BufferedReader input = null;
    private PrintWriter pr = null;

    public SocketChat(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
        try {
            s = new Socket(hostname, port);
        } catch (UnknownHostException e) {
            System.out.println("Nome host sconosciuto");
        } catch (IOException e) {
            System.out.println("Errore nella connessione");
        }
    }

    public void inviaMessaggio(String msg) {
        try {
            pr = new PrintWriter(s.getOutputStream());
        } catch (IOException e) {
            System.out.println("Errore durante l'invio del messaggio");
        }
        pr.println(msg);
        pr.flush();
    }

    public String riceviMessaggio() {
        String str = null;
        try {
            in = new InputStreamReader(s.getInputStream());
        } catch (IOException e) {
            System.out.println("Errore durante la ricezione del messaggio");
        }
        br = new BufferedReader(in);
        try {
            str = br.readLine();
        } catch (IOException e) {
            System.out.println("Errore durante la lettura del messaggio");
        }
        return str;
    }

    public String leggiDaTastiera() {
        String str = null;
        input = new BufferedReader(new InputStreamReader(System.in));
        try {
            str = input.readLine();
        } catch (IOException e) {
            System.out.println("Errore nell'input del dato");
        }
        return str;
    }

    public String getHostname() {
        return hostname;
    }

    public int getPort() {
        return port;
    }

    public void chiudi() {
        try {
            s.close();
        } catch (IOException e) {
            System.out.println("Errore nella chiusura della socket");
        }
    }
}
