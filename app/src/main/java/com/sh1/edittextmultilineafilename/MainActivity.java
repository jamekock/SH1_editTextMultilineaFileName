package com.sh1.edittextmultilineafilename;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    TextView txtNameFile;
    TextView txtMultiLine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNameFile = findViewById(R.id.txtNameFile);
        txtMultiLine = findViewById(R.id.txtMultiline);
    }

    public void Save(View v){
        String name = txtNameFile.getText().toString();
        try {
            OutputStreamWriter osw = new OutputStreamWriter(openFileOutput(name + ".txt",MODE_PRIVATE));
            osw.write(txtMultiLine.getText().toString());
            osw.close();
            osw.flush();
            Toast.makeText(this,"Guardado correctamente",Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){

        }

    }

    public void Retrieve(View v){
        String name = txtNameFile.getText().toString();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput(name + ".txt")));
            txtMultiLine.setText(br.readLine());
            br.close();
            Toast.makeText(this,"Recuperado correctamente",Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){

        }
    }
}