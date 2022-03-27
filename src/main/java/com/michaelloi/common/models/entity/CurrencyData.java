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
@Table(name = "tbl_currency", schema = "public")
public class CurrencyData {
    @Id
    @Column(name = "currencyid")
    private String currencyId;
    @Column(name = "currencycode")
    private String currencyCode;
    @Column(name = "currencyname")
    private String currencyName;
    @Column(name = "bankbuyprice")
    private BigDecimal bankBuyPrice;
    @Column(name = "banksellprice")
    private BigDecimal bankSellPrice;
}
