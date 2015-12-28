/**
 * Copyright 2015-2015 the original author or authors.
 * HomePage: http://www.kayura.org
 */
package org.kayura.uasp.security;

import java.util.Date;

import org.kayura.uasp.service.UserService;
import org.kayura.uasp.po.AutoLogin;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

public class RememberMeTokenRepositoryImpl implements PersistentTokenRepository {

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void createNewToken(PersistentRememberMeToken token) {
		
		AutoLogin vo = new AutoLogin();
		vo.setToken(token.getTokenValue());
		vo.setSeriesId(token.getSeries());
		vo.setLastUsed(token.getDate());
		vo.setUserId(token.getUsername());
		
		userService.createLoginToken(vo);		
	}

	@Override
	public void updateToken(String series, String tokenValue, Date lastUsed) {
		
		userService.updateLoginToken(series, tokenValue, lastUsed);
	}

	@Override
	public PersistentRememberMeToken getTokenForSeries(String seriesId) {

		AutoLogin vo = userService.getLoginTokenById(seriesId);
		
		if(vo == null) return null;
		
		PersistentRememberMeToken token = new PersistentRememberMeToken(
				vo.getUserName(), vo.getSeriesId(), vo.getToken(), vo.getLastUsed());
		
		return token;
	}

	@Override
	public void removeUserTokens(String username) {

		userService.removeLoginTokensByUser(username);
	}

}
