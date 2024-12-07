package org.example.pl.listener;

import com.samskivert.mustache.Template;
import lombok.AllArgsConstructor;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.example.bll.service.TemplateService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@AllArgsConstructor
public class MessageListener extends BaseListenerJDA {

  private final TemplateService templateService;

  @Override
  public void onMessageReceived(@NotNull MessageReceivedEvent event) {
    if (event.getAuthor().isBot()) {
      return;
    }

    final Message message = event.getMessage();
    final MessageChannelUnion channel = event.getChannel();

    // - - - - - - - - - - - - - - - - - - -
    // Example Raw String

    channel
      .sendMessage("pong!")
      .queue();

    // - - - - - - - - - - - - - - - - - - -
    // Example Mustache

    final Template helloTemplate = templateService.get("hello-world.md.mustache");
    final Map<String, String> helloTemplateData = Map.of("name", "John");

    channel
      .sendMessage(helloTemplate.execute(helloTemplateData))
      .queue();

  }

}
