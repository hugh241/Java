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
 * 消息生产者
 * @author 张龙
 *
 */
public class JMSProducer {
	
	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;
	private static final int SENDTIME = 10;
	
	public static void main(String[] args) {
		
		ConnectionFactory connectionFactory;//连接工厂
		Connection connection = null;//连接
		Session session;//会话 接收或发送消息的线程
		Destination destination;//消息目的地
		MessageProducer messageProducer;//消息生产者
		
		//实例化工厂
		connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEURL);
		
		try {
			connection = connectionFactory.createConnection();//通过连接工厂获取连接
			connection.start();//启动连接
			session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);//创建会话
			destination = session.createQueue("ACTIVEMQ1");//创建消息队列
			messageProducer = session.createProducer(destination);//创建消息生产者
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
			TextMessage message = session.createTextMessage("ActiveMQ发送的消息"+i);
			System.out.println("发送了消息"+i);
			messageProducer.send(message);
		}
	}
}
