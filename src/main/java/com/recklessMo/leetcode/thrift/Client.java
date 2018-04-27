package com.recklessMo.leetcode.thrift;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;


public class Client {


    public static void main(String[] args){

        System.out.println("client starting !");
        TTransport tTransport = null;
        try{
            tTransport = new TSocket("localhost", 8989, 30000);
            TProtocol protocol = new TBinaryProtocol(tTransport);
            tTransport.open();
            HelloWorldService.Client client = new HelloWorldService.Client(protocol);
            String result = client.sayHello("hello");
            System.out.println(result);
        }catch (Exception e){

        }finally {

        }
    }


}
