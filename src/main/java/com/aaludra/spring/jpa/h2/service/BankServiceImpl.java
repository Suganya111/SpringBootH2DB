package com.aaludra.spring.jpa.h2.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaludra.spring.jpa.h2.model.Bank_Acc;
import com.aaludra.spring.jpa.h2.repository.BankDao;
@Service
@Transactional
public class BankServiceImpl implements BankService{
	@Autowired
	private BankDao bankdao;
	@Override
	public Bank_Acc createBank_Acc(Bank_Acc bank) {
		// TODO Auto-generated method stub
		return bankdao.save(bank);
	}

	@Override
	public Bank_Acc updateBank_Acc(Bank_Acc bank) {
		Optional<Bank_Acc> bankDb=this.bankdao.findById(bank.getId());
		if(bankDb.isPresent()) {
			Bank_Acc bankUpdate=bankDb.get();
			bankUpdate.setId(bank.getId());
			bankUpdate.setName(bank.getName());
			bankUpdate.setAcc_no(bank.getAcc_no());
			bankUpdate.setBalance(bank.getBalance());
			bankUpdate.setJoindate(bank.getJoindate());
			bankUpdate.setAcc_type(bank.getAcc_type());
			bankdao.save(bankUpdate);
			return bankUpdate;
			
		}
		return null;

	}

	@Override
	public List<Bank_Acc> getAllBank_Acc() {
		// TODO Auto-generated method stub
		return this.bankdao.findAll();
	}

	@Override
	public Bank_Acc getBank_AccById(long bankId) {
		// TODO Auto-generated method stub
		Optional<Bank_Acc> bankDb=this.bankdao.findById(bankId);
		if(bankDb.isPresent()) {
			return bankDb.get();	
		}
		return null;

	}

	@Override
	public void deleteBank_Acc(long bankId) {
		Optional<Bank_Acc> bankDb=this.bankdao.findById(bankId);
		if(bankDb.isPresent()) {
			this.bankdao.delete(bankDb.get());	
		}
		

	}

}
