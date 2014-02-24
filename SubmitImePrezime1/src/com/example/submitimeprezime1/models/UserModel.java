package com.example.submitimeprezime1.models;

import android.os.Parcel;
import android.os.Parcelable;

public class UserModel implements Parcelable {

	private String firstName;
	private String lastName;
	private String address;

	public UserModel() {

	}

	public UserModel(Parcel in) {
		firstName = in.readString();
		lastName = in.readString();
		address = in.readString();

	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int describeContents() {

		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(firstName);
		dest.writeString(lastName);
		dest.writeString(address);

	}

	public static final Parcelable.Creator<UserModel> CREATOR = new Creator<UserModel>() {

		@Override
		public UserModel createFromParcel(Parcel source) {

			return new UserModel(source);
		}

		@Override
		public UserModel[] newArray(int size) {

			return new UserModel[size];
		}
	};
}
