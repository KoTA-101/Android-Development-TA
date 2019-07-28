package com.example.innstant.ui.Rent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.innstant.R;
import com.example.innstant.data.model.Room;
import com.example.innstant.data.model.Transaction;
import com.google.gson.Gson;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SelectDateActivity extends AppCompatActivity {
    final Calendar myCalendar = Calendar.getInstance();
    EditText awal,akhir;
    TextView price,dp,total;
    Gson gson = new Gson();
    Transaction transaksi = new Transaction();
    Button requestBook;
    Bundle bundle;
    String json,json1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_date);
        setTitle("Select Date");
         awal = (EditText) findViewById(R.id.awal);
         akhir = (EditText) findViewById(R.id.akhir);
         dp =(TextView) findViewById(R.id.Dp);
         price=(TextView) findViewById(R.id.price);
         total=(TextView) findViewById(R.id.totalPrice);
         requestBook = (Button) findViewById(R.id.requestBook);
         bundle = getIntent().getExtras();
         json = bundle.getString("data");
         json1 = bundle.getString("email");

        Room room= gson.fromJson(json,Room.class);


//        dp.setText(room.getDpPercentage(), TextView.BufferType.NORMAL);
        price.setText(room.getPrice().toString());
        total.setText(room.getPrice());

        awal.setOnClickListener(new View.OnClickListener() {
            DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear,
                                      int dayOfMonth) {
                    // TODO Auto-generated method stub
                    myCalendar.set(Calendar.YEAR, year);
                    myCalendar.set(Calendar.MONTH, monthOfYear);
                    myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    updateLabel();

                }

                private void updateLabel(){
                    String myFormat = "dd-MM-yyyy"; //In which you need put here
                    SimpleDateFormat sdf = new SimpleDateFormat(myFormat);

                    awal.setText(sdf.format(myCalendar.getTime()));
                    transaksi.setBookStartDate(myCalendar.getTime());
                  }

            };
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(SelectDateActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }

        });
        akhir.setOnClickListener(new View.OnClickListener() {
            DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear,
                                      int dayOfMonth) {
                    // TODO Auto-generated method stub
                    myCalendar.set(Calendar.YEAR, year);
                    myCalendar.set(Calendar.MONTH, monthOfYear);
                    myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    updateLabel();

                }

                private void updateLabel() {
                    String myFormat = "dd-MM-yyyy"; //In which you need put here
                    SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                    akhir.setText(sdf.format(myCalendar.getTime()));
                    transaksi.setBookEndDate(myCalendar.getTime());

                }

            };

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(SelectDateActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        requestBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String paramString = gson.toJson(transaksi);
                Intent intent = new Intent(SelectDateActivity.this,ApprovalActivity.class);
                intent.putExtra("email",json1);
                intent.putExtra("data",json);
                intent.putExtra("dataTransaksi",paramString);
                Toast.makeText(SelectDateActivity.this,"TEST   "+json1,Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
    }
}
