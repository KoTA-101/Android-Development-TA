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
    @SerializedName("transaction_id")
    private String transactionId;
    @SerializedName("host_id")
    private String hostId;
    @SerializedName("guest_id")
    private String guestId;
    @SerializedName("room_id")
    private String roomId;
    @SerializedName("transaction_timestamp")
    private Date transactionTimestamp;
    @SerializedName("book_start_date")
    private Date bookStartDate;
    @SerializedName("book_end_date")
    private Date bookEndDate;
    @SerializedName("payment_status")
    private String paymentStatus;
}