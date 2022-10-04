package com.example.c4_p33;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    static final String alpha = "abcdefghijklmnopqrstuvwxyz";
    public int shift;
    TextView textView, cipher;
    EditText keys;
    Button encrypt;


    public static String encryptor(String message, int key) {
        //referenced from https://www.topcoder.com/thrive/articles/caesar-cipher-in-java-encryption-and-decryption
        String cipherText = "";
        for (int i = 0; i < message.length(); i++) {
            int charPosition = alpha.indexOf(message.charAt(i));
            int keyVal = (key + charPosition) % 26;
            char replaceVal = alpha.charAt(keyVal);
            cipherText += replaceVal;

        }
        return cipherText;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String word = intent.getStringExtra("WORD");


        cipher = (TextView) findViewById(R.id.cipher);
        textView = (TextView) findViewById(R.id.textView);
        Log.i("word2", word);
        keys = (EditText) findViewById(R.id.keytext);





        encrypt = (Button) findViewById(R.id.encrypt);
        encrypt.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              int key = Integer.parseInt(keys.getText().toString());
               intent.putExtra("saved_key", key);
               String res = encryptor(word, key);
               cipher.setText(res);


            }
        });
    }
}