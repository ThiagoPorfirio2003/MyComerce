package com.porfirio.mycomerce.infrastructure.persistence.credential;

import com.porfirio.mycomerce.domain.platform.credential.CredentialId;
import com.porfirio.mycomerce.domain.platform.credential.Email;
import com.porfirio.mycomerce.domain.platform.credential.UserCredential;
import com.porfirio.mycomerce.domain.platform.credential.UserCredentialRepository;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class UserCredentialRepositoryImp implements UserCredentialRepository
{
    private final PersistenceUserCredentialRepository credentialRepository;

    @Override
    public UserCredential save(UserCredential userCredential)
    {
        return null;
    }

    @Override
    public Optional<UserCredential> findById(CredentialId id)
    {
        return Optional.empty();
    }

    @Override
    public UserCredential getById(CredentialId id) {
        return null;
    }

    @Override
    public Boolean existsById(CredentialId id) {
        return null;
    }

    @Override
    public Optional<UserCredential> findByEmail(Email email) {
        return Optional.empty();
    }

    @Override
    public UserCredential getByEmail(Email email) {
        return null;
    }

    @Override
    public Boolean existsByEmail(Email email) {
        return null;
    }
}
