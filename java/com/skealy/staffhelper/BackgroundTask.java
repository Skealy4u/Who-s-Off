package com.skealy.staffhelper;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
public class BackgroundTask extends AsyncTask<String,Void,String>{

    Context ctx;
    BackgroundTask(Context ctx){
        this.ctx=ctx;
    }
   @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        String reg_url="http://10.0.2.2/staff/register.php";
        String login_url="http://127.0.0.1/staff/login.php";
        String method=params[0];
        if(method.equals("Register"))
        {

            String fname=params[1];
            String lname=params[2];
            String mail=params[3];
            String phone=params[4];
            String subject=params[5];
            String pass=params[6];
            try {
                URL url=new URL(reg_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.connect();
                OutputStream OS=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
                String data=
                        URLEncoder.encode("fname","UTF-8")+" = "+URLEncoder.encode(fname,"UTF-8")+" & "+
                        URLEncoder.encode("lname","UTF-8")+" = "+URLEncoder.encode(lname,"UTF-8")+" & "+
                        URLEncoder.encode("mail","UTF-8")+" = "+URLEncoder.encode(mail,"UTF-8")+" & "+
                        URLEncoder.encode("phone","UTF-8")+" = "+URLEncoder.encode(phone,"UTF-8")+" & "+
                        URLEncoder.encode("subject","UTF-8")+" = "+URLEncoder.encode(subject,"UTF-8")+" & "+
                        URLEncoder.encode("pass","UTF-8")+" = "+URLEncoder.encode(pass,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                //httpURLConnection.connect();
                httpURLConnection.disconnect();
                return "Registration Success...";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();
    }
}
