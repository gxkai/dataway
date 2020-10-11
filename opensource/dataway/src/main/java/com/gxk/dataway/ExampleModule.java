package com.gxk.dataway;

import net.hasor.core.ApiBinder;
import net.hasor.core.DimModule;
import net.hasor.dataway.authorization.AuthorizationType;
import net.hasor.dataway.spi.AuthorizationChainSpi;
import net.hasor.db.JdbcModule;
import net.hasor.db.Level;
import net.hasor.spring.SpringModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Set;

@DimModule
@Component
public class ExampleModule implements SpringModule {
    @Autowired
    private DataSource dataSource = null;

    public void loadModule(ApiBinder apiBinder) throws Throwable {
        // .DataSource form Spring boot into Hasor
        apiBinder.installModule(new JdbcModule(Level.Full, this.dataSource));
        // .custom DataQL
        //apiBinder.tryCast(QueryApiBinder.class).loadUdfSource(apiBinder.findClass(DimUdfSource.class));
        //apiBinder.tryCast(QueryApiBinder.class).bindFragment("sql", SqlFragment.class);
        // 配置所有接口，都是只读权限
//        final Set<String> codeSet = AuthorizationType.Group_ReadOnly.toCodeSet();
        apiBinder.bindSpiListener(AuthorizationChainSpi.class, (checkType, apiInfo, defaultCheck) -> {
//            return checkType.testAuthorization(codeSet);
            return  true;
        });
    }
}
