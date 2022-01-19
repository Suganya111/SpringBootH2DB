package com.aaludra.spring.jpa.h2.service;

import java.util.List;


import com.aaludra.spring.jpa.h2.model.Bank_Acc;

public interface BankService {
	Bank_Acc createBank_Acc(Bank_Acc bank);
	Bank_Acc updateBank_Acc(Bank_Acc bank);
	List<Bank_Acc> getAllBank_Acc();
	Bank_Acc getBank_AccById(long bankId);
	void deleteBank_Acc(long id);

}
