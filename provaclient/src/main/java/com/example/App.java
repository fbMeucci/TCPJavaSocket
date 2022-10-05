package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

// CLIENT
public class App {

    public static void main(String[] args) throws Exception {
        String strServer = null, strClient = null;
        InputStreamReader in = null;
        BufferedReader br = null, input = null;
        PrintWriter pr = null;

        Socket s = new Socket("localhost", 3000);
        pr = new PrintWriter(s.getOutputStream());

        // Client invia messaggio al server
        pr.println("Eccomi");
        pr.flush();

        // Client riceve messaggio dal server "Benvenuto dammi il tuo peso"
        in = new InputStreamReader(s.getInputStream());
        br = new BufferedReader(in);
        strServer = br.readLine();
        System.out.println("Server -> " + strServer);

        // Client chiede in input da tastiera il peso e lo invia al server
        input = new BufferedReader(new InputStreamReader(System.in));
        strClient = input.readLine();
        pr = new PrintWriter(s.getOutputStream());
        pr.println(strClient);
        pr.flush();

        // Client riceve messaggio dal server "Benvenuto dammi la tua altezza"
        in = new InputStreamReader(s.getInputStream());
        br = new BufferedReader(in);
        strServer = br.readLine();
        System.out.println("Server -> " + strServer);

        // Client chiede in input da tastiera il peso e lo invia al server
        input = new BufferedReader(new InputStreamReader(System.in));
        strClient = input.readLine();
        pr = new PrintWriter(s.getOutputStream());
        pr.println(strClient);
        pr.flush();

        // Client riceve il risultato dal server
        in = new InputStreamReader(s.getInputStream());
        br = new BufferedReader(in);
        strServer = br.readLine();
        System.out.println("Server -> " + strServer);

        // Client invia al server messaggio "Grazie, ciao"
        pr.println("Grazie, ciao");
        pr.flush();

        s.close();
    }
}
