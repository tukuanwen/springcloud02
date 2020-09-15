package com.tu.cloud01.entities;

//import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String msg;
    private T data;

    public CommonResult(Integer code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public CommonResult(Integer code, String msg) {
        this(code, msg, null);
    }

}
