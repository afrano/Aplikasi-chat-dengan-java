/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasichat;

/**
 *
 * @author nano
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class chat {

    static void Client() throws IOException {
        String ip;
        BufferedReader cmb = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Masukkan IP Server : ");
        ip = cmb.readLine();
        Socket client = null;
        client = new Socket("" + ip, 8888);
        BufferedReader sin = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintStream sout = new PrintStream(client.getOutputStream());
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (true) {
            System.out.print("Client : ");
            s = stdin.readLine();
            sout.println(s);
            s = sin.readLine();
            System.out.print("Server : " + s + "\n");
            if (s.equalsIgnoreCase("Bye")) {
                break;
            }
        }
        stdin.close();
        sout.close();
        sin.close();
        client.close();
    }

    static void Server() throws IOException {
        ServerSocket server = null;
        Socket client = null;
        try {
            server = new ServerSocket(8888);
            System.out.println("Server telah online");
            client = server.accept();
            System.out.println("Client telah masuk dan bisa online");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        System.out.println("Silahkan chat");
        InputStream masuk = client.getInputStream();
        OutputStream keluar = client.getOutputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintStream out = new PrintStream(client.getOutputStream());
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String pesan;
        while (true) {
            pesan = in.readLine();
            if (pesan.equalsIgnoreCase("stop")) {
                out.println("sampai jumpa");
                break;
            }
            System.out.println("Client chat : " + pesan);
            System.out.print("Server : ");
            pesan = stdin.readLine();
            out.println(pesan);
        }
        server.close();
        client.close();
        in.close();
        out.close();
        stdin.close();
    }

    public static void main(String args[]) throws IOException {
        int pil;
        System.out.println("Masukkan Angka yang akan Anda Pilih");
        System.out.println("1. Server");
        System.out.println("2. Client");
        System.out.println("3. Keluar");
        System.out.println();
        System.out.println("Masukkan Pilihan : ");
        Scanner input = new Scanner(System.in);
        pil = Integer.parseInt(input.next());
        switch (pil) {
            case 1:
                Server();
                break;
            case 2:
                Client();
                break;
            case 3:
                System.out.println();
                System.out.println("Terima Kasih Telah Menggunakan Aplikasi Ini");
                break;
            default:
                System.out.println("Maaf Keyword Yang Anda Masukkan Salah");
                System.out.println("Silahkan Ulangi Lagi");
                break;
        }
    }
}