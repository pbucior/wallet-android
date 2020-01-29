package eu.bucior.wallet;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;

import eu.bucior.wallet.data.DatabaseHandler;
import eu.bucior.wallet.model.Operation;
import eu.bucior.wallet.util.Util;

public class NewOperationActivity extends AppCompatActivity {

    private int mYear, mMonth, mDay;
    private String description, dateOperation, postingKey;
    private double amount;
    Button buttonDate;
    EditText editTextDescription, editTextAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_operation);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(getString(R.string.activity_new_operation));

        final DatabaseHandler db = new DatabaseHandler(NewOperationActivity.this);
        final Calendar c = Calendar.getInstance();

        buttonDate = findViewById(R.id.buttonDate);
        editTextDescription = findViewById(R.id.editTextDescription);
        editTextAmount = findViewById(R.id.editTextAmount);

        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        dateOperation = Util.formatDate(mYear, mMonth + 1, mDay);
        buttonDate.setText(dateOperation);

        postingKey = "Expense";

        FloatingActionButton floatingActionButton = findViewById(R.id.fabSaveOperation);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Long dateAdded = System.currentTimeMillis();
                description = editTextDescription.getText().toString();
                amount = Double.parseDouble(editTextAmount.getText().toString());

                Operation operation = new Operation(dateAdded, dateOperation, amount, description, postingKey);
                db.addOperation(operation);
                finish();
            }
        });
    }

    public void onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.radioButtonExpense:
                if (checked)
                    postingKey = "Expense";
                    break;
            case R.id.radioButtonProfit:
                if (checked)
                    postingKey = "Profit";
                    break;
        }
    }

    public void onButtonDateClicked(View view) {

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        dateOperation = Util.formatDate(year, monthOfYear + 1, dayOfMonth);
                        buttonDate.setText(dateOperation);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
}
