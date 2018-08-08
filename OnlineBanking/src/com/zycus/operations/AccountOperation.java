package com.zycus.operations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.zycus.db.dao.AccountDao;
import com.zycus.pojo.accounts.Account;
import com.zycus.pojo.cards.Card;

public class AccountOperation {
	private static final Long ACCOUNT_GENERATOR = 1234567654321L;
	private static final Double OPENING_AMOUNT = 10000D;
	
	public static void createAccount(String accountHolder, String accountType) {
		Date date = new Date();
		Long primaryKey = System.currentTimeMillis() / 100;
		Long accountNumber = primaryKey + ACCOUNT_GENERATOR;
		List <Card> allCards = new ArrayList<>();
		
		Account account = new Account(primaryKey, accountNumber, accountHolder, accountType, OPENING_AMOUNT, date.getTime(), allCards);
		AccountDao.insert(account);
	}
}
