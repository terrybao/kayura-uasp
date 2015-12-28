/**
 * Copyright 2015-2015 the original author or authors.
 * HomePage: http://www.kayura.org
 */
package org.kayura.uasp.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.kayura.exceptions.KayuraException;
import org.kayura.mybatis.type.PageBounds;
import org.kayura.type.GeneralResult;
import org.kayura.type.PageList;
import org.kayura.type.PageParams;
import org.kayura.uasp.dao.UserMapper;
import org.kayura.uasp.po.AutoLogin;
import org.kayura.uasp.po.User;
import org.kayura.uasp.service.UserService;
import org.kayura.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liangxia@live.com
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public PageList<User> findUsers(String keyword, Integer[] status, PageParams pageParams) {

		Map<String, Object> args = new HashMap<String, Object>();
		args.put("keyword", keyword);

		if (status != null) {
			args.put("status", StringUtils.join(",", status));
		}

		PageList<User> list = userMapper.findUsersByMap(args, new PageBounds(pageParams));
		return list;
	}

	@Override
	public User getUserByUserName(String loginName) {

		Map<String, Object> args = new HashMap<String, Object>();

		boolean isTenant = loginName.contains("#");
		if (isTenant) {

			String[] values = loginName.split("#");

			String tenantId = values[0];
			String userName = values[1];

			args.put("tenantId", tenantId);
			args.put("userName", userName);
		} else {

			args.put("userName", loginName);
		}

		User user = userMapper.getUserByMap(args);
		return user;
	}

	@Override
	public GeneralResult createNewUser(User user) {

		GeneralResult result = new GeneralResult("创建成功.");
		try {
			
			Map<String, Object> args = new HashMap<String, Object>();

			args.put("userId", user.getUserId());
			if (userMapper.isExistsByMap(args)) {
				throw new KayuraException("该用户ID已经存在。");
			}
			
			args.clear();
			args.put("userName", user.getUserName());
			if (userMapper.isExistsByMap(args)) {
				throw new KayuraException("该用户账号已经存在。");
			}

			userMapper.insertUser(user);
			
		} catch (Exception e) {
			result.setCode(-1);
			result.setMessage("创建失败。原因：" + e.getMessage());
		}

		return result;
	}

	@Override
	public GeneralResult updateUserInfo(User user) {

		Map<String, Object> args = new HashMap<String, Object>();
		args.put("userId", user.getUserId());

		GeneralResult result = new GeneralResult("更新成功.");
		try {
			
			if (userMapper.isExistsByMap(args)) {
				userMapper.updateUserInfo(user);
			}
		} catch (Exception e) {
			result.setCode(-1);
			result.setMessage("更新失败。原因：" + e.getMessage());
		}

		return result;
	}

	@Override
	public GeneralResult changeUserPassword(String userId, String oldPassword, String newPassword) {

		Map<String, Object> args = new HashMap<String, Object>();
		args.put("userId", userId);

		GeneralResult result = new GeneralResult("更新成功.");
		try {

			User user = userMapper.getUserByMap(args);
			if (user == null) {
				throw new KayuraException("指定的用户ID不存在。");
			}

			if (!StringUtils.equals(user.getPassword(), oldPassword)) {
				throw new KayuraException("原用户名密码错误。");
			}

			// 修改数据库中的用户密码.
			userMapper.changePassword(userId, newPassword);

		} catch (Exception e) {
			result.setCode(-1);
			result.setMessage("更新失败。原因：" + e.getMessage());
		}

		return result;

	}

	@Override
	public void deleteUser(String userId) {
		userMapper.deleteUser(userId);
	}

	@Override
	public User getUserById(String userId) {

		Map<String, Object> args = new HashMap<String, Object>();
		args.put("userId", userId);

		User user = userMapper.getUserByMap(args);
		return user;
	}

	@Override
	public void createLoginToken(AutoLogin autoLogin) {

		userMapper.createLoginToken(autoLogin);
	}

	@Override
	public void updateLoginToken(String seriesId, String token, Date lastUsed) {

		Map<String, Object> args = new HashMap<String, Object>();
		args.put("seriesId", seriesId);
		args.put("token", token);
		args.put("lastUsed", lastUsed);

		userMapper.updateLoginToken(args);
	}

	@Override
	public AutoLogin getLoginTokenById(String seriesId) {

		AutoLogin entity = userMapper.getLoginTokenById(seriesId);
		return entity;
	}

	@Override
	public void removeLoginTokensByUser(String userId) {

		userMapper.removeLoginTokensByUser(userId);
	}
}
