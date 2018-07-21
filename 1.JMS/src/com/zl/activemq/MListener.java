package com.zl.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
/**
 * 消息监听
 * @author 张龙
 *
 */
public class MListener implements MessageListener{

	@Override
	public void onMessage(Message message) {
		try {
			System.out.println("Listemer收到的消息："+((TextMessage)message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
