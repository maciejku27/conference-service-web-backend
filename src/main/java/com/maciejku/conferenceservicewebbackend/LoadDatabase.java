package com.maciejku.conferenceservicewebbackend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserConfRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new UserConf("JanKo", "jan123", "haslo123", "jan.kowalski@email.com", "uczestnik")));
            log.info("Preloading " + repository.save(new UserConf("Jeremiasz", "jerma985", "sphee23", "jer.ma@email.com", "organizator")));
        };
    }
}