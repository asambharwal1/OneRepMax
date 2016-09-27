package com.example.aashishssg.a1rexmapcalculator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Aashish SSG on 6/3/2016.
 */
public class Percentages extends Fragment{

    private ListView list;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> percList = new ArrayList<String>();
    private EditText editText;
    private Button FiveDec;
    private Button FiveInc;
    private Button Calculator;
    private int Weight = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View rootView = inflater.inflate(R.layout.fragment_percentage, container, false);
        list = (ListView) rootView.findViewById(R.id.listView);
        editText = (EditText) rootView.findViewById(R.id.editText3);
        FiveDec = (Button) rootView.findViewById(R.id.button4);
        FiveInc = (Button) rootView.findViewById(R.id.button5);
        Calculator = (Button) rootView.findViewById(R.id.button6);

        refreshList(0);

        adapter = new ArrayAdapter<String>(getContext(), R.layout.da_item, percList);

        list.setAdapter(adapter);

        FiveDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contents = editText.getText().toString();
                int content = 0;
                if(!contents.equals(""))content = Integer.parseInt(contents);
                System.out.print(contents);
                content -= 5;
                if(content>=0){editText.setText(content+"");}
                else Toast.makeText(getContext(), "The weight input cannot be negative.", Toast.LENGTH_SHORT).show();
            }
        });

        FiveInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contents = editText.getText().toString();
                int content = 0;
                if(!contents.equals(""))content = Integer.parseInt(contents);
                content += 5;
                editText.setText(content+"");
            }
        });

        Calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contents = editText.getText().toString();
                if(!contents.equals("")){
                    percList.clear();
                    refreshList(Integer.parseInt(contents));
                    System.out.println(percList.get(0));

                    adapter = new ArrayAdapter<String>(getContext(), R.layout.da_item, percList);

                    list.setAdapter(adapter);
                }
            }
        });

        return rootView;
    }
    ///"\t\t\t\t\t\t\t\t\t\t\t"


    public void refreshList(int weight){
        for(int i = 1; i <= 20; i++){
            double percOfWeight = ((i*5)) * weight;
            //System.out.println(percOfWeight/100+"");
            percList.add(i*5+"% of one-rep max:\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+(percOfWeight/100)+"lbs");

        }
    }


}
