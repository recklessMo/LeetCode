package com.recklessMo.leetcode.thrift;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;

public class Server {

    public static void main(String[] args) throws Exception{
        System.out.println("server starting ！");
        TProcessor tProcessor = new HelloWorldService.Processor<HelloWorldService.Iface>(new HelloWorldServiceImpl());
        TServerSocket tServerSocket = new TServerSocket(8989);
        TServer.Args arg = new TServer.Args(tServerSocket);
        arg.processor(tProcessor);
        arg.protocolFactory(new TBinaryProtocol.Factory());
        TServer server = new TSimpleServer(arg);
        server.serve();
    }
}
