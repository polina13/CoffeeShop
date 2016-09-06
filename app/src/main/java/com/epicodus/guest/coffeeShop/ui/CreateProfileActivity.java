package com.epicodus.guest.coffeeShop.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.epicodus.guest.coffeeShop.Constants;
import com.epicodus.guest.coffeeShop.R;
import com.epicodus.guest.coffeeShop.models.Profile;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class CreateProfileActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = CreateProfileActivity.class.getSimpleName();
    @Bind(R.id.createUserButton) Button mCreateUserButton;
    @Bind(R.id.nameEditText) EditText mNameEditText;
    @Bind(R.id.emailEditText) EditText mEmailEditText;
    @Bind(R.id.passwordEditText) EditText mPasswordEditText;
    @Bind(R.id.confirmPasswordEditText) EditText mConfirmPasswordEditText;
    @Bind(R.id.coffeePreferenceEditText) EditText mCoffeePreferenceEditText;
    @Bind(R.id.loginTextView) TextView mLoginTextView;
    private Firebase mFirebaseRef;
    private SharedPreferences.Editor mSharedPreferencesEditor;
    private SharedPreferences mSharedPreferences;


    public void hideKeyboard(EditText editText) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);
        ButterKnife.bind(this);
        mFirebaseRef = new Firebase(Constants.FIREBASE_URL);
        mCreateUserButton.setOnClickListener(this);
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mSharedPreferencesEditor = mSharedPreferences.edit();
    }

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(context));
    }


    @Override
    public void onClick(View view) {
        if (view == mCreateUserButton) {
            createNewUser();
        }
    }
    public void createNewUser() {
        final String name = mNameEditText.getText().toString();
        final String email = mEmailEditText.getText().toString();
        final String password = mPasswordEditText.getText().toString();
        final String confirmPassword = mConfirmPasswordEditText.getText().toString();
        final String coffeePreference = mCoffeePreferenceEditText.getText().toString();

        boolean validEmail = isValidEmail(email);
        boolean validName = isValidName(name);
        boolean validPassword = isValidPassword(password, confirmPassword);
        if (!validEmail || !validName || !validPassword) return;

        mFirebaseRef.createUser(email, password, new Firebase.ValueResultHandler<Map<String, Object>>() {
            @Override
            public void onSuccess(Map<String, Object> result) {
                String uid = result.get("uid").toString();
                createUserInFirebaseHelper(name, email, uid, uid);
                mFirebaseRef.authWithPassword(email, password, new Firebase.AuthResultHandler() {

                    @Override
                    public void onAuthenticated(AuthData authData) {
                        if (authData != null) {
                            String userUid = authData.getUid();

                            String userInfo = authData.toString();
                            Log.d(TAG, "Currently logged in: " + userInfo);

                            mSharedPreferencesEditor.putString(Constants.KEY_UID, userUid).apply();
                            Intent intent = new Intent(CreateProfileActivity.this, MainActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                            finish();
                            hideKeyboard(mConfirmPasswordEditText);
                        }
                    }

                    @Override
                    public void onAuthenticationError(FirebaseError firebaseError) {
                        switch (firebaseError.getCode()) {
                            case FirebaseError.INVALID_EMAIL:
                            case FirebaseError.USER_DOES_NOT_EXIST:
                                mEmailEditText.setError("Please check that you entered your email correctly");
                                break;
                            case FirebaseError.INVALID_PASSWORD:
                                mEmailEditText.setError(firebaseError.getMessage());
                                break;
                            case FirebaseError.NETWORK_ERROR:
                                showErrorToast("There was a problem with the network connection");
                                break;
                            default:
                                showErrorToast(firebaseError.toString());
                        }
                    }
                });
            }

            @Override
            public void onError(FirebaseError firebaseError) {
                Log.d(TAG, "error occurred " +
                        firebaseError);
            }
        });

    }

    private void showErrorToast(String message) {
        Toast.makeText(CreateProfileActivity.this, message, Toast.LENGTH_LONG).show();
    }

    private void createUserInFirebaseHelper(final String name, final String email, final String coffeePreference, final String uid) {
        final Firebase userLocation = new Firebase(Constants.FIREBASE_URL_USERS).child(uid);
        Profile newProfile = new Profile(name, email, coffeePreference);
        userLocation.setValue(newProfile);
    }

    private boolean isValidEmail(String email) {
        boolean isGoodEmail =
                (email != null && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches());
        if (!isGoodEmail) {
            mEmailEditText.setError("Please enter a valid email address");
            return false;
        }
        return isGoodEmail;
    }

    private boolean isValidName(String name) {
        if (name.equals("")) {
            mNameEditText.setError("Please enter your name");
            return false;
        }
        return true;
    }

    private boolean isValidPassword(String password, String confirmPassword) {
        if (password.length() < 5) {
            mPasswordEditText.setError("The password should be at least 5 characters long");
            return false;
        } else if (!password.equals(confirmPassword)) {
            mPasswordEditText.setError("Passwords do not match");
            return false;
        }
        return true;
    }
}