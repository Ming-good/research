package org.netty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class main {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8080); // IP주소, 포트번호

//        2) 데이터 송수신을 위한 input/output 스트림 생성
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
        PrintWriter out = new PrintWriter(socket.getOutputStream( ));
//        3) output 스트림을 통한 데이터 송신 (클라이언트 → 서버)
        String outputMessage = "LoVE";
        out.write(outputMessage);
        out.flush();

//        4) input 스트림을 통한 데이터 수신 (서버 → 클라이언트)
        char[] buffer = new char[1024];
        int bytesRead = in.read(buffer);
        if (bytesRead != -1) {
            String inputMessage = new String(buffer, 0, bytesRead);
            System.out.println("응답: " + inputMessage);
        }


//        5) 통신 종료
        socket.close( );

    }
}
