package com.example.burgercaloriecounter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private  Integer pattyCal = 0;
    private  Integer pCal = 0;
    private Integer cheeseCal = 0;
    private Integer sauceCal = 0;
    private Integer cal = pattyCal+pCal+cheeseCal+sauceCal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        RadioGroup radioGroup2 = findViewById(R.id.radioGroup2);

        SeekBar simpleSeekBar = findViewById(R.id.seekBar) ;

        CheckBox checkBoxProsc = findViewById(R.id.proscuitto);
        TextView calorie = findViewById(R.id.calorie);

        calorie.setText("Calories: "+Integer.toString(cal));


        radioGroup.setOnCheckedChangeListener(
                new RadioGroup
                        .OnCheckedChangeListener() {
                    public void onCheckedChanged(RadioGroup group,
                                                 int checkedId)
                    {
                        RadioButton
                                radioButton
                                = (RadioButton)group
                                .findViewById(checkedId);

                        switch ((String)radioButton.getText()) {
                            case "Beef Patty":
                                pattyCal = 120;
                                break;
                            case "Lamb Patty":
                                pattyCal = 190;
                                break;
                            case "Ostrich Patty":
                                pattyCal = 170;
                                break;
                            default:
                                pattyCal = 0;
                                break;
                        }
                        cal = pattyCal+pCal+cheeseCal+sauceCal;
                        calorie.setText("Calories: "+Integer.toString(cal));
                    }
                });

        radioGroup2.setOnCheckedChangeListener(
                new RadioGroup
                        .OnCheckedChangeListener() {
                    public void onCheckedChanged(RadioGroup group,
                                                 int checkedId)
                    {
                        RadioButton
                                radioButton
                                = (RadioButton)group
                                .findViewById(checkedId);

                        switch ((String)radioButton.getText()) {
                            case "Asiago Cheese":
                                cheeseCal = 100;
                                break;
                            case "Creme Fraiche":
                                cheeseCal = 130;
                                break;
                            default:
                                cheeseCal = 0;
                                break;
                        }
                        cal = pattyCal+pCal+cheeseCal+sauceCal;
                        calorie.setText("Calories: "+Integer.toString(cal));
                    }
                });

        checkBoxProsc.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
                        pCal = 125;
                        cal = pattyCal+pCal+cheeseCal+sauceCal;
                        calorie.setText("Calories: "+Integer.toString(cal));
                    }
                }
        );

        simpleSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                sauceCal = progressChangedValue;
                cal = pattyCal+pCal+cheeseCal+sauceCal;
                calorie.setText("Calories: "+Integer.toString(cal));

//                Toast.makeText(MainActivity.this, "Seek bar progress is :" + progressChangedValue,
//                        Toast.LENGTH_SHORT).show();
            }
        });

    };


}