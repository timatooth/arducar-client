package com.timatooth.carclient;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tim
 */
public class CarConnection {

    private final String host;
    private final Integer port;
    private Socket socket;
    private BufferedOutputStream out;
    private BufferedInputStream in;

    public CarConnection(String host, Integer port) {
        this.host = host;
        this.port = port;
    }

    public void connect() throws IOException {
        socket = new Socket(host, port);
        out = new BufferedOutputStream(socket.getOutputStream());
        in = new BufferedInputStream(socket.getInputStream());

    }

    public void sendBytes(byte[] b) throws IOException {
        System.out.println("Writing " + b.length + " bytes.");
        out.write(b);
        out.flush();
    }

    public void sendByte(byte b) throws IOException {
        out.write(b);
        out.flush();
    }

    public void send(String s) throws IOException {
        out.write(s.getBytes());
        out.flush();
    }

    public void disconnect() {
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(CarConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
