package com.gluuten.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by yusufaslan on 1.06.2017.
 */
@Component
public class Constants {
//sasasadsadafsdsd
    public static final String URI_API_PREFIX = "/api";
    public static final String URI_POSTS = "/posts";
    public static final String URI_TITLES= "/titles";
    public static final String URI_COMMENTS ="/comments";

    public static final String ERROR_UPDATE_PROFILE = "Updating profile doesn't match the current one";
    public static final String ERROR_UPDATE_EMAIL = "E-mail is already used by another person";
    public static final String ERROR_SIGN_UP_EMAIL = ERROR_UPDATE_EMAIL;
    public static final String ERROR_PASSWORD_CONFIRMATION = "Current password is invalid";

    public static String API_URL;
    public static String WEB_URL;
    public static String IMAGE_FOLDER;

    static String REMEMBER_ME_TOKEN;
    static String REMEMBER_ME_COOKIE;
    static final String XSRF_TOKEN_COOKIE_NAME = "XSRF-TOKEN";
    static final String XSRF_TOKEN_HEADER_NAME = "X-XSRF-TOKEN";

    @Value("${resources.api-url}")
    public void setApiUrl(String path) {
        API_URL = path;
    }

    @Value("${resources.web-url}")
    public void setWebUrl(String path) {
        WEB_URL = path;
    }

    @Value("${resources.image-folder}")
    public void setImageFolder(String path) {
        IMAGE_FOLDER = path;
    }

    @Value("${remember-me.token}")
    public void setRememberMeToken(String token) {
        REMEMBER_ME_TOKEN = token;
    }

    @Value("${remember-me.cookie}")
    public void setRememberMeCookie(String cookie) {
        REMEMBER_ME_COOKIE = cookie;
    }


    private Constants() {}

}
