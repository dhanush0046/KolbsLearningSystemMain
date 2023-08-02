package com.example.studentdetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionsActivity extends AppCompatActivity {

    TextView tv,tview1,tview2,tview3,tview4;
    Button submitbutton, quitbutton;
    EditText et1,et2,et3,et4;
    int current = 0;

    int op1Mark=0;
    int op2Mark=0;
    int op3Mark=0;
    int op4Mark=0;
    //GraphPoints gp=new GraphPoints();

    String questions[] = {
            "When I Learn?",
            "I learn best when?",
            "When I am learning?",
            "I learn by?",
            "When I learn?",
            "When I am Learning?",
            "I learn best when?",
            "When I Learn",
            "I learn best when?",
            "When I am learning?",
            "When I learn?",
            "I learn best when?"
    };
    String opt[][] = {
            {"I like to be doing things", "I like to watch and listen", "I like to deal with my feelings", "I like to think about Ideas"},
            {"Work hard to get things done", "I listen and watch carefully", "I rely on logical thinking", "I trust my hunches and feelings"},
            {"I have strong feelings and reactions", "I am quiet and reserved", "I tend to reason things out", "I am responsible about things"},
            {"Feeling","Watching" ,"Thinking","Doing"},
            {"I am open to new experiences", "Look at all sides of the issues", "I analyze and break things into parts", "I like to try things out"},
            {"I am an  intuitive person", "I am observing person", "I am a logical person", "I am an active person"},
            {"Personal relationship", "Observation", "Rational theories", "A change to try out and practice"},
            {"I feel personally involved","I take time before acting", "I like ideas and theories" ,"I like to see  results from my work"},
            {"I rely on my feelings","I rely on my observation","I rely on my Ideas","I can try things out for myself"},
            {"I am an accepting person","I am an reserved person", "I am a rational person", "I am a responsible person"},
            {"I get involve", "I like to observe", "I evaluate things","I like to active"},
            {"I am receptive", "I am careful","I analyse ideas","I am practical"}
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        TextView textView=(TextView)findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name= intent.getStringExtra("myname");

        if (name.trim().equals(""))
            textView.setText("Hello User");
        else
            textView.setText("Hello " + name);

        question();

    }

    private void question(){
        submitbutton = (Button) findViewById(R.id.button2);
        quitbutton = (Button) findViewById(R.id.button3);
        tv = (TextView) findViewById(R.id.tvque);

        et1=findViewById(R.id.edt1);
        et2=findViewById(R.id.edt2);
        et3=findViewById(R.id.edt3);
        et4=findViewById(R.id.edt4);

        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");

        tview1 = findViewById(R.id.tv1);
        tview2 = findViewById(R.id.tv2);
        tview3 = findViewById(R.id.tv3);
        tview4 = findViewById(R.id.tv4);

        tv.setText(questions[current]);
        tview1.setText(opt[current][0]);
        tview2.setText(opt[current][1]);
        tview3.setText(opt[current][2]);
        tview4.setText(opt[current][3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                current++;
                try {
                    if (!et1.getText().toString().isEmpty() && !et2.getText().toString().isEmpty() && !et3.getText().toString().isEmpty() && !et4.getText().toString().isEmpty()) {

                        op1Mark = op1Mark + Integer.parseInt(String.valueOf(et1.getText()));
                        op2Mark = op2Mark + Integer.parseInt(String.valueOf(et2.getText()));
                        op3Mark = op3Mark + Integer.parseInt(String.valueOf(et3.getText()));
                        op4Mark = op4Mark + Integer.parseInt(String.valueOf(et4.getText()));

                        if (current < questions.length) {
                            question();
                        } else {
                            Intent in = new Intent(getApplicationContext(), ResultActivity.class);
                            in.putExtra("op1",String.valueOf(op1Mark));
                            in.putExtra("op2",String.valueOf(op2Mark));
                            in.putExtra("op3",String.valueOf(op3Mark));
                            in.putExtra("op4",String.valueOf(op4Mark));
                            startActivity(in);
                        }
                    }else {
                        Toast.makeText(QuestionsActivity.this, "Please Give Your Mark", Toast.LENGTH_SHORT).show();
                    }

                }catch (Exception e){
                    Log.d("error",e.toString());
                    Toast.makeText(QuestionsActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                }

            }
        });
        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });

    }
}