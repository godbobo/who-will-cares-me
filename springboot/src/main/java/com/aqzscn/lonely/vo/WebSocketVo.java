package com.aqzscn.lonely.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// WebSocket 消息对象
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebSocketVo {

    private String type = "";

    private Object data;

}
