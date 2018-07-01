package top.letsgoduet.kaoyan.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerProvider {
    public static <T> Logger provideLogger(Class<T> tClass){
        return LoggerFactory.getLogger(tClass);
    }
}
