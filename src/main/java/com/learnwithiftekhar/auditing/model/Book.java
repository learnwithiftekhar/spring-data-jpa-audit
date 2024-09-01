package com.learnwithiftekhar.auditing.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "book")
@Data
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Book {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String author;

    @CreatedDate
    @Column(
            insertable = true,
            updatable = false
    )
    private Instant createdAt;

    @LastModifiedDate
    @Column(
            insertable = false,
            updatable = true
    )
    public Instant updatedAt;

    @CreatedBy
    @Column(
            insertable = true,
            updatable = false
    )
    public String createdBy;

    @LastModifiedBy
    @Column(
            insertable = false,
            updatable = true
    )
    public String updatedBy;

}
