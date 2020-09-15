package com.tu.cloud01.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    //主键ID
    private long id;
    //生成序列
    private String serial;

}
