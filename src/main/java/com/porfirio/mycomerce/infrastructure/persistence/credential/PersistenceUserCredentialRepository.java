package com.porfirio.mycomerce.infrastructure.persistence.credential;

import org.springframework.data.repository.CrudRepository;

public interface PersistenceUserCredentialRepository extends CrudRepository<UserCredentialEntity, Integer>
{

}
