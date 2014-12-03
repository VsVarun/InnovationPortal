package com.iri.ip.config;

import java.util.Base64;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.iri.ip.ldap.ActiveDirectoryLdapAuthenticationProvider;

/**
 * @author		: Sravanthi Appana
 * @user		: [ insappana ]
 * @citrixID	: [ prsaq ]
 * @desc		: This Configuration contains the Authentication Bean Definitions alone
 * @fileName	: AuthenticationConfig.java
 * @packageName	: com.iri.ip.config
 * @projectName	: Web
 * @Date_Time	: Dec 3, 2014_11:00:00 AM
 */
@Configuration
@EnableWebSecurity
public class AuthenticationConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(final AuthenticationManagerBuilder auth)
			throws Exception {
		auth.authenticationProvider(authenticator());
		super.configure(auth);
	}

	@Bean
	public ActiveDirectoryLdapAuthenticationProvider authenticator()
			throws Exception {
		ResourceBundle bundle = new PropertyResourceBundle(this.getClass()
				.getClassLoader()
				.getResourceAsStream("META-INF/config/ldap.properties"));

		String domain = new String(Base64.getDecoder().decode(
				bundle.getString("ldap.domain")));
		String url = new String(Base64.getDecoder().decode(
				bundle.getString("ldap.url")));

		ActiveDirectoryLdapAuthenticationProvider authProvider = new ActiveDirectoryLdapAuthenticationProvider(
				domain, url);
		authProvider.setConvertSubErrorCodesToExceptions(true);
		authProvider.setUseAuthenticationRequestCredentials(true);
		return authProvider;
	}
}
