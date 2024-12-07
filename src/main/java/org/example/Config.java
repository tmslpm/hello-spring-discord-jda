package org.example;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.example.dal.entity.MessageEntity;
import org.example.dal.repos.IMessageRepos;
import org.example.pl.listener.BaseListenerJDA;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@SuppressWarnings("unused")
public interface Config {

  @Configuration
  class DiscordJDA {
    @Bean
    JDA createDiscordJDA(@Value("${discord.bot.token}") String botToken, List<BaseListenerJDA> eventHandlers) {
      return JDABuilder
        .createDefault(botToken)
        .enableIntents(
          GatewayIntent.GUILD_MEMBERS,
          GatewayIntent.GUILD_MESSAGES,
          GatewayIntent.MESSAGE_CONTENT)
        .setActivity(Activity.playing("Bot is running..."))
        .addEventListeners(eventHandlers
          .stream()
          .filter(BaseListenerJDA::isEnabled)
          .toArray())
        .build();
    }
  }

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
