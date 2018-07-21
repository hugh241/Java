package com.zl.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * ��Ϣ������
 * @author ����
 *
 */
public class JMSProducer {
	
	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;
	private static final int SENDTIME = 10;
	
	public static void main(String[] args) {
		
		ConnectionFactory connectionFactory;//���ӹ���
		Connection connection = null;//����
		Session session;//�Ự ���ջ�����Ϣ���߳�
		Destination destination;//��ϢĿ�ĵ�
		MessageProducer messageProducer;//��Ϣ������
		
		//ʵ��������
		connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEURL);
		
		try {
			connection = connectionFactory.createConnection();//ͨ�����ӹ�����ȡ����
			connection.start();//��������
			session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);//�����Ự
			destination = session.createQueue("ACTIVEMQ1");//������Ϣ����
			messageProducer = session.createProducer(destination);//������Ϣ������
			sendMessage(session, messageProducer);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void sendMessage(Session session,MessageProducer messageProducer) throws JMSException {
		for(int i = 0;i < SENDTIME;i++) {
			TextMessage message = session.createTextMessage("ActiveMQ���͵���Ϣ"+i);
			System.out.println("��������Ϣ"+i);
			messageProducer.send(message);
		}
	}
}
