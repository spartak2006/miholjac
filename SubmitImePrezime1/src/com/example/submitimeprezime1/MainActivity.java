package com.example.submitimeprezime1;

import java.util.ArrayList;
import java.util.List;

import com.example.submitimeprezime1.models.UserModel;
import com.example.submitimeprezime1.utils.C;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

	private ArrayList<UserModel> mUsers = new ArrayList<UserModel>();

	private EditText mInputNameEditText;
	private EditText mInputLastNameEditText;
	private EditText mInputAddressEditText;

	private Button mSubmitButton;
	private Button mClearButton;
	private Button mAddButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initUi();
		initListener();

	}

	public void initUi() {

		mInputNameEditText = (EditText) findViewById(R.id.activity_main_name_editText);
		mInputLastNameEditText = (EditText) findViewById(R.id.activity_main_last_name_editText);
		mInputAddressEditText = (EditText) findViewById(R.id.activity_main_address_editText);

		mSubmitButton = (Button) findViewById(R.id.activity_main_submit_button);
		mClearButton = (Button) findViewById(R.id.activity_main_clear_button);
		mAddButton = (Button) findViewById(R.id.activity_main_add_button);
	}

	public void initListener() {

		mSubmitButton.setOnClickListener(mOnClickListener);
		mClearButton.setOnClickListener(mOnClickListener);
		mAddButton.setOnClickListener(mOnClickListener);
	}

	private OnClickListener mOnClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.activity_main_submit_button:
				String tempName = mInputNameEditText.getText().toString();
				String tempLastName = mInputLastNameEditText.getText()
						.toString();
				String tempAddress = mInputAddressEditText.getText().toString();

				// startsSecondActivity(tempName, tempLastName, tempAddress);

				break;
			case R.id.activity_main_clear_button:
				mInputNameEditText.setText("");
				mInputLastNameEditText.setText("");
				mInputAddressEditText.setText("");
				break;
			case R.id.activity_main_add_button:
				String firstName = mInputNameEditText.getText().toString();
				String lastName = mInputLastNameEditText.getText().toString();
				String address = mInputAddressEditText.getText().toString();
				UserModel user = createUser(firstName, lastName, address);
				addUserToList(user);
				Toast.makeText(MainActivity.this,
						"Trnutno u listi ima" + mUsers.size(),
						Toast.LENGTH_LONG).show();
				break;
			}

		}

		private void addUserToList(UserModel user) {
			mUsers.add(user);

		}

		private UserModel createUser(String firstName, String lastName,
				String address) {
			UserModel user = new UserModel();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setAddress(address);

			return user;
		}

		// private void startsSecondActivity(String tempName, String
		// tempLastName,
		// String tempAddress) {
		// Intent intent = new Intent(MainActivity.this, SecondActivity.class);
		// UserModel model = new UserModel();
		//
		// model.setFirstName(tempName);
		// model.setLastName(tempLastName);
		// model.setAddress(tempAddress);
		// intent.putExtra(C.MAIN_ACTIVITY_BUNDLE_KEY_USER, model);
		// startActivity(intent);
		//
		// }
	};
}
