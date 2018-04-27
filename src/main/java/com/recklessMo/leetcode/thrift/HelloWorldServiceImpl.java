package com.recklessMo.leetcode.thrift;

import org.apache.thrift.TException;

public class HelloWorldServiceImpl implements HelloWorldService.Iface{

    @Override
    public String sayHello(String username) throws TException {
        return "hello thrift !";
    }
}
