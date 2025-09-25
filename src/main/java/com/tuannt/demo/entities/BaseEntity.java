package com.tuannt.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by tuannt7 on 25/09/2025
 */
@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    // @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)")
    @JdbcType(VarcharJdbcType.class)
    private UUID id;

    @Column(columnDefinition = "TIMESTAMP(6)")
    @CreationTimestamp
    private LocalDateTime createdTime;
    @Column(columnDefinition = "TIMESTAMP(6)")
    @UpdateTimestamp
    private LocalDateTime updatedTime;

    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }
}
