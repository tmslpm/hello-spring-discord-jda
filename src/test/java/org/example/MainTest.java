package org.example;

import org.example.dal.entity.MessageEntity;
import org.example.dal.repos.IMessageRepos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

@SpringBootTest()
@TestPropertySource(locations = "classpath:application.test.properties")
public class MainTest {
  @Autowired
  private IMessageRepos messageRepos;

  @Test
  void exampleTest() {
    final String expected = "foo";
    final String actual = "bar";
    Assertions.assertNotEquals(expected, actual);
  }

  @Test
  void testDevH2Database() {
    final List<MessageEntity> actual = this.messageRepos.findAll();
    // Config.DevPopulateDatabase add entity to DB
    Assertions.assertFalse(actual.isEmpty());

    actual.forEach(v -> Assertions.assertTrue(v
      .getContent()
      .contains("Hello World")));
  }

}
