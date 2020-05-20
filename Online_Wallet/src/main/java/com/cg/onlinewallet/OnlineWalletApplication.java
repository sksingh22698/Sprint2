package com.cg.onlinewallet;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.onlinewallet.entities.WalletAccount;
import com.cg.onlinewallet.entities.WalletAccount.status;
import com.cg.onlinewallet.entities.WalletUser;
import com.cg.onlinewallet.entities.WalletUser.type;

@Transactional
@SpringBootApplication
public class OnlineWalletApplication implements CommandLineRunner{

	@Autowired
	EntityManager em;
	
	
	public static void main(String[] args) {
		SpringApplication.run(OnlineWalletApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception{
		
		
		WalletAccount wa1 = new WalletAccount(0.00,  status.active);
		WalletAccount wa2 = new WalletAccount(0.00,  status.non_active);
		em.persist(wa1);
		em.persist(wa2);
		WalletUser user1=new WalletUser("Vinay", "123", "876543", "email@abc.com",type.user,  wa1);
		WalletUser user2=new WalletUser("Singh", "123", "876543", "email@abc.com",type.user,  wa2);
		em.persist(user1);
		em.persist(user2);
		
		
	
	} 
	
	
}
