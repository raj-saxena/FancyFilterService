package com.example.fancyFilterService.configs

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.micrometer.core.instrument.MeterRegistry
import org.jooq.SQLDialect
import org.jooq.impl.DefaultDSLContext
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class DataSourceConfig {

    @Bean
    fun dataSource(
        @Value("\${spring.datasource.url}") url: String,
        @Value("\${spring.datasource.username}") username: String,
        @Value("\${spring.datasource.password}") password: String,
        metricRegistry: MeterRegistry
    ): DataSource {

        val hikariConfig = HikariConfig().apply {
            this.username = username
            this.password = password
            this.metricRegistry = metricRegistry
            jdbcUrl = url
            isAutoCommit = true
            transactionIsolation = "TRANSACTION_READ_COMMITTED"
            poolName = "fancyFilter-db"
        }
        return HikariDataSource(hikariConfig)
    }

    @Bean
    fun dslContext(dataSource: DataSource): DefaultDSLContext = DefaultDSLContext(dataSource, SQLDialect.POSTGRES)
}
