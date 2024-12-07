package org.example.dal.repos;

import org.example.dal.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IMessageRepos extends
  JpaRepository<MessageEntity, Long>,
  JpaSpecificationExecutor<MessageEntity> {
  // ...
}
