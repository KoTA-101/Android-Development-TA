package com.example.innstant.data.model;

<<<<<<< HEAD
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
=======
import android.graphics.Bitmap;

public class User {
    private String firstName;
    private String lastName;
    private Integer idCardNumber;
    private Integer phoneNumber;
    private String email;
    private String password;
    private Integer pin;
    private Bitmap profilePhoto;
    private String idCardPhoto;
    private String userWithIdCardPhoto;
    private String rooms;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(Integer idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    public Bitmap getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(Bitmap profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getIdCardPhoto() {
        return idCardPhoto;
    }

    public void setIdCardPhoto(String idCardPhoto) {
        this.idCardPhoto = idCardPhoto;
    }

    public String getUserWithIdCardPhoto() {
        return userWithIdCardPhoto;
    }

    public void setUserWithIdCardPhoto(String userWithIdCardPhoto) {
        this.userWithIdCardPhoto = userWithIdCardPhoto;
    }

    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }
>>>>>>> 02a2f7a78a8b7d6e8485c9ae1aa1e6379e27d2c5
}
