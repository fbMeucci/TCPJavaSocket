package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class App {
    public static void main(String[] args) throws Exception {
        InputStreamReader in = null;
        BufferedReader br = null;
        PrintWriter pr = null;
        float peso, altezza, bmi;

        ServerSocket ss = new ServerSocket(3000);
        System.out.println("Server in ascolto sulla porta 3000");
        Socket s = ss.accept();

        // Il server riceve dal client il messaggio "Eccomi""
        in = new InputStreamReader(s.getInputStream());
        br = new BufferedReader(in);
        System.out.println("Client -> " + br.readLine());

        // Il server invia messaggio al client "Benvenuto, dammi il tuo peso"
        pr = new PrintWriter(s.getOutputStream());
        pr.println("Benvenuto, dammi il tuo peso in Kg: ");
        pr.flush();

        // Il server riceve dal client il valore del peso"
        in = new InputStreamReader(s.getInputStream());
        br = new BufferedReader(in);
        peso = Float.parseFloat(br.readLine());

        // Il server invia messaggio al client "dammi l'altezza"
        pr = new PrintWriter(s.getOutputStream());
        pr.println("dammi l'altezza in metri: ");
        pr.flush();

        // Il server riceve dal client il valore dell'altezza"
        in = new InputStreamReader(s.getInputStream());
        br = new BufferedReader(in);
        altezza = Float.parseFloat(br.readLine());

        // Il server calcola il valore del BMI e lo invia al client"
        bmi = peso / (altezza * altezza);
        pr = new PrintWriter(s.getOutputStream());
        pr.println("Il tuo BMI è " + bmi);
        pr.flush();

        // Il server riceve dal client il messaggio finale"
        in = new InputStreamReader(s.getInputStream());
        br = new BufferedReader(in);
        System.out.println("Client -> " + br.readLine());

        s.close();
        ss.close();

    }
}
