package com.shuang.modal;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by shuang on 2018/3/28.
 */
public class AuthorityInfo implements GrantedAuthority {

    private String authority;

    public AuthorityInfo(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
