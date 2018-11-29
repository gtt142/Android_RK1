package ru.student.tp_rk1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private final Integer minNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout fieldLayout = findViewById(R.id.field);

        Integer strNumber = 100;
        for (int i = 0; i < strNumber; i++) {
            LinearLayout rowLayout = new LinearLayout(this);
            rowLayout.setOrientation(LinearLayout.HORIZONTAL);

            LinearLayout.LayoutParams parameters = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1f
            );

            final Button plus = new Button(this);
            final Button minus = new Button(this);
            final TextView tv = new TextView(this);

            plus.setText("+");
            minus.setText("-");
            tv.setText("0");
            tv.setGravity(Gravity.CENTER);

            plus.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Integer num = Integer.parseInt(tv.getText().toString());
                    num++;
                    String str = String.format(Locale.getDefault(), "%d",num);
                    tv.setText(str);
                    if (num >= minNum) {
                        LinearLayout row = (LinearLayout) v.getParent();
                        LinearLayout parent = (LinearLayout) row.getParent();
                        row.setBackgroundColor(parent.getSolidColor());
                    }
                }
            });

            minus.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Integer num = Integer.parseInt(tv.getText().toString());
                    num--;
                    String str = String.format(Locale.getDefault(), "%d",num);
                    tv.setText(str);
                    if (num < minNum) {
                        LinearLayout row = (LinearLayout) v.getParent();
                        row.setBackgroundColor(Color.RED);
                    }
                }
            });

            rowLayout.addView(tv, parameters);
            rowLayout.addView(plus, parameters);
            rowLayout.addView(minus, parameters);

            fieldLayout.addView(rowLayout);
        }
    }
}
