package com.example.l7t5;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class MainActivity extends AppCompatActivity
{
    Context context = null;
    EditText inputText;
    EditText fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        inputText = (EditText) findViewById(R.id.editTextTextMultiLine);
        fileName = (EditText) findViewById(R.id.editTextTextPersonName2);
    }


    public void readFile(View v)
    {
        try
        {
            InputStream in = context.openFileInput(String.valueOf(fileName.getText()));
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String s = "";

            while ((s = br.readLine()) != null)
            {
                inputText.setText(s);
            }
            in.close();
        }
        catch (IOException e)
        {
            Log.e("IOException", "Virhe syötteessä.");
        }
    }


    public void writeFile(View y)
    {
        try
        {
            OutputStreamWriter osw = new OutputStreamWriter(context.openFileOutput("newFile.txt", MODE_PRIVATE));
            osw.write(String.valueOf(inputText.getText()));
            osw.close();
        }
        catch (IOException e)
        {
            Log.e("IOException", "Virhe syötteessä.");
        }
    }
}