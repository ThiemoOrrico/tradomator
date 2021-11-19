package com.tradomator.repo;

import com.tradomator.model.Wallet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletRepo extends MongoRepository<Wallet, String> {

}
