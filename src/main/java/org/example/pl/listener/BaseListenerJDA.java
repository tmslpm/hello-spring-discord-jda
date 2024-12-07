package org.example.pl.listener;

import net.dv8tion.jda.api.hooks.ListenerAdapter;

public abstract class BaseListenerJDA extends ListenerAdapter {



  public boolean isEnabled() {
    return true;
  }

}
