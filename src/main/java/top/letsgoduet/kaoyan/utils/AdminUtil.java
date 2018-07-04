package top.letsgoduet.kaoyan.utils;

import top.letsgoduet.kaoyan.model.User;

public class AdminUtil {
    public static boolean isAdmin(long uid) {
        return uid == User.ROLE_MANAGER;
    }
}
