package com.example.androidaddedittextdynamically;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout containerLayout;
    static int totalEditTexts = 0;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        containerLayout = (LinearLayout)findViewById(R.id.relative1);
        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                totalEditTexts++;

                EditText editText = new EditText(getBaseContext());
              
                containerLayout.addView(editText);
                editText.setGravity(Gravity.LEFT);

                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) editText.getLayoutParams();
                layoutParams.width = LinearLayout.LayoutParams.MATCH_PARENT;
                layoutParams.setMargins(23, 34, 0, 0);

                editText.setLayoutParams(layoutParams);

                editText.setTag("EditText" + totalEditTexts);
            }
        });
    }


}