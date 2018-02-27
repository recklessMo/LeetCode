package com.recklessMo.test;

import lombok.Data;

@Data
public class Room {
    private long roomId;
    private String roomName;
    private int totalCount;

    public Room(long roomId, String roomName, int totalCount){
        this.roomId = roomId;
        this.roomName = roomName;
        this.totalCount = totalCount;
    }
}
