package com.lin.intercepter;

import cn.dev33.satoken.stp.StpInterface;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 关于数据的获取，建议以下方案三选一：
 * <p>
 * 在网关处集成ORM框架，直接从数据库查询数据
 * 先从Redis中获取数据，获取不到时走ORM框架查询数据库
 * 先从Redis中获取缓存数据，获取不到时走RPC调用子服务 (专门的权限数据提供服务) 获取
 * </p>
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return null;
    }

    @Override
    public List<String> getRoleList(@NotNull Object loginId, String loginType) {
        System.out.println(loginType);

        ArrayList<String> roles = new ArrayList<>();
        if (loginId.equals("1"))
            roles.add("admin");
        return roles;
    }
}
