package br.com.usersapi.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USER")
public class User extends AbstractEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "ID", updatable = false, nullable = false)
    private UUID id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "KEY")
    private String key;
    @Column(name = "EMAIL", unique = true)
    private String email;
}
