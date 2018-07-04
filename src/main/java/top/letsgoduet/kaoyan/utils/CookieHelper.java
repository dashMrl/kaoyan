package top.letsgoduet.kaoyan.utils;

import top.letsgoduet.kaoyan.model.User;

import javax.servlet.http.Cookie;
import java.util.Arrays;

public class CookieHelper {
    private static final String KEY_UID = "UID";
    private static final int MAX_COOKIE_AGE = 24 * 60 * 60;

    public static boolean isCookieValid(Cookie[] cookies) {
        return Arrays.stream(cookies).anyMatch(cookie -> cookie.getName().equals(KEY_UID) && !cookie.getValue().isEmpty());
    }

    public static Cookie createCookie(User user) {
        Cookie cookie = new Cookie(KEY_UID, user.id.toString());
        cookie.setMaxAge(MAX_COOKIE_AGE);
        return cookie;
    }

    public static long decodeCookie2UID(Cookie[] cookies) {
        Cookie c = Arrays.asList(cookies).stream().filter(cookie -> cookie.getName().equals(KEY_UID)).findFirst().orElse(null);
        if (c == null) {
            return -1;
        } else {
            return Long.parseLong(c.getValue());
        }
    }
}
