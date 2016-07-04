package com.technishaun.unitconversion;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class Conversion extends AppCompatActivity {

    private String units[];
    private String convert_from_unit;
    private String convert_to_unit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.units = new String[]{"cm", "in", "m", "ft"};

        RelativeLayout conversion_layout = (RelativeLayout) findViewById(R.id.conversion);

        Spinner convert_from = new Spinner(this);
        convert_from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setConvert_from_unit(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> convert_from_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, units);
        convert_from_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        convert_from.setAdapter(convert_from_adapter);

        conversion_layout.addView(convert_from);

        RelativeLayout.LayoutParams convert_from_params = (RelativeLayout.LayoutParams) convert_from.getLayoutParams();
        convert_from_params.addRule(RelativeLayout.RIGHT_OF, R.id.input);
        convert_from_params.addRule(RelativeLayout.BELOW, R.id.convert_from);
        convert_from.setLayoutParams(convert_from_params);

        LinearLayout convert_to_layout = (LinearLayout) findViewById(R.id.convert_to);

        Spinner convert_to = (Spinner) findViewById(R.id.convert_to_spinner);
        convert_to.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setConvert_to_unit(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        convert_to.setAdapter(convert_from_adapter);

    }

    public void setConvert_from_unit(String convert_from_unit) {
        this.convert_from_unit = convert_from_unit;
    }

    public void setConvert_to_unit(String convert_to_unit) {
        this.convert_to_unit = convert_to_unit;
    }

    public String getConvert_from_unit() {
        return convert_from_unit;
    }

    public String getConvert_to_unit() {
        return convert_to_unit;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_conversion, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void convert(View view) {
        TextView result = (TextView) findViewById(R.id.result);
        EditText input = (EditText) findViewById(R.id.input);
        double number = Double.parseDouble(input.getText().toString());

        String appendedResult = "";
        StringBuffer toAppend = new StringBuffer();

        if (getConvert_from_unit() == "cm") {
            if (getConvert_to_unit() == "cm") {
                toAppend.append(number);
                toAppend.append(" " + getConvert_to_unit());
                result.setText(toAppend);

            } else if (getConvert_to_unit() == "in") {
                toAppend.append(number / 2.54);
                toAppend.append(" "+getConvert_to_unit());
                result.setText(toAppend);

            } else if (getConvert_to_unit() == "m") {
                toAppend.append(number / 100);
                toAppend.append(" " + getConvert_to_unit());
                result.setText(toAppend);
            } else if (getConvert_to_unit() == "ft") {
                toAppend.append(number * 0.032808);
                toAppend.append(" " + getConvert_to_unit());
                result.setText(toAppend);
            }

        } else if (getConvert_from_unit() == "in") {
            if (getConvert_to_unit() == "cm") {
                toAppend.append(number * 2.54);
                toAppend.append(" " + getConvert_to_unit());
                result.setText(toAppend);

            } else if (getConvert_to_unit() == "in") {
                toAppend.append(number);
                toAppend.append(" "+getConvert_to_unit());
                result.setText(toAppend);

            } else if (getConvert_to_unit() == "m") {
                toAppend.append(number * 0.0254);
                toAppend.append(" " + getConvert_to_unit());
                result.setText(toAppend);
            } else if (getConvert_to_unit() == "ft") {
                toAppend.append(number * 0.0833333);
                toAppend.append(" " + getConvert_to_unit());
                result.setText(toAppend);
            }

        } else if (getConvert_from_unit() == "m") {
            if (getConvert_to_unit() == "cm") {
                toAppend.append(number * 100);
                toAppend.append(" " + getConvert_to_unit());
                result.setText(toAppend);

            } else if (getConvert_to_unit() == "in") {
                toAppend.append(number / 0.0254 );
                toAppend.append(" " + getConvert_to_unit());
                result.setText(toAppend);

            } else if (getConvert_to_unit() == "m") {
                toAppend.append(number);
                toAppend.append(" " + getConvert_to_unit());
                result.setText(toAppend);
            } else if (getConvert_to_unit() == "ft") {
                toAppend.append(number / 0.3048);
                toAppend.append(" " + getConvert_to_unit());
                result.setText(toAppend);
            }
        } else if (getConvert_from_unit() == "ft") {
            if (getConvert_to_unit() == "cm") {
                toAppend.append(number / 0.032808);
                toAppend.append(" " + getConvert_to_unit());
                result.setText(toAppend);

            } else if (getConvert_to_unit() == "in") {
                toAppend.append(number * 12);
                toAppend.append(" " + getConvert_to_unit());
                result.setText(toAppend);

            } else if (getConvert_to_unit() == "m") {
                toAppend.append(number / 3.2808);
                toAppend.append(" " + getConvert_to_unit());
                result.setText(toAppend);
            } else if (getConvert_to_unit() == "ft") {
                toAppend.append(number);
                toAppend.append(" " + getConvert_to_unit());
                result.setText(toAppend);
            }
        }
    }
}
