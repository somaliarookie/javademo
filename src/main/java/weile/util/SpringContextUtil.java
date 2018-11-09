package weile.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by xubai on 2018/01/22 下午5:00.
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

    private static volatile ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    public static <T> T getBean(Class<T> clazz)throws BeansException {
        return (T)applicationContext.getBean(clazz);
    }

    public static <T> T getBean(String name,Class<T> clazz)throws BeansException {
        return getApplicationContext().getBean(name, clazz);
    }
}
