package com.recklessMo.rpc.util;

import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.DefaultEventExecutor;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;

public class TestNetty {



    public static void main(String[] args){
        DefaultEventExecutor eventExecutor = new DefaultEventExecutor();
        Promise promise = eventExecutor.newPromise();
        promise.addListener(new GenericFutureListener<ChannelPromise>() {
            @Override
            public void operationComplete(ChannelPromise f) throws Exception {
                System.out.println(f);
            }
        });
        promise.setSuccess("ok");
    }

}
