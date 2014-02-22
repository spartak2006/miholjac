package com.example.submitimeprezime.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.submitimeprezime.R;
import com.example.submitimeprezime.models.UserModel;
import com.example.submitimeprezime.utills.C;

public class MainActivity extends BaseActivity {

	private EditText mInputEditTextIme;
	private EditText mInputEditTextPrezime;
	private EditText mInputEditTextAdresa;
	private Button mSubmitButton;
	private Button mCancelButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initUi();
		initListener();

	}

	public void initListener() {

		mSubmitButton.setOnClickListener(mClickListener);
		mCancelButton.setOnClickListener(mClickListener);

	}

	public void initUi() {
		mInputEditTextIme = (EditText) findViewById(R.id.activity_main_ime_editText);
		mInputEditTextPrezime = (EditText) findViewById(R.id.activity_main_prezime_editText);
		mInputEditTextAdresa = (EditText) findViewById(R.id.activity_main_adresa_editText);
		mSubmitButton = (Button) findViewById(R.id.activity_main_submit_button);
		mCancelButton = (Button) findViewById(R.id.activity_main_cancel_button);

	}

	private OnClickListener mClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.activity_main_submit_button:
				String tempIme = mInputEditTextIme.getText().toString();
				String tempPrezime = mInputEditTextPrezime.getText().toString();
				String tempAdresa = mInputEditTextAdresa.getText().toString();
				startSecondActivity(tempIme, tempPrezime, tempAdresa);
				break;
			case R.id.activity_main_cancel_button:
				mInputEditTextIme.setText("");
				mInputEditTextPrezime.setText("");
				mInputEditTextAdresa.setText("");
				break;

			}
		}
	};

	private void startSecondActivity(String tempIme, String tempPrezime,
			String tempAdresa) {

		Intent intent = new Intent(this, SecondActivity.class);

		UserModel model = new UserModel();

		model.setFirstName(tempIme);
		model.setLastName(tempPrezime);
		model.setAdresss(tempAdresa);

		intent.putExtra(C.MAIN_ACTIVITY_BUNDLE_KEY_USER, model);
		//
		// intent.putExtra(C.MAIN_ACTIVITY_BUNDLE_KEY_FIRST_NAME, tempIme);
		// intent.putExtra(C.MAIN_ACTIVITY_BUNDLE_KEY_LAST_NAME, tempPrezime);
		// intent.putExtra(C.MAIN_ACTIVITY_BUNDLE_KEY_ADRESS, tempAdresa);
		startActivity(intent);
	}
}
