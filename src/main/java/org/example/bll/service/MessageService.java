package org.example.bll.service;

import org.example.dal.entity.MessageEntity;
import org.example.dal.repos.IMessageRepos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {


  public final IMessageRepos repos;


  public MessageService(IMessageRepos messageRepos) {
    this.repos = messageRepos;
  }

  public List<MessageEntity> getAll() {
    return this.repos.findAll();
  }

}
