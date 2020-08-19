package com.lemon.michstabe.config.shiro;


import com.lemon.michstabe.dao.UserMapper;
import com.lemon.michstabe.entity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    /**
     * 获取角色和权限
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权检查");
        return null;
    }

    /**
     * 登录验证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userAccount = (String) authenticationToken.getPrincipal();
        String userPassword = new String((char[]) authenticationToken.getCredentials());

//        System.out.println("用户：" + userAccount + "  密码：" + userPassword);
        User user = userMapper.login(userAccount);
        if (user == null) {
            throw new UnknownAccountException("用户错误！");
        }
        if (!userPassword.equals(user.getUserPassword())) {
            throw new IncorrectCredentialsException("密码错误！");
        }
        if (user.getUserState()== 1) {
            throw new LockedAccountException("用户已被锁定，请联系管理员！");
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, userPassword, getName());
        return simpleAuthenticationInfo;
    }
}
