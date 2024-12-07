package org.example.bll.service;

import lombok.AllArgsConstructor;
import org.example.dal.entity.MessageEntity;
import org.example.dal.repos.IMessageRepos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MessageService {

  public final IMessageRepos repos;

  public List<MessageEntity> getAll() {
    return this.repos.findAll();
  }

}
