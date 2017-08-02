package com.skealy.staffhelper;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by Saravanan on 6/15/2016.
 */

public class Apply extends Activity {
    private EditText editText2,editText3,editText4;
    private DatePicker dp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apply);
        init();
        Button btnEmail=(Button)findViewById(R.id.button8);
        btnEmail.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String name1 = editText2.getText().toString();
                String name2 = editText3.getText().toString();
                String name3 = editText4.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.setType("message/rfc822");
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"ceo@skealy.com"});

                email.putExtra(Intent.EXTRA_SUBJECT, "LEAVE FORM -("+dp.getDayOfMonth()+"/"+dp.getMonth()+"/"+dp.getYear()+")");

                email.putExtra(Intent.EXTRA_TEXT, name1 + "\n" + name2 + " Department\n" + "Sathyabama University\nChennai\n\n\nDear Sir,\n" + "Please accept this letter as written notification ,Reason(" + name3+")("+dp.getDayOfMonth()+"/"+dp.getMonth()+"/"+dp.getYear()+")"+"Please let me know if you have any other questions.\n\n Sincerely,\n"+name1);

                try {
                    startActivity(Intent.createChooser(email, "Pick an Email Client!"));
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "There are no email clients installed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void init()
    {
        dp=(DatePicker)findViewById(R.id.dp);
        editText2=(EditText)findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
    }
    public boolean onKeyDown(int keyCode,KeyEvent event){
        if((keyCode== KeyEvent.KEYCODE_BACK)) {
            Intent muki = new Intent(Apply.this,Login.class);
            startActivity(muki);
        }
        return super.onKeyDown(keyCode,event);
    }
}


