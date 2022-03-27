package com.michaelloi.common.models.objects;

import com.michaelloi.common.constants.ConfigValues;
import com.michaelloi.common.constants.DefaultValues;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
public class Session extends User {
    private String userId;
    private String userName = DefaultValues.emptyString;
    private String userNickname = DefaultValues.emptyString;
    private String userFullname = DefaultValues.emptyString;
    private String userDateOfBirth = DefaultValues.emptyString;
    private String uuid = DefaultValues.emptyString;
    private String path = DefaultValues.emptyString;
    private String channel = DefaultValues.emptyString;
    private String service = DefaultValues.emptyString;
    private String lastLogin = DefaultValues.emptyString;
    private String sessionId;
    private boolean isActive = false;
    private String language = DefaultValues.emptyString;

    public Session(
        String userId,
        String userName,
        String password,
        String sessionId,
        boolean enabled,
        boolean accountNonExpired,
        boolean credentialNonExpired,
        boolean accountNonLocked,
        Collection<? extends GrantedAuthority> authorities
    ) {
        super(userName, password, enabled, accountNonExpired, credentialNonExpired, accountNonLocked, authorities);
        this.userId = userId;
        this.userName = userName;
        this.sessionId = sessionId;
    }

    public Session(
        String userId,
        String userName,
        String password,
        String userNickname,
        String userFullname,
        String sessionId,
        Collection<? extends GrantedAuthority> authorities
    ) {
        super(userName, password, true, true, true, true, authorities);
        this.userId = userId;
        this.userNickname = userNickname;
        this.userFullname = userFullname;
        this.sessionId = sessionId;
    }

    public Session(){
        super(
            ConfigValues.anonymous,
            DefaultValues.emptyString,
            false,
            false,
            false,
            false,
            new ArrayList<>()
        );
        this.userId = DefaultValues.emptyString;
        this.setUserName(DefaultValues.emptyString);
        this.sessionId = DefaultValues.emptyString;
        this.userFullname = DefaultValues.emptyString;
    }


}
