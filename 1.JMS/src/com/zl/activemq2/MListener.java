package com.zl.activemq2;

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
			System.out.println("Listener�յ�����Ϣ��"+((TextMessage)message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
