package com.tuannt.demo.configs;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by tuannt7 on 23/09/2025
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.tuannt.demo.repositories",
        includeFilters = @ComponentScan.Filter(
                type = FilterType.ANNOTATION, classes = PrdRepositoryMarker.class
        ),
        entityManagerFactoryRef = "prdEntityManagerFactory",
        transactionManagerRef   = "prdTransactionManager"
)
public class ProductionDatabaseConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.prd")
    public DataSourceProperties prdDatasourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource prdDatasource() {
        return prdDatasourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean prdEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(prdDatasource())
                .packages("com.tuannt.demo.entities")
                .persistenceUnit("prdPU")
                .build();
    }

    @Bean
    public PlatformTransactionManager prdTransactionManager(@Qualifier("prdEntityManagerFactory") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
