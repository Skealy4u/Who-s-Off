package com.skealy.staffhelper;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class Login extends Activity {
    EditText ET_phone;
    EditText ET_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void clickReg(View v) {
        if (v.getId() == R.id.register) {
            Intent muki = new Intent(Login.this, Register.class);
            startActivity(muki);
        }
    }
    public void clickStu(View v) {
        if (v.getId() == R.id.student) {
            Intent muki = new Intent(Login.this, Studview.class);
            startActivity(muki);
        }
    }


    public void userLogin(View v) {
        if (v.getId() == R.id.userLogin) {
            ET_phone = (EditText) findViewById(R.id.phone);
            ET_pass = (EditText) findViewById(R.id.password);
            String name1 = ET_phone.getText().toString();
            String name2 = ET_pass.getText().toString();
            if (name1.contains("admin")&& name2.contains("malaianna")) {
                    Intent muki = new Intent(Login.this, Apply.class);
                    startActivity(muki);
            }
            else
                Toast.makeText(getApplicationContext(), "Incorrect password!!", Toast.LENGTH_SHORT).show();
        }
    }
}
