package org.example.dal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Entity(name = "message")
@Table(name = "messages")
@Data()
public class MessageEntity extends BaseEntity {


  @Column(name = "content", nullable = false)
  private String content;

  public MessageEntity(String content) {
    super();
    this.content = content;
  }

}
