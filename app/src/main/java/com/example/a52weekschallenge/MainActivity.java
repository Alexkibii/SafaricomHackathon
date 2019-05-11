package com.example.a52weekschallenge;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a52weekschallenge.Adapter.MyRecyclerViewAdapter;
import com.example.a52weekschallenge.models.WeekModel;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MyRecyclerViewAdapter adapter;
    EditText myTextBox;
    TextView totalSaved;
    long input = 0;
    int total;
    int i;
    List<WeekModel> weekModels = new ArrayList<WeekModel>();

    WeekModel weekModel = new WeekModel();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTextBox = findViewById(R.id.deposit_amount);
        final RecyclerView recyclerView = findViewById(R.id.rvAnimals);
        totalSaved = findViewById(R.id.totalsavedTv);
        input = 2;

/**
 * compute totals from both start amount and progressive incremental topups */
        for (int i = 0; i <= 52; i++) {

            weekModel = new WeekModel(i+1, ((i+1) * input), total += ((i+1) * input));
            weekModels.add(weekModel);

        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        adapter = new MyRecyclerViewAdapter(this, weekModels);

        recyclerView.setAdapter(adapter);
/**Display the total amount of savings*/
        totalSaved.setText(String.valueOf(weekModels.get(51).getTotal()));
/**
 * Add a textview watcher to update the adapter when user types in the new start amount*/
        myTextBox.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {


            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if (!myTextBox.getText().toString().isEmpty()) {
                    input = Long.parseLong(myTextBox.getText().toString());
                    total = 0;


                    for (int i = 0; i <= 52; i++) {


                        weekModels.get(i).setTotal(total += ((i+1) * input));
                        weekModels.get(i).setAmount(input * (i+1));
                        weekModels.get(i).setWeek(i+1);

                      /*  weekModel = new WeekModel(i+1, ((i+1) * input), total += ((i+1) * input));
                        weekModels.add(weekModel);*/

                        adapter.notifyDataSetChanged();
                    }

                    /*for (i = 0; i <= 52; i++) {
                      //v bvvv  Toast.makeText(getApplicationContext(),total += ((1) * input), Toast.LENGTH_SHORT ).show();
                        weekModels.get(i).setTotal(total += ((i+1) * input));
                        weekModels.get(i).setAmount(input * (i+1));
                        weekModels.get(i).setWeek(i+1);

                        weekModel = new WeekModel((i+1), ((i+1) * input), total += ((i+1) * input));
                        weekModels.add(weekModel);

                        adapter.notifyDataSetChanged();

                    }*/

                    totalSaved.setText(String.valueOf(weekModels.get(51).getTotal()));
                } else {
                    input = 0;
                    for (i = 0; i <= 52; i++) {


                        weekModels.get(i).setTotal(total += ((i+1) * input));
                        weekModels.get(i).setAmount(input * (i+1));
                        weekModels.get(i).setWeek(i+1);

                        adapter.notifyDataSetChanged();

                    }
                    totalSaved.setText("0");
                }


            }
        });


    }


}