package com.zl.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
/**
 * ��Ϣ����
 * @author ����
 *
 */
public class MListener implements MessageListener{

	@Override
	public void onMessage(Message message) {
		try {
			System.out.println("Listemer�յ�����Ϣ��"+((TextMessage)message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
