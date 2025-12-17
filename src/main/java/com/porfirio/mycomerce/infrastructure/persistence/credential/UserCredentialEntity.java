package com.porfirio.mycomerce.infrastructure.persistence.credential;

import com.porfirio.mycomerce.domain.platform.credential.CredentialId;
import com.porfirio.mycomerce.domain.platform.credential.Email;
import com.porfirio.mycomerce.domain.platform.credential.UserCredential;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_credentials")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCredentialEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;
    private String password;

    public static UserCredentialEntity fromDomainToSave(UserCredential credential)
    {
        return new UserCredentialEntity(null, credential.getEmail().getValue(), credential.getPassword());
    }

    public static UserCredentialEntity fromDomainToUpdate(UserCredential credential)
    {
        return new UserCredentialEntity(credential.getId(), credential.getEmail().getValue(), credential.getPassword());
    }


    public UserCredential toDomain()
    {
        return new UserCredential(
                new CredentialId(this.id),
                new Email(this.email),
                this.password
        );
    }
}
