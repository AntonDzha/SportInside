package com.example.sportinside;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText teamName = (EditText)findViewById(R.id.teamByNameSearch);
        Button actButton1 = (Button)findViewById(R.id.teamByNameBtn);
        actButton1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent();
                        intent.setClass(getApplicationContext(), TeamByNameActivity.class);
                        intent.putExtra("TeamName", teamName.getText().toString());
                        startActivity(intent);

                    }
                }
        );
    }
}
