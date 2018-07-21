package com.zl.activemq2;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
/**
 * 消息监听
 * @author 张龙
 *
 */
public class MListener2 implements MessageListener{

	@Override
	public void onMessage(Message message) {
		try {
			System.out.println("Listener2收到的消息："+((TextMessage)message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
