package com.sandy.user.center.config;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.MessageListener;
import javax.naming.InitialContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;

import com.sandy.user.center.jms.SolCachingConnectionFactory;
import com.solacesystems.jcsmp.TextMessage;
import com.solacesystems.jms.SolConnectionFactory;
import com.solacesystems.jms.SolJmsUtility;
import com.solacesystems.jms.SupportedProperty;

@Configuration
@ConfigurationProperties("solace.jms")
@ConditionalOnProperty(value = "solace.jms.enabled", havingValue = "true")
public class SolacePubConfig {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	String host;
	String msgVpn;
	String clientUserName;
	String clientPassword;
	
	private SolCachingConnectionFactory cachingConnectionFactory;
	
    @Bean("solConnectionFactory")
    public SolConnectionFactory connectionFactory() throws Exception {
        Properties env = new Properties();
        env.put(InitialContext.INITIAL_CONTEXT_FACTORY, "com.solacesystems.jndi.SolJNDIInitialContextFactory");
        env.put(InitialContext.PROVIDER_URL, host);
        env.put(SupportedProperty.SOLACE_JMS_VPN, msgVpn);
        env.put(InitialContext.SECURITY_PRINCIPAL, clientUserName);
        env.put(InitialContext.SECURITY_CREDENTIALS, clientPassword);
        return SolJmsUtility.createConnectionFactory(env);
//        SolConnectionFactoryImpl sdf = new SolConnectionFactoryImpl();
//        sdf.setHost(host);	
//        sdf.setVPN(msgVpn);
//        sdf.setUsername(clientUserName);
//        sdf.setPassword(clientPassword);
//        return sdf;
        //return this.connectionFactory;
    }

    @Order
    //@Bean("solCachingConnectionFactory")
    public SolCachingConnectionFactory cachingConnectionFactory(SolConnectionFactory connectionFactory) throws Exception {
    	SolCachingConnectionFactory cachingConnectionFactory = new SolCachingConnectionFactory(connectionFactory);
        cachingConnectionFactory.setSessionCacheSize(10);
        return cachingConnectionFactory;
    }

    @Bean("solJmsTemplate")
    public JmsTemplate pubJmsTemplate(SolConnectionFactory connectionFactory) {
    	this.cachingConnectionFactory = new SolCachingConnectionFactory(connectionFactory);
        cachingConnectionFactory.setSessionCacheSize(10);
    	
        JmsTemplate jmsTemplate = new JmsTemplate(cachingConnectionFactory);
        jmsTemplate.setPubSubDomain(true);
        jmsTemplate.setExplicitQosEnabled(true);
        jmsTemplate.setDeliveryPersistent(true);
        jmsTemplate.setDefaultDestinationName("gjghjgjj");
        return jmsTemplate;
    }
    
    @Bean
    public MessageListener messageListener() {
        return message -> {
            try {
            	logger.info("Received message " + ((TextMessage) message).getText() + " on destination: " + message.getJMSDestination().toString());
            } catch (JMSException ex) {
                throw new RuntimeException(ex);
            }
        };
    }

    @Order
    @Bean
    public MessageListenerContainer messageListenerContainer(MessageListener messageListener) {
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory(cachingConnectionFactory);
        container.setDestinationName("test");
        container.setMessageListener(messageListener);
        return container;
    }
    
    public void setHost(String host) {
		this.host = host;
	}
	public void setMsgVpn(String msgVpn) {
		this.msgVpn = msgVpn;
	}
	public void setClientUserName(String clientUserName) {
		this.clientUserName = clientUserName;
	}
	public void setClientPassword(String clientPassword) {
		this.clientPassword = clientPassword;
	}
}
