package edu.act.moneytransfer.services;

import edu.act.moneytransfer.domains.Account;
import edu.act.moneytransfer.repositories.AccountRepository;
import edu.act.moneytransfer.utils.AgeCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AccountService {

    // creates 2 instances/object
    //    Person a = new Person("Biniam");
    //    Person b = new Person("Abebe");

    /**
     * https://en.wikipedia.org/wiki/Singleton_pattern
     * In software engineering, the singleton pattern is a software design pattern that restricts the instantiation
     * of a class to one "single" instance.
     * This is useful when exactly one object is needed to coordinate actions across the system.
     */
    // only 1 object/instance is created and it is shared => Singleton pattern

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {

        // validation
        int age = AgeCalculator.calculateAge(account.getDateOfBirth(), LocalDate.now());

        if (age > 15) {
            return accountRepository.save(account);
        } else {
            System.out.println("Sorry. User under the age of 15 years cannot register.");
            return null;
        }
    }

    public Iterable<Account> allAccounts() {
        return accountRepository.findAll();
    }
}
