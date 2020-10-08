package com.example.androidaddedittextdynamically;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class MainActivity4 extends AppCompatActivity {

    LinearLayout ll_newView;
    ScrollView scrollView;
    Button bt_addView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        ll_newView = (LinearLayout)findViewById(R.id.ll_newView);
        scrollView = (ScrollView)findViewById(R.id.scrollView);
        bt_addView = (Button)findViewById(R.id.bt_addView);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout one = new LinearLayout(MainActivity4.this);


        //=====First EditText======//
        params.weight = 5.0f;
        params.setMargins(16,8,8,16);
        EditText et_one = new EditText(MainActivity4.this);
        et_one.setPadding(10,10,10,10);
        et_one.setHint("Edit Text 1");
        et_one.setBackground(getResources().getDrawable(R.drawable.ic_launcher_background));
        et_one.setLayoutParams(params);
        one.addView(et_one);

        //=====Second EditText======//
        EditText  et_two = new EditText(MainActivity4.this);
        et_two.setPadding(10,10,10,10);
        et_two.setHint("Edit Text 2");
        et_two.setBackground(getResources().getDrawable(R.drawable.ic_launcher_background));
        et_two.setLayoutParams(params);
        one.addView(et_two);


        Button bt_plus = new Button(MainActivity4.this);
        bt_plus.setText("+");


        one.addView(bt_plus);


        ll_newView.addView(one);

        bt_plus.setOnClickListener(getOnClickDoSomething(et_one.getText().toString().trim(),et_two.getText().toString().trim()));


    }

    View.OnClickListener getOnClickDoSomething(final String one1, final String two1)  {
        return new View.OnClickListener() {
            public void onClick(View v) {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);

                LinearLayout one = new LinearLayout(MainActivity4.this);
                Log.e("========","=====one ="+one1+"=========two = "+two1);
                //=====First EditText======//
                params.weight = 5.0f;
                params.setMargins(16,8,8,16);
                EditText  et_one = new EditText(MainActivity4.this);
                et_one.setPadding(10,10,10,10);
                et_one.setHint("Edit Text 1");
                et_one.setBackground(getResources().getDrawable(R.drawable.ic_launcher_background));
                et_one.setLayoutParams(params);
                one.addView(et_one);

                //=====Second EditText======//
                EditText  et_two = new EditText(MainActivity4.this);
                et_two.setPadding(10,10,10,10);
                et_two.setHint("Edit Text 2");
                et_two.setBackground(getResources().getDrawable(R.drawable.ic_launcher_background));
                et_two.setLayoutParams(params);
                one.addView(et_two);


                Button bt_plus = new Button(MainActivity4.this);
                bt_plus.setText("+");

                one.addView(bt_plus);



                ll_newView.addView(one);

                bt_plus.setOnClickListener(getOnClickDoSomething(et_one.getText().toString().trim(),et_two.getText().toString().trim()));
                Log.e("========","=====one ="+et_one.getText().toString().trim()+"=========two = "+ et_two.getText().toString().trim());

            }
        };
    }


}