package com.springboot.ssm.config.db;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(
        basePackages = {"com.springboot.ssm.mapper.system"}, // 1. 扫描mapper层所在的包
        sqlSessionTemplateRef = "systemSqlSessionTemplate")
public class SystemDBConfig {

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.system")
    public DataSourceProperties systemDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.system.configuration")
    public DataSource systemDataSource() {
        return systemDataSourceProperties()
                .initializeDataSourceBuilder()
                .type(HikariDataSource.class) // 3. 可以显示指定连接池，也可以不显示指定；即此行代码可以注释掉
                .build();
    }

    @Bean
    @Primary
    public SqlSessionFactory systemSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(systemDataSource());
        factoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver()
                        .getResources("classpath:mapper/system/*.xml")); // 2. xml 所在路径
        factoryBean.setTypeAliasesPackage("com.springboot.ssm.domain");
        return factoryBean.getObject();
    }

    @Bean
    @Primary
    public DataSourceTransactionManager systemTransactionManager() {
        return new DataSourceTransactionManager(systemDataSource());
    }

    @Bean
    @Primary
    public SqlSessionTemplate systemSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(systemSqlSessionFactory());
    }

}
