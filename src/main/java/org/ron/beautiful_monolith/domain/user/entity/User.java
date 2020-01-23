package org.ron.beautiful_monolith.domain.user.entity;

import lombok.*;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Account")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(unique = true, nullable = false)
    private String username;

    @Builder(builderClassName = "ByUserUsername", builderMethodName = "ByUserUsername")
    public User(String username) {
        Assert.hasText(username, "Username must not be empty");

        this.username = username;
    }

    @Builder(builderClassName = "ByUserIdAndUsername", builderMethodName = "ByUserIdAndUsername")
    public User(Long id, String username) {
        Assert.notNull(id, "Id must not be empty");
        Assert.hasText(username, "Username must not be empty");

        this.id = id;
        this.username = username;
    }
}
