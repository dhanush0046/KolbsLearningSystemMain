package com.example.studentdetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView t1,t2,t3,t4;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        t1 = findViewById(R.id.textView3);
        t2 = findViewById(R.id.textView4);
        t3 = findViewById(R.id.textView5);
        t4 = findViewById(R.id.textView6);

        if (getIntent().hasExtra("op1") && getIntent().hasExtra("op2") && getIntent().hasExtra("op3") && getIntent().hasExtra("op4")){
            t1.setText(getIntent().getStringExtra("op1"));
            //o1= Integer.parseInt(getIntent().getStringExtra("op1"));
            t2.setText(getIntent().getStringExtra("op2"));
            //o2= Integer.parseInt(getIntent().getStringExtra("op2"));
            t3.setText(getIntent().getStringExtra("op3"));
            //o3= Integer.parseInt(getIntent().getStringExtra("op3"));
            t4.setText(getIntent().getStringExtra("op4"));
            //o4= Integer.parseInt(getIntent().getStringExtra("op4"));
        }
        button=findViewById(R.id.result);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),GraphActivity.class);
                intent.putExtra("o1",t1.getText());
                intent.putExtra("o2",t2.getText());
                intent.putExtra("o3",t3.getText());
                intent.putExtra("o4",t4.getText());
                startActivity(intent);
            }
        });

    }


}