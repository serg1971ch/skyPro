package ru.otus.hw_28_data_jdbc.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionWrapperService {
    @Transactional
    public void doInTransaction(Runnable runnable) {
        runnable.run();
    }
}
