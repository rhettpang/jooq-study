package com.pk;

import com.pk.db.gen.UserInfo;
import com.pk.db.gen.tables.records.UserRecord;
import com.zaxxer.hikari.HikariDataSource;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.MappedSchema;
import org.jooq.conf.RenderMapping;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

import static com.pk.db.gen.tables.User.USER;

/**
 * @author Created by pangkunkun on 2018/5/31.
 */
@Component
public class JooqClient {

    private static final String DEFAULT_DB = "jooqdb";

    private DataSource dataSource;

    public DSLContext getDSLContent(String dbName){
        Settings settings = new Settings();
        settings.withRenderSchema(true)
                .withRenderMapping(
                        new RenderMapping()
                                .withSchemata(
                                        new MappedSchema()
                                                //jooq生成代码时的db
                                                .withInput(DEFAULT_DB)
                                                //现在要使用的db
                                                .withOutput(dbName)));
        Configuration conf = new DefaultConfiguration();
        TransactionAwareDataSourceProxy proxy = new TransactionAwareDataSourceProxy(dataSource);
        DataSourceTransactionManager txMgr =  new DataSourceTransactionManager(dataSource);
        conf.set(new DataSourceConnectionProvider(proxy))
                .set(new SpringTransactionalProvider(txMgr))
                .set(settings)
                .set(SQLDialect.MYSQL);
        return DSL.using(conf);
    }

    private UserInfo recordToUserInfo(UserRecord record){
        return new UserInfo(
                record.getId(),
                record.getName(),
                record.getPassword(),
                record.getSex(),
                record.getCreated());
    }

    public List<UserInfo> getUsers(){
        List<UserRecord> records =  getDSLContent(DEFAULT_DB).selectFrom(USER).fetch();
        List<UserInfo> userInfos = new ArrayList<>();
        for (UserRecord record: records){
            userInfos.add(recordToUserInfo(record));
        }
        return userInfos;
    }

    public void updateUsers(){
        getDSLContent(DEFAULT_DB).transaction(configuration -> {
            for (int i = 0; i < 3; i++){
                if (i == 2){
                    int j = i/0;
                }
                getDSLContent(DEFAULT_DB).update(USER).set(USER.PASSWORD,(i+3)+"").execute();
            }
        });

    }

    public JooqClient(){}

    public JooqClient(String dbUrl,String userName, String password, int maxPoolSize) throws Exception{
        HikariDataSource hds = new HikariDataSource();
        hds.setDriverClassName("com.mysql.jdbc.Driver");
        hds.setJdbcUrl(dbUrl);
        hds.setUsername(userName);
        hds.setPassword(password);
        hds.setMaximumPoolSize(maxPoolSize);
        dataSource = hds;
    }

}
