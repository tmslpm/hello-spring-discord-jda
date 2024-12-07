package org.example.pl.listener;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class MessageListener extends BaseListenerJDA {


  @Override
  public void onMessageReceived(@NotNull MessageReceivedEvent event) {
    if (event.getAuthor().isBot()) {
      return;
    }

    final Message entryMessage = event.getMessage();


    // if (entryMessage.getContentRaw().startsWith("!ping")) // <<< // need MESSAGE_CONTENT intent
    event
      .getChannel()
      .sendMessage("pong!")
      .queue();
  }

}
