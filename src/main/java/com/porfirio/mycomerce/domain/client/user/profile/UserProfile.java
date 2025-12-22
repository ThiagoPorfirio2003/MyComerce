package com.porfirio.mycomerce.domain.client.user.profile;

import com.porfirio.mycomerce.domain.platform.credential.CredentialId;
import lombok.Getter;

import java.util.Objects;
import java.util.UUID;

@Getter
public class UserProfile
{
    private final UUID id;
    private final UUID personalDataId;
    private final CredentialId credentialId;
    private final UserRole role;
    private final boolean isEnabled;

    public UserProfile(UUID personalDataId, CredentialId credentialId, UserRole userRole, boolean isEnabled)
    {
        this.id = UUID.randomUUID();
        this.personalDataId = personalDataId;
        this.credentialId = credentialId;
        this.role = userRole;
        this.isEnabled = isEnabled;
        this.validate(false);
    }

    public UserProfile(UUID id, UUID personalDataId, CredentialId credentialId, UserRole userRole, boolean isEnabled)
    {
        this.id = id;
        this.personalDataId = personalDataId;
        this.credentialId = credentialId;
        this.role = userRole;
        this.isEnabled = isEnabled;
        this.validate(true);
    }

    private void validate(boolean validateId)
    {
        if(validateId)
        {
            Objects.requireNonNull(this.id, "The UserProfile.ID must be not NULL");
        }

        Objects.requireNonNull(this.personalDataId, "The UserProfile.personalDataId must be not NULL");
        Objects.requireNonNull(this.credentialId, "The UserProfile.credentialId must be not NULL");
        Objects.requireNonNull(this.role, "The UserProfile.role must be not NULL");
    }
}
