package com.demo.zmq.Server;

import org.zeromq.ZMQ;

public class App
{
    public static void main( String[] args ) throws InterruptedException
    {
    	ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket sender = context.socket(ZMQ.PUSH);
        sender.bind("tcp://*:5557");
        
	int i = 0;
        while (true)
	{
		System.out.println("msg "+i);           
		sender.send(("msg " + i).getBytes(),ZMQ.DONTWAIT);
		i++;
		Thread.sleep(3000);
        }
    }
}
