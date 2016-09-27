package com.example.aashishssg.a1rexmapcalculator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Aashish SSG on 6/3/2016.
 */
public class OneRepMaxes extends Fragment{

    private Button FiveDec;
    private Button FiveInc;
    private Button Calculate;
    private EditText weights;
    private EditText reps;
    private TextView oneRepMaximum;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        weights = (EditText) rootView.findViewById(R.id.editText);
        reps = (EditText) rootView.findViewById(R.id.editText2);
        FiveDec = (Button) rootView.findViewById(R.id.button);
        FiveInc = (Button) rootView.findViewById(R.id.button2);
        Calculate = (Button) rootView.findViewById(R.id.button3);
        oneRepMaximum = (TextView) rootView.findViewById(R.id.textView3);

        FiveDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contents = weights.getText().toString();
                int content = 0;
                if(!contents.equals(""))content = Integer.parseInt(contents);
                content -= 5;
                if(content>=0) {weights.setText(content+"");}
                else Toast.makeText(getContext(), "The weight input cannot be negative.", Toast.LENGTH_SHORT).show();
            }
        });

        FiveInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contents = weights.getText().toString();
                int content;
                if(!contents.equals(""))content = Integer.parseInt(contents);
                else content = 0;
                content += 5;
                weights.setText(content+"");
            }
        });

        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!reps.getText().toString().equals("") && !reps.getText().toString().equals("0") && reps.getText().toString()!=null
                        && !weights.getText().toString().equals("") && !weights.getText().toString().equals("0") && weights.getText().toString()!=null){

                    int repetitions = Integer.parseInt(reps.getText().toString());
                    int weightsUsed = Integer.parseInt(weights.getText().toString());

                    if(repetitions>=10){Toast.makeText(getContext(), "Warning! The calculator may be inaccurate \n\t\t\t\t\t\t\t\t\tafter 10 repetitions!", Toast.LENGTH_SHORT).show();}

                    double oneRepMax = (repetitions*weightsUsed*(0.03333)) + weightsUsed;

                    if (repetitions==1) oneRepMax = weightsUsed;

                    oneRepMaximum.setText(((int)oneRepMax)+"");

                } else {
                    Toast.makeText(getContext(), "Error! Need input Values!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return rootView;
    }
}
