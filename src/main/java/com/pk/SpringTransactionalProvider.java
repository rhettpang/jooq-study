package com.pk;

import org.jooq.Transaction;
import org.jooq.TransactionContext;
import org.jooq.TransactionProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @author Created by pangkunkun on 2018/5/30.
 */
public class SpringTransactionalProvider implements TransactionProvider {

    private static final Logger log = LoggerFactory.getLogger(SpringTransactionalProvider.class);

    @Autowired
    private DataSourceTransactionManager dstm;

    public SpringTransactionalProvider(DataSourceTransactionManager dstm){
        this.dstm = dstm;
    }

    @Override
    public void begin(TransactionContext var1){
        log.info("begin transaction");

        TransactionStatus ts = dstm.getTransaction(new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_NESTED));
        var1.transaction(new SpringTransaction(ts));
    }

    @Override
    public void commit(TransactionContext var1) {
        log.info("commit transaction");

        dstm.commit(((SpringTransaction)var1.transaction()).ts);
    }

    @Override
    public void rollback(TransactionContext var1) {
        log.info("rollback transaction");

        dstm.rollback(((SpringTransaction)var1.transaction()).ts);
    }


    class SpringTransaction implements Transaction {
        final TransactionStatus ts;

        SpringTransaction(TransactionStatus ts){
            this.ts = ts;
        }
    }
}
