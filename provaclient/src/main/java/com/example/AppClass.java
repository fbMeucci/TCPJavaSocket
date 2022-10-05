package com.example;

public class AppClass {
    public static void main(String[] args) {
        SocketChat sc = new SocketChat("localhost", 3000);
        // Client invia messaggio al server
        sc.inviaMessaggio("Eccomi");

        // Client riceve messaggio dal server "Benvenuto dammi il tuo peso"
        System.out.println("Server -> " + sc.riceviMessaggio());

        // Client chiede in input da tastiera il peso e lo invia al server
        sc.inviaMessaggio(sc.leggiDaTastiera());

        // Client riceve messaggio dal server "Benvenuto dammi la tua altezza"
        System.out.println("Server -> " + sc.riceviMessaggio());

        // Client chiede in input da tastiera il peso e lo invia al server
        sc.inviaMessaggio(sc.leggiDaTastiera());

        // Client riceve il risultato dal server
        System.out.println("Server -> " + sc.riceviMessaggio());

        // Client invia al server messaggio "Grazie, ciao"
        sc.inviaMessaggio("Grazie, ciao");

    }
}
