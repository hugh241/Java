package com.zl.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSConsumer {
	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;
	
	public static void main(String[] args) {
		
		ConnectionFactory connectionFactory;//���ӹ���
		Connection connection = null;//����
		Session session;//�Ự ���ջ�����Ϣ���߳�
		Destination destination;//��ϢĿ�ĵ�
		MessageConsumer messageConsumer;//��Ϣ������
		
		//ʵ��������
		connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEURL);
		
		try {
			connection = connectionFactory.createConnection();//ͨ�����ӹ�����ȡ����
			connection.start();//��������
			session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);//�����Ự
			destination = session.createQueue("ACTIVEMQ1");//������Ϣ����
			messageConsumer = session.createConsumer(destination);
			while (true) {
				TextMessage message = (TextMessage) messageConsumer.receive(100000);
				if(message != null) {
					System.out.println("���յ���Ϣ��"+message.getText());
				}else {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			if(connection != null) {
//				try {
//					connection.close();
//				} catch (JMSException e) {
//					e.printStackTrace();
//				}
//			}
		}
	}
}
