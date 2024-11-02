package com.example.cart.persistence;

import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.spring.api.DBRider;
import jakarta.transaction.Transactional;
import org.dbunit.ext.postgresql.PostgresqlDataTypeFactory;
import org.junit.jupiter.api.Tag;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.lang.annotation.*;

import static com.github.database.rider.core.api.configuration.Orthography.LOWERCASE;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootApplication
@SpringBootTest
@ActiveProfiles(profiles = "persistence")
@Transactional
@DBUnit(
        cacheConnection = false,
        dataTypeFactoryClass = PostgresqlDataTypeFactory.class,
        caseInsensitiveStrategy = LOWERCASE
)
@DBRider
@Tag("integration")
@interface PersistenceTest {
}
