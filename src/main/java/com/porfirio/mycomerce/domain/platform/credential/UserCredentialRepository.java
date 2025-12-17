package com.porfirio.mycomerce.domain.platform.credential;

import java.util.Optional;

public interface UserCredentialRepository
{
    public UserCredential save(UserCredential userCredential);

    public Optional<UserCredential> findById(CredentialId id);
    public UserCredential getById(CredentialId id);
    public Boolean existsById(CredentialId id);

    public Optional<UserCredential> findByEmail(Email email);
    public UserCredential getByEmail(Email email);
    public Boolean existsByEmail(Email email);
}
