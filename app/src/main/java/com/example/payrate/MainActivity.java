package com.example.payrate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Spinner spinner = (Spinner) findViewById(R.id.rate_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.rate_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        //YouTube
        spinner.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calculate(View view)
    {
        EditText mEdit = (EditText)findViewById(R.id.hours_per_week);
        String hoursPerWeek = mEdit.getText().toString();

        EditText mEdit2 = (EditText)findViewById(R.id.rate);
        String rate = mEdit2.getText().toString();

        Spinner mySpinner = (Spinner) findViewById(R.id.rate_spinner);
        String textTest = mySpinner.getSelectedItem().toString();

        System.out.println(textTest);

        boolean hourlySalary;

        if (textTest.equals("Hourly")) {
            hourlySalary = true;
        }
        else {
            hourlySalary = false;
        }

        double d1 = Double.parseDouble(hoursPerWeek);
        double d2 = Double.parseDouble(rate);


        PayRate testObject = new PayRate(d1, d2, hourlySalary);
        double temp = testObject.getRate();

        String result = String.valueOf(temp);


        TextView mText = (TextView)findViewById(R.id.conversion);
        mText.setText(result);


    }

}
