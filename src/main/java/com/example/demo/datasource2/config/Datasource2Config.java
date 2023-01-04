package com.example.demo.datasource2.config;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.core.DefaultReactiveDataAccessStrategy;
import org.springframework.data.r2dbc.core.R2dbcEntityOperations;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.dialect.PostgresDialect;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.core.DatabaseClient;

import static io.r2dbc.pool.PoolingConnectionFactoryProvider.MAX_SIZE;
import static io.r2dbc.spi.ConnectionFactoryOptions.*;
import static io.r2dbc.spi.ConnectionFactoryOptions.DATABASE;

@Configuration
@EnableR2dbcRepositories(basePackages = "com.example.demo.datasource2.repo",entityOperationsRef = "ordersEntityTemplate")
public class Datasource2Config {
    @Value("${spring.r2dbc.driver}")
    private String driver;

    @Value("${spring.r2dbc1.host}")
    private String host;

    @Value("${spring.r2dbc1.port}")
    private Integer port;

    @Value("${spring.r2dbc1.username}")
    private String username;

    @Value("${spring.r2dbc1.password}")
    private String password;

    @Value("${spring.r2dbc2.database}")
    private String database;

    @Value("${spring.r2dbc.maxSize}")
    private Integer maxSize;

    @Bean()
    @Qualifier("ordersConnectionFactory")
    public ConnectionFactory ordersConnectionFactory() {
        return ConnectionFactories.get(ConnectionFactoryOptions.builder()
                .option(DRIVER, driver)
                .option(HOST, host)
                .option(PORT, port)
                .option(USER, username)
                .option(PASSWORD, password)
                .option(DATABASE, database)
                .option(MAX_SIZE, maxSize)
                .build());
    }

    @Bean
    public R2dbcEntityOperations ordersEntityTemplate(@Qualifier("ordersConnectionFactory") ConnectionFactory connectionFactory) {

        DefaultReactiveDataAccessStrategy strategy = new DefaultReactiveDataAccessStrategy(PostgresDialect.INSTANCE);
        DatabaseClient databaseClient = DatabaseClient.builder()
                .connectionFactory(connectionFactory)
                .bindMarkers(PostgresDialect.INSTANCE.getBindMarkersFactory())
                .build();

        return new R2dbcEntityTemplate(databaseClient, strategy);
    }

}
