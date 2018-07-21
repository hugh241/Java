package com.zl.activemq2;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
/**
 * ��Ϣ������-������
 * @author ����
 *
 */
public class JMSConsumer2 {
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
			destination = session.createTopic("FirstTopic1");
			messageConsumer = session.createConsumer(destination);
			messageConsumer.setMessageListener(new MListener2());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
