package com.iri.ip.ldap;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;

/**
 * <p>
 * Thrown as a translation of an {@link javax.naming.AuthenticationException} when attempting to authenticate against
 * Active Directory using {@link ActiveDirectoryLdapAuthenticationProvider}. Typically this error is wrapped by an
 * {@link AuthenticationException} since it does not provide a user friendly message. When wrapped, the original
 * Exception can be caught and {@link ActiveDirectoryAuthenticationException} can be accessed using
 * {@link AuthenticationException#getCause()} for custom error handling.
 * </p>
 * <p>
 * The {@link #getDataCode()} will return the error code associated with the data portion of the error message. For
 * example, the following error message would return 773 for {@link #getDataCode()}.
 * </p>
 *
 * <pre>
 * javax.naming.AuthenticationException: [LDAP: error code 49 - 80090308: LdapErr: DSID-0C090334, comment: AcceptSecurityContext error, data 775, vece ]
 * </pre>
 */
@SuppressWarnings("serial")
public final class ActiveDirectoryAuthenticationException extends AuthenticationException {
    private final String dataCode;

    ActiveDirectoryAuthenticationException(String dataCode, String message, Throwable cause) {
        super(message, cause);
        this.dataCode = dataCode;
    }

    public String getDataCode() {
        return dataCode;
    }
}
