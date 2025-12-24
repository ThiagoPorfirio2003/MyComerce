package com.porfirio.mycomerce.domain.decraped;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserCredentialManager
{
    /*
    private final UserCredentialRepository credentialRepository;

    public boolean existsByEmail(Email email)
    {
        return this.credentialRepository.existsByEmail(email);
    }

    public boolean existsById(CredentialId id)
    {
        return this.credentialRepository.existsById(id);
    }

    public UserCredential save(UserCredential userCredential)
    {
        if(this.credentialRepository.existsByEmail(userCredential.getEmail()))
        {
            throw new UserCredentialAlreadyExistsException(userCredential.getEmail());
        }

        return this.credentialRepository.save(userCredential);
    }

    public UserCredential getByEmail(Email email)
    {
        var optionalCredential = this.credentialRepository.findByEmail(email);

        if(optionalCredential.isEmpty())
        {
            throw new UserCredentialDoesNotExistException(email);
        }


        return optionalCredential.get();
    }

    public UserCredential getById(CredentialId id)
    {
        var optionalCredential = this.credentialRepository.findById(id);

        if(optionalCredential.isEmpty())
        {
            throw new UserCredentialDoesNotExistException(id);
        }

        return optionalCredential.get();
    }
    */
}
