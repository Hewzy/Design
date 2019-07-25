package com.cn.jk.config.shiro;


import com.cn.jk.entity.TbPermission;
import com.cn.jk.entity.TbUser;
import com.cn.jk.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class MyRealm extends AuthorizingRealm {
	
	@Autowired
	private LoginService loginService;


	/**
	 * 执行授权逻辑
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username=(String) SecurityUtils.getSubject().getPrincipal();
		//给资源进行授权，SimpleAuthorizationInfo是AuthorizationInfo的一个实现类
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();

		List<TbPermission> permissionByUserName = loginService.getPermissionByUserName(username);
		for(TbPermission permission:permissionByUserName) {
			info.addStringPermission(permission.getPermissionPower());
		}
		return info;
	}

	/**
	 *   执行认证逻辑
	 *   1、检查提交的进行认证的令牌信息
	 *   2、根据令牌信息从数据源(通常为数据库)中获取用户信息
	 *   3、对用户信息进行匹配验证。
	 *   4、验证通过将返回一个封装了用户信息的AuthenticationInfo实例。
	 *   5、验证失败则抛出AuthenticationException异常信息。
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("token.getPrincipal:" + token.getPrincipal());
		String userName = token.getPrincipal().toString();
		TbUser userByName = loginService.findUserByName(userName);
		if (userByName != null) {
			// 用户存在，判断密码
			AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(userByName.getUserName(), userByName.getUserPassword(), getName());
			return authcInfo;
		} else {
			//用户名不存在，shiro底层会抛出UnKnowAccountException
			return null;
		}
	}
}
