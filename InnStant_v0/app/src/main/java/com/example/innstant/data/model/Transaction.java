package com.example.innstant.data.model;

import com.google.gson.annotations.SerializedName;

import java.security.Timestamp;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @SerializedName("_id")
    private _id _id;
    @SerializedName("transactionId")
    private String transactionId;
    @SerializedName("hostId")
    private String hostId;
    @SerializedName("guestId")
    private String guestId;
    @SerializedName("roomId")
    private String roomId;
    @SerializedName("transactionTimestamp")
    private Date transactionTimestamp;
    @SerializedName("bookStartDate")
    private Date bookStartDate;
    @SerializedName("bookEndDate")
    private Date bookEndDate;
    @SerializedName("paymentStatus")
    private String paymentStatus;
    @SerializedName("isBookingCanceled")
    private  Boolean isBookingCanceled;
}