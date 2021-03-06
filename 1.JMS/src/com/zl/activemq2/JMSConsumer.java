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
 * 消息消费者-订阅者
 * @author 张龙
 *
 */
public class JMSConsumer {
	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;
	
	public static void main(String[] args) {
		
		ConnectionFactory connectionFactory;//连接工厂
		Connection connection = null;//连接
		Session session;//会话 接收或发送消息的线程
		Destination destination;//消息目的地
		MessageConsumer messageConsumer;//消息消费者
		
		//实例化工厂
		connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEURL);
		
		try {
			connection = connectionFactory.createConnection();//通过连接工厂获取连接
			connection.start();//启动连接
			session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);//创建会话
			destination = session.createTopic("FirstTopic1");
			messageConsumer = session.createConsumer(destination);
			messageConsumer.setMessageListener(new MListener());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
