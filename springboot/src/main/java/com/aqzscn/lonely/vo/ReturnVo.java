package com.aqzscn.lonely.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnVo {

    private Integer code;

    private String msg;

    private Object data;

    public static ReturnVo success() {
        ReturnVo vo = new ReturnVo();
        vo.setCode(GlobalNames.success);
        vo.setMsg("操作成功");
        return vo;
    }

    public static ReturnVo success(Object data) {
        ReturnVo vo = new ReturnVo();
        vo.setCode(GlobalNames.success);
        vo.setMsg("操作成功");
        vo.setData(data);
        return vo;
    }

    public static ReturnVo success(String msg, Object data) {
        ReturnVo vo = new ReturnVo();
        vo.setCode(GlobalNames.success);
        vo.setMsg(msg);
        vo.setData(data);
        return vo;
    }

    public static ReturnVo error() {
        ReturnVo vo = new ReturnVo();
        vo.setCode(GlobalNames.unknownError);
        vo.setMsg("操作失败");
        return vo;
    }

    public static ReturnVo error(String msg) {
        ReturnVo vo = new ReturnVo();
        vo.setCode(GlobalNames.unknownError);
        vo.setMsg(msg);
        return vo;
    }

}
