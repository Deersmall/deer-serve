package com.example.demo.shirocfg;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroCfg {

    @Autowired
    private CustomerRealm customerRealm;


    @Bean
    public DefaultShiroFilterChainDefinition getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        DefaultShiroFilterChainDefinition definition = new DefaultShiroFilterChainDefinition();

        /**
         * 添加 shiro 过滤器
         *
         * anon  无需认证
         * authc  必须认证
         * user  必须拥有 记住我 功能才可以
         * perms  拥有某个资源权限
         * role  拥有某个角色
         * */

        definition.addPathDefinition("/deerLogin/login","anon");
//        definition.addPathDefinition("/**","authc");

        return definition;
    }


    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        // md5 加密
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(3);       //3 次加密
        customerRealm.setCredentialsMatcher(matcher);

        // 关联 CustomerRealm
        securityManager.setRealm(customerRealm);
        return securityManager;
    }

}
