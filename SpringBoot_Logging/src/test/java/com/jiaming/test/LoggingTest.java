package com.jiaming.test;

import com.jiaming.SpringbootLoggingApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jmstart
 * @create 2020-04-29 11:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootLoggingApplication.class)
public class LoggingTest {

    //日志记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void testLogging() {
        /**
         * 如报这个错误,就是包导错了
         * Error:(21, 22) java: 不兼容的类型: java.lang.String无法
         * 转换为java.util.function.Supplier<java.lang.String>
         *
         * 导这个二个包:
         * import org.slf4j.Logger;
         * import org.slf4j.LoggerFactory;
         * 不是这二个包:
         * import org.junit.platform.commons.logging.Logger;
         * import org.junit.platform.commons.logging.LoggerFactory;
         *
         *
         * 测试时报这个错误:
         * //警告: Runner org.junit.internal.runners.ErrorReportingRunner
         * (used on class com.jiaming.test.LoggingTest) does not support filtering and will therefore be run completely.
         *
         * 也是导包的问题:
         * 应该导入:
         * import org.junit.Test;
         * 不是导入:
         * import org.junit.jupiter.api.Test;
         */


        //测试
        //日志的级别：下列顺序从低到高
        logger.trace("The is Trace log...");
        logger.debug("The is Debug log...");
        //SpringBoot默认级别是 info,所以只执行打印 info和比它更高级的日志级别
        logger.info("The is Info log...");
        logger.warn("The is Warn log...");
        logger.error("The is Error log...");
    }

}
