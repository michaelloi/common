package com.michaelloi.common.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@JsonSerialize
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "tbl_account", schema = "public")
public class AccountData {
    @Id
    @Column(name = "accountid")
    private String accountId;
    @Column(name = "accountno")
    private String accountNo;
    @Column(name = "accountccy")
    private String accountCcy;
    @Column(name = "accountbalance")
    private BigDecimal accountBalance;
    @Column(name = "userid")
    private String userId;
}
