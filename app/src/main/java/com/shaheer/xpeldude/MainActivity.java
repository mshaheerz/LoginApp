package com.shaheer.xpeldude;
import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.webkit.*;
import android.webkit.WebView;
import android.webkit.WebViewClient; 
import android.widget.EditText;
import android.widget.Toast;

import android.widget.*;
public class MainActivity extends Activity 
{
	Button bt_login;
	EditText tx_email ,tx_password;


	String stremail ,strpass;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		bt_login = findViewById(R.id.bt_login);
		tx_email = findViewById(R.id.tx_email);
		tx_password = findViewById(R.id.tx_password);

		bt_login.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {

					stremail=tx_email.getText().toString();
					strpass=tx_password.getText().toString();

					if(stremail.equals("abcd") && strpass.equals("123")){
						Intent intent = new Intent(MainActivity.this,
												   HomeActivity.class);
						startActivity(intent);

					}

					else { 
						Toast.makeText(getApplicationContext(),"failed",Toast.LENGTH_SHORT).show();  

					}
				}
			});
	}}

