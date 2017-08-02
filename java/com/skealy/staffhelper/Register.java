package com.skealy.staffhelper;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Saravanan on 8/25/2016.
 */
public class Register extends Activity {
   EditText ET_fname,ET_lname,ET_mail,ET_phone,ET_subject,ET_pass;
    String fname,lname,mail,phone,subject,pass;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        ET_fname=(EditText)findViewById(R.id.fname);
        ET_lname=(EditText)findViewById(R.id.lname);
        ET_mail=(EditText)findViewById(R.id.mail);
        ET_phone=(EditText)findViewById(R.id.phone);
        ET_subject=(EditText)findViewById(R.id.subject);
        ET_pass=(EditText)findViewById(R.id.pass);
    }
    public void userReg(View view)
    {
        if (view.getId() == R.id.button) {

            fname = ET_fname.getText().toString();
            lname = ET_lname.getText().toString();
            mail = ET_mail.getText().toString();
            phone = ET_phone.getText().toString();
            subject = ET_subject.getText().toString();
            pass = ET_pass.getText().toString();
            String method = "Register";
            BackgroundTask backgroundTask = new BackgroundTask(this);
            backgroundTask.execute(method, fname, lname, mail, phone, subject, pass);
            finish();
        }

    }
}
