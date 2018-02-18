package com.example.elliot.myfirstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        /** Going to see if putting my code in here makes it work, but first to test that the app still functions*/
        String[] curses = new String[]{"fuck", "shit", "cock", "fucker", "cunt", "motherfucker", "asshole"};
        String[] passives = new String[]{"meh", "whatever", "ok"};


        String[] text = message.toLowerCase().split("\\s+");

        boolean curse_counter = false;
        boolean passive_counter = false;

        boolean search_curse = true;
        boolean search_passive = true;

        if(search_curse == true) {
            for (String base : text) {
                for (String curse : curses) {
                    if (base.equals(curse)) {
                        curse_counter = true;
                    }
                }
            }
        }
        if(search_passive == true) {
            for (String base : text) {
                for (String passive : passives) {
                    if (base.equals(passive)) {
                        passive_counter = true;
                    }
                }
            }
        }
        if(passive_counter==true & curse_counter==true){
            message = "You've got some issues to work out. Try something else";
        }
        if(curse_counter==true & passive_counter==false){
            message = "Maybe go easy with the cursing";
        }
        if(passive_counter==true & curse_counter==false){
            message = "Try being more active!";
        }

        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

}
