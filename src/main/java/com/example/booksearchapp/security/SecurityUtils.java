package com.example.booksearchapp.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.List;

import static com.example.booksearchapp.security.UserRoles.ROLE_ADMIN;
import static com.example.booksearchapp.security.UserRoles.ROLE_USER;

public class SecurityUtils {
    public static List<GrantedAuthority> getAuthority(Integer authority){
        switch (authority){
            case 0:
                return AuthorityUtils.createAuthorityList(ROLE_ADMIN.toString());
            case 1:
                return AuthorityUtils.createAuthorityList(ROLE_USER.toString());
            default:
                return AuthorityUtils.createAuthorityList();
        }
    }

    public static boolean getIsAdmin(int authority){
        if(authority == 0){
            return true;
        }

        return false;
    }
}
