package com.example.submitimeprezime.activities;

import com.example.submitimeprezime.R;
import com.example.submitimeprezime.models.UserModel;
import com.example.submitimeprezime.utills.C;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends BaseActivity {

	private TextView mTextViewIme;
	private TextView mTextViewPrezime;
	private TextView mTextViewAdresa;
	//
	// private String firstNameFromMainActivity;
	// private String lastNameFromMainActivity;
	// private String adressFormMainActivity;

	private UserModel mUserModel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		initUi();
		Bundle extras = getIntent().getExtras();

		if (extras != null) {
			initExtras(extras);
		}
		setTitleText();
	}

	@Override
	public void initUi() {
		mTextViewIme = (TextView) findViewById(R.id.activity_second_ime_textView);
		mTextViewPrezime = (TextView) findViewById(R.id.activity_second_prezime_textView);
		mTextViewAdresa = (TextView) findViewById(R.id.activity_second_adresa_textView);
	}

	private void initExtras(Bundle extras) {
		mUserModel = extras.getParcelable(C.MAIN_ACTIVITY_BUNDLE_KEY_USER);
		//
		// firstNameFromMainActivity = extras
		// .getString(C.MAIN_ACTIVITY_BUNDLE_KEY_FIRST_NAME);
		// lastNameFromMainActivity = extras
		// .getString(C.MAIN_ACTIVITY_BUNDLE_KEY_LAST_NAME);
		// adressFormMainActivity = extras
		// .getString(C.MAIN_ACTIVITY_BUNDLE_KEY_ADRESS);

	}

	public void setTitleText() {

		mTextViewIme.setText(mUserModel.getFirstName());
		mTextViewPrezime.setText(mUserModel.getLastName());
		mTextViewAdresa.setText(mUserModel.getAdresss());

		// mTextViewIme.setText(firstNameFromMainActivity);
		// mTextViewPrezime.setText(lastNameFromMainActivity);
		// mTextViewAdresa.setText(adressFormMainActivity);

	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub

	}

}
