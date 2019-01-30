package com.capgemini.accountservice.receiver;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.exception.ListenerExecutionFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.capgemini.accountservice.resource.AccountResource;
import com.capgemini.transactionservice.app.entity.Transaction;

@Component
public class Receiver {

	@Autowired
	private AccountResource accountResource;
	
	@Bean
	public Queue queue() {
		return new Queue("updateBalance", false);
	}
	
	@RabbitListener(queues="updateBalance")
	public void updateCurrentBalance(Transaction transaction) throws ListenerExecutionFailedException{
		accountResource.updateBalance(transaction.getAccountNumber(), transaction.getCurrentBalance());
	}
	
}

