package com.example.innstant.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @SerializedName("_id")
    private String _id;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("id_card_number")
    private String idCardNumber;

    @SerializedName("phone_number")
    private String phoneNumber;

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    @SerializedName("pin")
    private String pin;

    @SerializedName("profile_photo")
    private String profilePhoto;

    @SerializedName("id_card_photo")
    private String idCardPhoto;

    @SerializedName("user_with_id_card_photo")
    private String userWithIdCardPhoto;

    @SerializedName("rooms")
    private List<Room> rooms;
}
