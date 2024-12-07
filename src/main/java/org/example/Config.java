package org.example;

import org.example.dal.entity.MessageEntity;
import org.example.dal.repos.IMessageRepos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SuppressWarnings("unused")
public interface Config {

  @Configuration
  @EnableJpaAuditing
  class Jpa {
  }


  @Configuration
  class DevPopulateDatabase {
    @Bean
    CommandLineRunner initMemberReposDatabase(IMessageRepos memberRepository) {
      return args -> {
        memberRepository.save(new MessageEntity("Hello World 0"));
        memberRepository.save(new MessageEntity("Hello World 1"));
        memberRepository.save(new MessageEntity("Hello World 2"));
        memberRepository.save(new MessageEntity("Hello World 3"));
      };
    }
  }
}
