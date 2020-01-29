package eu.bucior.wallet;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

import eu.bucior.wallet.util.Util;

public class NewOperationActivity extends AppCompatActivity {

    private int mYear, mMonth, mDay;
    private String mDate;
    Button buttonDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_operation);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(getString(R.string.activity_new_operation));

        buttonDate = findViewById(R.id.buttonDate);
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        mDate = Util.formatDate(mYear, mMonth + 1, mDay);
        buttonDate.setText(mDate);
    }

    public void onRadioButtonClicked(View view) {
    }

    public void onButtonDateClicked(View view) {

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        mDate = Util.formatDate(year, monthOfYear + 1, dayOfMonth);
                        buttonDate.setText(mDate);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
}
