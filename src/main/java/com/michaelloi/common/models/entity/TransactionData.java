package com.michaelloi.common.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@JsonSerialize
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "tbl_transaction", schema = "public")
public class TransactionData {
    @Id
    @Column(name = "transactionid")
    private String transactionId;
    @Column(name = "transactiontype")
    private String transactionType;
    @Column(name = "transactionfromccy")
    private String transactionFromCcy;
    @Column(name = "transactionfromamount")
    private BigDecimal transactionFromAmount;
    @Column(name = "transactiontoccy")
    private String transactionToCcy;
    @Column(name = "transactiontoamount")
    private BigDecimal transactionToAmount;
    @Column(name = "transactionprice")
    private BigDecimal transactionPrice;
    @Column(name = "transactiontotalprice")
    private BigDecimal transactionTotalPrice;
    @Column(name = "transactiondate")
    private Date transactionDate;
    @Column(name = "accountno")
    private String accountNo;
    @Column(name = "issuccess")
    private boolean isSuccess;
}
