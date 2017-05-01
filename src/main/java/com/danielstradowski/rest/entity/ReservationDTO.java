package com.danielstradowski.rest.entity;

import java.util.Date;
import java.util.UUID;

public class ReservationDTO {

    private UUID id;

    private Date startDate;

    private Date endDate;

    private UUID roomId;

    private UUID customerId;

    private boolean isCanceled;

    public ReservationDTO() {
    }

    public ReservationDTO(UUID id, Date startDate, Date endDate, UUID roomId, UUID customerId, boolean isCanceled) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.roomId = roomId;
        this.customerId = customerId;
        this.isCanceled = isCanceled;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public UUID getRoomId() {
        return roomId;
    }

    public void setRoomId(UUID roomId) {
        this.roomId = roomId;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public boolean isCanceled() {
        return isCanceled;
    }

    public void setCanceled(boolean canceled) {
        isCanceled = canceled;
    }
}
