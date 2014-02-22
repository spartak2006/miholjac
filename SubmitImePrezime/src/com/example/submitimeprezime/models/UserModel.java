package com.example.submitimeprezime.models;

import android.os.Parcel;
import android.os.Parcelable;

public class UserModel implements Parcelable {
	private String firstName;
	private String lastName;
	private String adresss;

	// ovo netreba al eto nek se nadje idiote
	// public UserModel(String firstName, String lastName,String adress){
	// this.firstName=firstName;
	// this.lastName=lastName;
	// this.adresss=adress;
	// }
	public UserModel() {

	}

	private UserModel(Parcel in) {
		firstName = in.readString();
		lastName = in.readString();
		adresss = in.readString();
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

	public String getAdresss() {
		return adresss;
	}

	public void setAdresss(String adresss) {
		this.adresss = adresss;
	}

	@Override
	public int describeContents() {

		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(firstName);
		dest.writeString(lastName);
		dest.writeString(adresss);

	}

	public static final Parcelable.Creator<UserModel> CREATOR = new Creator<UserModel>() {

		@Override
		public UserModel[] newArray(int size) {

			return new UserModel[size];
		}

		@Override
		public UserModel createFromParcel(Parcel source) {

			return new UserModel(source);
		}
	};

}
