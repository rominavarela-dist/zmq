package com.demo.zmq.Client.services;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.zmq.Client.model.Status;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zeromq.ZMQ;

@Controller
@RequestMapping("/")
public class BaseServices {

	@Autowired
	private ServletContext context;
	private static final Logger log = Logger.getLogger(BaseServices.class);
	
	private static ZMQ.Context ZMQContext = ZMQ.context(1);
	private static ZMQ.Socket ZMQReceiver = ZMQContext.socket(ZMQ.PULL);
	
	@PostConstruct
	public void init() {
		log.info("init Demo Controller");
		ZMQContext = ZMQ.context(1);
		ZMQReceiver = ZMQContext.socket(ZMQ.PULL);
		ZMQReceiver.connect("tcp://localhost:5557");
	}

	@RequestMapping(value="/hello", method=RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Status hello(HttpServletRequest req, HttpServletResponse res)
	{
		ArrayList<String> msgList= new ArrayList<String>();
		try {
			while(true)
				msgList.add(new String(ZMQReceiver.recv(ZMQ.NOBLOCK)));
		} catch(Exception ex){}
		
		Status status = new Status();
		status.setStatus(Status.STATUS_OK);
		status.setMsg(msgList.toArray(new String[0]));        
		return status;
	}
	
	@PreDestroy
	public void cleanUp() throws Exception {
		ZMQReceiver.close();
	}
	
}

