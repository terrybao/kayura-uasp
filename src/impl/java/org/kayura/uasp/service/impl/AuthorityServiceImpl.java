/**
 * Copyright 2015-2016 the original author or authors.
 * HomePage: http://www.kayura.org
 */
package org.kayura.uasp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kayura.type.GeneralResult;
import org.kayura.type.PageList;
import org.kayura.type.PageParams;
import org.kayura.type.Result;
import org.kayura.uasp.dao.AuthorityMapper;
import org.kayura.uasp.po.Group;
import org.kayura.uasp.po.MenuItem;
import org.kayura.uasp.po.MenuScheme;
import org.kayura.uasp.po.Module;
import org.kayura.uasp.po.Role;
import org.kayura.uasp.service.AuthorityService;
import org.kayura.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author liangxia@live.com
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired(required = false)
	private AuthorityMapper authorityMapper;

	@Override
	public Result<List<MenuScheme>> getUserMenus(String userId) {

		List<MenuScheme> items = authorityMapper.getUserMenus(userId);
		return new Result<List<MenuScheme>>(items);
	}

	@Override
	public Result<PageList<MenuScheme>> findMenuSchemes(String tenantId, Map<String, Object> args,
			PageParams pageParams) {

		if (args == null) {
			args = new HashMap<String, Object>();
		}

		if (StringUtils.isEmpty(tenantId)) {
			args.put("tenantId", tenantId);
		}

		PageList<MenuScheme> items = authorityMapper.findMenuSchemes(args, pageParams);
		return new Result<PageList<MenuScheme>>(items);
	}

	@Override
	public Result<MenuScheme> getMenuSchemeById(String menuSchemeId) {

		Map<String, Object> args = new HashMap<String, Object>();
		args.put("menuSchemeId", menuSchemeId);

		MenuScheme item = authorityMapper.getMenuSchemeByMap(args);
		return new Result<MenuScheme>(item);
	}

	@Override
	public GeneralResult createMenuScheme(MenuScheme menuScheme) {

		authorityMapper.createMenuScheme(menuScheme);
		return Result.succeed();
	}

	@Override
	public GeneralResult updateMenuScheme(MenuScheme menuScheme) {

		authorityMapper.updateMenuScheme(menuScheme);
		return Result.succeed();
	}

	@Override
	public GeneralResult deleteMenuScheme(String menuSchemeId) {

		// authorityMapper.deleteMenuScheme(menuSchemeId);
		return Result.succeed();
	}

	@Override
	public GeneralResult deleteMenuSchemes(List<String> menuSchemeIds) {

		authorityMapper.deleteMenuSchemes(menuSchemeIds);
		return Result.succeed();
	}

	@Override
	public Result<PageList<MenuItem>> findMenuItems(String tenantId, String parentId, Map<String, Object> args,
			PageParams pageParams) {

		if (args == null) {
			args = new HashMap<String, Object>();
		}

		if (StringUtils.isEmpty(tenantId)) {
			args.put("tenantId", tenantId);
		}

		if (StringUtils.isEmpty(parentId)) {
			args.put("parentId", parentId);
		}

		PageList<MenuItem> items = authorityMapper.findMenuItems(args, pageParams);
		return new Result<PageList<MenuItem>>(items);
	}

	@Override
	public Result<MenuItem> getMenuItemById(String menuItemId) {

		Map<String, Object> args = new HashMap<String, Object>();
		args.put("menuItemId", menuItemId);

		MenuItem item = authorityMapper.getMenuItemByMap(args);
		return new Result<MenuItem>(item);
	}

	@Override
	public GeneralResult createMenuItem(MenuItem menuItem) {

		authorityMapper.createMenuItem(menuItem);
		return Result.succeed();
	}

	@Override
	public GeneralResult updateMenuItem(MenuItem menuItem) {

		authorityMapper.updateMenuItem(menuItem);
		return Result.succeed();
	}

	@Override
	public GeneralResult deleteMenuItem(String menuItemId) {

		authorityMapper.deleteMenuItem(menuItemId);
		return Result.succeed();
	}

	@Override
	public GeneralResult deleteMenuItems(List<String> menuItemIds) {

		authorityMapper.deleteMenuItems(menuItemIds);
		return Result.succeed();
	}

	@Override
	public Result<PageList<Module>> findModules(String parentId, Map<String, Object> args, PageParams pageParams) {

		if (args == null) {
			args = new HashMap<String, Object>();
		}

		if (StringUtils.isEmpty(parentId)) {
			args.put("parentId", parentId);
		}

		PageList<Module> items = authorityMapper.findModules(args, pageParams);
		return new Result<PageList<Module>>(items);
	}

	@Override
	public Result<Module> getModuleById(String moduleId) {

		Module item = authorityMapper.getModuleById(moduleId);
		return new Result<Module>(item);
	}

	@Override
	public GeneralResult createModule(Module module) {

		authorityMapper.createModule(module);
		return Result.succeed();
	}

	@Override
	public GeneralResult updateModule(Module module) {

		authorityMapper.updateModule(module);
		return Result.succeed();
	}

	@Override
	public GeneralResult deleteModule(String moduleId) {

		authorityMapper.deleteModule(moduleId);
		return Result.succeed();
	}

	@Override
	public GeneralResult deleteModules(List<String> moduleIds) {

		authorityMapper.deleteModules(moduleIds);
		return Result.succeed();
	}

	@Override
	public Result<PageList<Role>> findRoles(String tenantId, Map<String, Object> args, PageParams pageParams) {

		if (args == null) {
			args = new HashMap<String, Object>();
		}

		if (StringUtils.isEmpty(tenantId)) {
			args.put("tenantId", tenantId);
		}

		PageList<Role> items = authorityMapper.findRoles(args, pageParams);
		return new Result<PageList<Role>>(items);
	}

	@Override
	public Result<Role> getRoleById(String roleId) {

		Role item = authorityMapper.getRoleById(roleId);
		return new Result<Role>(item);
	}

	@Override
	public GeneralResult createRole(Role role) {

		authorityMapper.createRole(role);
		return Result.succeed();
	}

	@Override
	public GeneralResult updateRole(Role role) {

		authorityMapper.updateRole(role);
		return Result.succeed();
	}

	@Override
	public GeneralResult deleteRole(String roleId) {

		authorityMapper.deleteRole(roleId);
		return Result.succeed();
	}

	@Override
	public GeneralResult deleteRoles(List<String> roleIds) {

		authorityMapper.deleteRoles(roleIds);
		return Result.succeed();
	}

	@Override
	public GeneralResult addRoleModule(String roleId, String moduleId, List<String> actions) {

		String s = StringUtils.join(",", actions.toArray());

		authorityMapper.addRoleModule(roleId, moduleId, s);
		return Result.succeed();
	}

	@Override
	public GeneralResult removeRoleModule(String roleId, String moduleId) {

		authorityMapper.removeRoleModule(roleId, moduleId);
		return Result.succeed();
	}

	@Override
	public Result<PageList<Group>> findGroups(String tenantId, Map<String, Object> args, PageParams pageParams) {

		if (args == null) {
			args = new HashMap<String, Object>();
		}

		if (StringUtils.isEmpty(tenantId)) {
			args.put("tenantId", tenantId);
		}

		PageList<Group> items = authorityMapper.findGroups(args, pageParams);
		return new Result<PageList<Group>>(items);
	}

	@Override
	public Result<Group> getGroupById(String groupId) {

		Group item = authorityMapper.getGroupById(groupId);
		return new Result<Group>(item);
	}

	@Override
	public GeneralResult createGroup(Group group) {

		authorityMapper.createGroup(group);
		return Result.succeed();
	}

	@Override
	public GeneralResult updateGroup(Group group) {

		authorityMapper.updateGroup(group);
		return Result.succeed();
	}

	@Override
	public GeneralResult deleteGroup(String groupId) {

		authorityMapper.deleteGroup(groupId);
		return Result.succeed();
	}

	@Override
	public GeneralResult deleteGroups(List<String> groupIds) {

		authorityMapper.deleteGroups(groupIds);
		return Result.succeed();
	}

	@Override
	public GeneralResult addGroupRole(String groupId, String roleId) {

		authorityMapper.addGroupRole(groupId, roleId);
		return Result.succeed();
	}

	@Override
	public GeneralResult removeGroupRole(String groupId, String roleId) {

		authorityMapper.removeGroupRole(groupId, roleId);
		return Result.succeed();
	}

	@Override
	public GeneralResult addUserGroup(String userId, String groupId) {

		authorityMapper.addUserGroup(userId, groupId);
		return Result.succeed();
	}

	@Override
	public GeneralResult removeUserGroup(String userId, String groupId) {

		authorityMapper.removeUserGroup(userId, groupId);
		return Result.succeed();
	}

	@Override
	public GeneralResult addUserRole(String userId, String roleId) {

		authorityMapper.addUserRole(userId, roleId);
		return Result.succeed();
	}

	@Override
	public GeneralResult removeUserRole(String userId, String roleId) {

		authorityMapper.removeUserRole(userId, roleId);
		return Result.succeed();
	}

	@Override
	public Result<List<Role>> findUserRoles(String userId) {

		List<Role> items = authorityMapper.findUserRoles(userId);
		return new Result<List<Role>>(items);
	}

	@Override
	public Result<List<Group>> findUserGroups(String userId) {

		List<Group> items = authorityMapper.findUserGroups(userId);
		return new Result<List<Group>>(items);
	}

}
