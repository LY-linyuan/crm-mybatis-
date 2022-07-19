package com.bjpowernode.crm.web.listener;

import com.bjpowernode.crm.settings.service.DicService;
import com.bjpowernode.crm.settings.service.impl.DicServiceImpl;
import com.bjpowernode.crm.utils.ServiceFactory;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
* @Author  临渊
* @Date    2022-07-19 17:42
*/


public class SysInitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        // System.out.println("上下文域创建了");
        System.out.println("服务器缓存处理数据字典开始");
        ServletContext application = event.getServletContext();
        DicService ds = (DicService) ServiceFactory.getService(new DicServiceImpl());

        // 取数据字典
        Map<String, Object> map = ds.getAll();
        Set<String> set = map.keySet();
        for (String key: set) {
            application.setAttribute(key, map.get(key));
        }
        System.out.println("服务器缓存处理数据字典结束");
    }

}
