package com.michaelloi.common.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@JsonSerialize
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "tbl_user", schema = "public")
public class UserData {
    @Id
    @Column(name = "userid")
    private String userId;
    @Column(name = "username")
    private String userName;
    @Column(name = "usernickname")
    private String userNickname;
    @Column(name = "userfullname")
    private String userFullname;
    @Column(name = "userdateofbirth")
    private Date userDateOfBirth;
    @Column(name = "lastlogin")
    private Date lastLogin;
    @Column(name = "sessionid")
    private String sessionId;
    @Column(name = "isactive")
    private Boolean isActive;
    @Column(name = "password")
    private String password;
}
