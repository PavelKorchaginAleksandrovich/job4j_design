package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    String paramsLine = in.readLine();
                    if (paramsLine != null && !paramsLine.isEmpty()) {
                        int msgBegin = paramsLine.indexOf("msg=") + 4;
                        if (msgBegin != 3) {
                            int msgEnd = paramsLine.indexOf(" ", msgBegin);
                            msgEnd = msgEnd == -1 ? paramsLine.length() : msgEnd;
                            String msg = paramsLine.substring(msgBegin, msgEnd);
                            if (msg.equals("Exit")) {
                                server.close();
                            } else if (msg.equals("Hello")) {
                                out.write(msg.getBytes());
                            } else {
                                out.write("What".getBytes());
                            }
                        }
                    }
                    out.flush();
                }
            }
        } catch (IOException e) {
            LOG.error("Exception in EchoServer", e);
        }
    }
}
