package de.bund.bva.isyfact.batchrahmen.persistence.rahmen;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.util.HashSet;

import jakarta.persistence.EntityManagerFactory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.data.jpa.test.autoconfigure.AutoConfigureDataJpa;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

class ObjectRelationalMappingTest {

    @Configuration
    @AutoConfigureDataJpa
    @EnableAutoConfiguration
    @AutoConfigurationPackage
    @EntityScan(basePackageClasses = BatchStatus.class)
    static class DaoTestConfig {
        @Bean
        BatchStatusDao batchStatusDao(EntityManagerFactory emf) {
            return new BatchStatusDao(emf);
        }
    }

    private static class OrmTestMethods {

        @Autowired
        BatchStatusDao dao;

        @Autowired
        EntityManagerFactory emf;

        @Test
        @Transactional
        void testOrm() {
            final BatchStatus input = new BatchStatus();
            input.setBatchId("id1");
            input.setBatchStatus("status1");
            input.setBatchName("name1");
            input.setDatumLetzterAbbruch(Timestamp.from(LocalDateTime.of(2020, Month.FEBRUARY, 26, 21, 13).toInstant(ZoneOffset.UTC)));
            input.setDatumLetzterErfolg(Timestamp.from(LocalDateTime.of(2020, Month.FEBRUARY, 26, 22, 13).toInstant(ZoneOffset.UTC)));
            input.setDatumLetzterStart(Timestamp.from(LocalDateTime.of(2020, Month.FEBRUARY, 26, 23, 13).toInstant(ZoneOffset.UTC)));
            input.setSatzNummerLetztesCommit(10);
            input.setKonfigurationsParameter(new HashSet<>());

            dao.createBatchStatus(input);
            EntityManagerFactoryUtils.getTransactionalEntityManager(emf).flush();

            assertThat(dao.leseBatchStatus(input.getBatchId())).usingRecursiveComparison().isEqualTo(input);
        }
    }


    @Nested
    @SpringBootTest(
            webEnvironment = SpringBootTest.WebEnvironment.NONE,
            classes = DaoTestConfig.class,
            properties = {
                    "spring.main.banner-mode = off",
                    "spring.sql.init.schema-locations = classpath:sql/tabellen-erzeugen.sql",
                    "spring.jpa.hibernate.ddl-auto = none"
            }
    )
    class CamalCaseToUnderscoresNamingTest extends OrmTestMethods {
    }

    @Nested
    @SpringBootTest(
            webEnvironment = SpringBootTest.WebEnvironment.NONE,
            classes = DaoTestConfig.class,
            properties = {
                    "spring.main.banner-mode = off",
                    "spring.sql.init.schema-locations = classpath:sql/tabellen-erzeugen.sql",
                    "spring.jpa.hibernate.ddl-auto = none",
                    "spring.jpa.hibernate.naming.physical-strategy = org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl",
                    "spring.jpa.mapping-resources = resources/isy-batchrahmen/hibernate/hibernate-mapping.xml"
            }
    )
    class PhysicalNamingTest extends OrmTestMethods {
    }

    @Nested
    @SpringBootTest(
            webEnvironment = SpringBootTest.WebEnvironment.NONE,
            classes = DaoTestConfig.class,
            properties = {
                    "spring.main.banner-mode = off",
                    "spring.sql.init.schema-locations = classpath:sql/tabellen-erzeugen-if2.sql",
                    "spring.jpa.hibernate.ddl-auto = none",
                    "spring.jpa.mapping-resources = resources/isy-batchrahmen/hibernate/hibernate-mapping-if2.xml",
            }
    )
    class CamalCaseToUnderscoresNamingOldBatchStatusTableTest extends OrmTestMethods {
    }
}
