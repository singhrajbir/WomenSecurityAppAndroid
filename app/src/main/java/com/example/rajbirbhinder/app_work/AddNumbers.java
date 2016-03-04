package com.example.rajbirbhinder.app_work;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;
import android.provider.ContactsContract;
import android.database.Cursor;
import android.provider.Contacts.People;
import android.net.Uri;
import android.app.Activity;


public class AddNumbers extends ActionBarActivity {
    EditText Number1,Number2;
    db dbhandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_numbers);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        dbhandler= new db(this,null,null,1);
        if(dbhandler.number()==2) {
            String phoneNo1 = dbhandler.databaseToPhoneFirst();
            String phoneNo2 = dbhandler.databaseToPhoneSecond();
            Number1=(EditText)findViewById(R.id.Number1);
            Number2=(EditText)findViewById(R.id.Number2);
            Number1.setHint(phoneNo1);
            Number2.setHint(phoneNo2);
        }

    }

    public void addcontact1(View view)
    {
        Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(intent, 1);
    }

    public void addcontact2(View view)
    {
        Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(intent, 1);
    }


    public void Onclick(View view)
    {
        Number1=(EditText)findViewById(R.id.Number1);
        Number2=(EditText)findViewById(R.id.Number2);
        String n1=Number1.getText().toString();
        String n2=Number2.getText().toString();
        if(n1.length()!=10 || n2.length()!=10)
        {
            Toast.makeText(AddNumbers.this,"Invalid Phone Number. Please enter both 10 digit phone numbers....",Toast.LENGTH_LONG).show();
        }
        else {
            Intent i = new Intent(this, MainActivity.class);
            i.putExtra("Number1", n1);
            i.putExtra("Number2", n2);
            startActivity(i);
            overridePendingTransition  (R.anim.right_slide_in, R.anim.right_slide_out);
        }
    }
}
