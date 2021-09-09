package edu.act.moneytransfer.repositories;

import edu.act.moneytransfer.domains.Transfer;
import org.springframework.data.repository.CrudRepository;

public interface TransferRepository extends CrudRepository<Transfer, Long> {}
