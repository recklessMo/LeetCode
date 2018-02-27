package com.recklessMo.rpc.util;

import org.apache.commons.lang.StringEscapeUtils;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Server {

    public static final String HOST = "127.0.0.1";
    public static final int PORT = 1988;

    private Selector selector = null;
    private ServerSocketChannel serverSocketChannel = null;

    public Server() {
    }

    public void init() throws Exception {
        selector = Selector.open();
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, serverSocketChannel.validOps(), null);
        serverSocketChannel.bind(new InetSocketAddress(HOST, PORT));
        System.out.println("server listening now !");
    }


    public void startLoop() throws Exception {
        while (true) {
            System.out.println("enter block waiting at port: " + PORT);
            int num = selector.select();
            System.out.println("get num: " + num);
            Set<SelectionKey> keySet = selector.selectedKeys();
            Iterator<SelectionKey> selectionKeyIterator = keySet.iterator();
            while (selectionKeyIterator.hasNext()) {
                SelectionKey key = selectionKeyIterator.next();
                System.out.println(key + " " +  key.isValid() + "-" + key.isAcceptable() + "-" + key.isReadable() + "-" + key.isWritable());
                if (!key.isValid()) {
                    continue;
                }
                if (key.isAcceptable()) {
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    if (socketChannel != null) {
                        socketChannel.configureBlocking(false);
                        System.out.println("get a connection: " + socketChannel);
                        socketChannel.register(selector, SelectionKey.OP_READ, null);
                    }
                }else if(key.isReadable()) {
                    try {
                        System.out.println("readable !");
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        ByteBuffer in = ByteBuffer.allocate(1000);
                        int n = socketChannel.read(in);
                        if(n != -1) {
                            in.flip();
                            socketChannel.write(in);
                        }else{
                            System.out.println("close");
                            socketChannel.close();
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                selectionKeyIterator.remove();
            }
        }
    }

    public void wakeUp() {
        System.out.println("wake up");
        selector.wakeup();
    }


    public static void main(String[] args) throws Exception {
//        Server server = new Server();
//        server.init();
//        new Thread(() -> {
//            try {
//                Thread.sleep(10000);
////                server.wakeUp();
//            } catch (Exception e) {
//
//            }
//        }).start();
//        server.startLoop();


        System.out.println(System.getProperty("os.name"));

        String a = "\udc37\ud801World";
        String b = "Hello World";
        System.out.println(StringEscapeUtils.unescapeJava(a));
        System.out.println(b);
        System.out.println(a.equals(b));
        System.out.println(a.length());


        String c = "胡鹏飞";
        System.out.println(c.getBytes().length);

        String d = "\ud801\udc37World";
        System.out.println(d);
        System.out.println(d.length());
        System.out.println(d.codePointAt(0));

    }


}
