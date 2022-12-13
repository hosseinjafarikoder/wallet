package com.digipay.wallet.base;

import lombok.*;

import java.util.Date;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class BaseDto {

    private Date createDate;

    private Date updateDate;
}
