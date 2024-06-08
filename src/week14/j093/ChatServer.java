package week14.j093;

// SimpleChat Server

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class ChatServer {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(10001);
            System.out.println("Waiting Connections...");
            HashMap<String, PrintWriter> hm = new HashMap<>();
            while (true) {
                Socket sock = server.accept();
                ChatThread chatthread = new ChatThread(sock, hm);
                chatthread.start();
            } // while
        } catch (Exception e) {
            System.out.println(e);
        }
    } // main
}

class ChatThread extends Thread {
    private Socket sock;
    private String id;
    private BufferedReader br;
    private HashMap<String, PrintWriter> hm;
    private boolean initFlag = false;

    public ChatThread(Socket sock, HashMap<String, PrintWriter> hm) {
        this.sock = sock;
        this.hm = hm;
        try {
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
            br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            id = br.readLine();
            broadcast(id + " entered.");
            System.out.println("[Server log] " + id + " entered.");
            synchronized (hm) {
                hm.put(this.id, pw);
            }
            initFlag = true;
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void run() {
        try {
            String line = null;
            while ((line = br.readLine()) != null) {
                if (line.equals("/quit"))
                    break;
                if (line.indexOf("/to ") == 0) {
                    sendmsg(line);
                } else if (line.equals("/userlist")) {
                    showlist();
                } else {
                    broadcast(id + " : " + line);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            synchronized (hm) {
                hm.remove(id);
            }
            broadcast(id + " exited.");
            System.out.println("[Server log] " + id + " exited.");
            try {
                if (sock != null)
                    sock.close();
            } catch (Exception ex) {
            }
        }
    } // run

    public void sendmsg(String msg) {
        int start = msg.indexOf(" ") + 1;
        int end = msg.indexOf(" ", start);
        if (end != -1) {
            String to = msg.substring(start, end);
            String msg2 = msg.substring(end + 1);
            Object obj = hm.get(to);
            if (obj != null) {
                PrintWriter pw = (PrintWriter) obj;
                pw.println(id + "'s secret message: " + msg2);
                pw.flush();
            } // if
        }
    } // sendmsg

    public void broadcast(String msg) {
        synchronized (hm) {
            Collection<PrintWriter> collection = hm.values();
            Iterator<PrintWriter> iter = collection.iterator();
            while (iter.hasNext()) {
                PrintWriter pw = iter.next();
                pw.println(msg);
                pw.flush();
            }
        }
    } // broadcast

    public void showlist() {
        synchronized (hm) {
            PrintWriter pw = hm.get(id);
            if (pw != null) {
                pw.println("There are " + hm.size() + " users.");
                StringBuilder userList = new StringBuilder();
                for (String user : hm.keySet()) {
                    userList.append(user).append(", ");
                }
                // Remove the last comma and space
                if (userList.length() > 0) {
                    userList.setLength(userList.length() - 2);
                }
                pw.println(userList.toString());
                pw.flush();
            }
        }
    }
}
