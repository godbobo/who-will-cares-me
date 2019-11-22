package com.aqzscn.lonely.handler;

import com.aqzscn.lonely.utils.EncryptUtil;
import com.aqzscn.lonely.vo.GlobalCaches;
import com.aqzscn.lonely.vo.GlobalNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 系统启动时执行一些初始化操作
 *
 * @author Godbobo
 * @date 2019/5/28
 */
@Component
@Order(1)
public class SystemInitializer implements ApplicationRunner {

    private final Logger logger = LoggerFactory.getLogger(SystemInitializer.class);

    @Value("${custom.username}")
    private String username;

    @Value("${custom.password}")
    private String password;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        long startTime = System.currentTimeMillis();
        // 初始化管理员口令
        GlobalCaches.token = EncryptUtil.buildMd5(username + password);
        buildResponseCodeName();

        long endTime = System.currentTimeMillis();
        this.logger.info("系统初始化完成，共花费 {} ms", endTime - startTime);
    }

    private void buildResponseCodeName() {
        GlobalNames.responseCodeName.put(401, "用户未授权");
        GlobalNames.responseCodeName.put(403, "权限不足");
        GlobalNames.responseCodeName.put(404, "找不到对应的地址");
        GlobalNames.responseCodeName.put(500, "服务器发生未知错误");
    }

}
