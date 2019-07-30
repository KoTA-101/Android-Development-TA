package com.example.innstant.ui.Rent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.innstant.R;
import com.example.innstant.data.PreferenceHelper;
import com.example.innstant.data.model.Room;
import com.example.innstant.data.model.Transaction;
import com.example.innstant.ui.RentStatus.idleActivity;
import com.example.innstant.ui.RoomListed.Adapter.adapterListedRoom;
import com.example.innstant.ui.RoomListed.ListedRoomActivity;
import com.example.innstant.viewmodel.ApprovalViewModel;
import com.example.innstant.viewmodel.idleViewModel;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;

public class ApprovalActivity extends AppCompatActivity {
    Button cancel;
    private ApprovalViewModel mViewModel;
    ArrayList<Transaction> list;
    Transaction transaksi = new Transaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approval);
        setTitle("Room Booking");

        cancel = (Button) findViewById(R.id.cancelBooking);

        ButterKnife.bind(this);
        mViewModel = ViewModelProviders.of(this).get(ApprovalViewModel.class);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postData();
            }
        });
    }

    public void postData() {
        mViewModel.openServerConnection();
        RequestQueue requstQueue = Volley.newRequestQueue(this);
        String url = PreferenceHelper.getBaseUrl() + "/transactions";
        Bundle bundle = getIntent().getExtras();
        String json = bundle.getString("email");
        String json1 = bundle.getString("data");
        String jsonTransaksi = bundle.getString("dataTransaksi");

        Gson gson = new Gson();
        Room room = gson.fromJson(json1, Room.class);
        transaksi = gson.fromJson(jsonTransaksi, Transaction.class);
        transaksi.setGuestId(json);
        transaksi.setHostId(room.getOwnerId());
        transaksi.setRoomId(room.getRoomId());
        transaksi.setPaymentStatus("belum bayar");
        Toast.makeText(ApprovalActivity.this, json+"   :" + transaksi.toString(), Toast.LENGTH_LONG).show();
        String paramString = new GsonBuilder().create().toJson(transaksi);
        try {
            JSONObject param = new JSONObject(paramString);
            JsonObjectRequest jsonobj = new JsonObjectRequest(Request.Method.POST, url, param,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
//                          Toast.makeText(ApprovalActivity.this,"berhasil    :"+response.toString(),Toast.LENGTH_LONG).show();

                        }

                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
//                           Toast.makeText(ApprovalActivity.this,"gagal     :"+error.toString(),Toast.LENGTH_LONG).show();
                        }

                    }

            ) {
                //here I want to post data to sever
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> headers = new HashMap<>();
                    // Basic Authentication
                    //String auth = "Basic " + Base64.encodeToString(CONSUMER_KEY_AND_SECRET.getBytes(), Base64.NO_WRAP);
//                    headers.put("Authorization", "Bearer " + "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJzZWN1cmUtYXBpIiwiYXVkIjoic2VjdXJlLWFwcCIsInN1YiI6InJvaG1hdDY2MUBnbWFpbC5jb20iLCJleHAiOjE1NjI2NjM1NjksInJvbGUiOlsiVVNFUiJdfQ.6mGlnlu0lWHuOZLmy_I4IYOD5BJKc-22fbR0sWO-8j_KQ9Jkk4owJZqpP3yPtvBIiRhD_zRYKm-ew3DPqFrK_A");
                    return headers;
                }
            };
            requstQueue.add(jsonobj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
