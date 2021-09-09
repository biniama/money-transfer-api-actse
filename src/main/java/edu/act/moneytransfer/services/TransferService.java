package edu.act.moneytransfer.services;

import edu.act.moneytransfer.domains.Account;
import edu.act.moneytransfer.domains.Transfer;
import edu.act.moneytransfer.dto.TransferRequest;
import edu.act.moneytransfer.repositories.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransferRepository transferRepository;

    public Transfer transferMoney(TransferRequest transferRequest) throws Exception {

        Account senderAccount = accountService.getAccountById(transferRequest.getSenderId());

        if (senderAccount == null) {
            throw new Exception();
        }

        Account receiverAccount = accountService.getAccountById(transferRequest.getReceiverId());

        if (receiverAccount == null) {
            throw new Exception();
        }

        if (transferRequest.getSenderId().equals(transferRequest.getReceiverId())) {
            throw new Exception();
        }

        if (senderAccount.getBalance() >= transferRequest.getAmount()) {
            // logic
            Double newSenderBalance = senderAccount.getBalance() - transferRequest.getAmount();
            accountService.updateBalance(senderAccount, newSenderBalance);

            Double newReceiverBalance = receiverAccount.getBalance() + transferRequest.getAmount();
            accountService.updateBalance(receiverAccount, newReceiverBalance);

            Transfer transfer = Transfer.builder()
                    .senderAccount(senderAccount)
                    .receiverAccount(receiverAccount)
                    .amount(transferRequest.getAmount())
                    .reason(transferRequest.getReason())
                    .status("SUCCESSFUL")
                    .build();

            transferRepository.save(transfer);
            return transfer;

        } else {
            throw new Exception();
        }

    }

    public Iterable<Transfer> getAllTransfers() {

        return transferRepository.findAll();
    }
}
