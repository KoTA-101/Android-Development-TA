package com.example.innstant.ui.HostRoom;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.innstant.R;
import com.example.innstant.data.PreferenceHelper;
import com.example.innstant.data.model.Room;
import com.example.innstant.ui.HostRoom.Adapter.AdapterRoomHosting;
import com.example.innstant.ui.RoomHostingActivity;
import com.example.innstant.ui.RoomListed.EditRoomActivity;
import com.example.innstant.viewmodel.AddPictureViewModel;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;

public class AddPictureActivity extends AppCompatActivity {
    private AddPictureViewModel mViewModel;
    Button nextPict;
    ImageView gambar1;
    ImageView gambar2;
    ImageView gambar3;
    ImageView gambar4;
    ImageView gambar5;
    ImageView gambar6;
    TextView textGambar1;
    TextView textGambar2;
    TextView textGambar3;
    TextView textGambar4;
    TextView textGambar5;
    TextView textGambar6;

    ArrayList<String> listImage = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_picture);

        Bundle bundle = getIntent().getExtras();
        String json = bundle.getString("dataRoom");
        String json1 = bundle.getString("email");
        Gson gson = new Gson();
        final Room room= gson.fromJson(json,Room.class);


        ButterKnife.bind(this);
        mViewModel = ViewModelProviders.of(AddPictureActivity.this).get(AddPictureViewModel.class);

//        Toast.makeText(AddPictureActivity.this,room.getName(),Toast.LENGTH_LONG).show();

        nextPict = (Button) findViewById(R.id.nextsetpricing);
        gambar1 =(ImageView) findViewById(R.id.gambar1);
        gambar2 =(ImageView) findViewById(R.id.gambar2);
        gambar3 =(ImageView) findViewById(R.id.gambar3);
        gambar4 =(ImageView) findViewById(R.id.gambar4);
        gambar5 =(ImageView) findViewById(R.id.gambar5);
        gambar6 =(ImageView) findViewById(R.id.gambar6);
        textGambar1 = (TextView) findViewById(R.id.textGambar1);
        textGambar2=(TextView) findViewById(R.id.textGambar2);
        textGambar3=(TextView) findViewById(R.id.textGambar3);
        textGambar4=(TextView) findViewById(R.id.textGambar4);
        textGambar5=(TextView) findViewById(R.id.textGambar5);
        textGambar6=(TextView) findViewById(R.id.textGambar6);
        gambar1.setOnClickListener(new gambar1());
        gambar2.setOnClickListener(new gambar2());
        gambar3.setOnClickListener(new gambar3());
        gambar4.setOnClickListener(new gambar4());
        gambar5.setOnClickListener(new gambar5());
        gambar6.setOnClickListener(new gambar6());

        nextPict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(AddPictureActivity.this, SetRoomPricingActivity.class);
                Gson gson= new Gson();
                String json = gson.toJson(room);
                intent.putExtra("dataRoom",json);
                intent.putExtra("email",json1);
                startActivity(intent);
            }
        });
    }


    class gambar1 implements Button.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,1);
        }
    }
    class gambar2 implements Button.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,2);
        }
    }
    class gambar3 implements Button.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,3);
        }
    }
    class gambar4 implements Button.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,4);
        }
    }
    class gambar5 implements Button.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,5);
        }
    }
    class gambar6 implements Button.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,6);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            gambar1.setImageBitmap(bitmap);
            GetData(bitmap);
        }else if(requestCode == 2){

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            gambar2.setImageBitmap(bitmap);
        }else if(requestCode == 3){

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            gambar3.setImageBitmap(bitmap);

        }else if(requestCode == 4){

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            gambar4.setImageBitmap(bitmap);

        }else if(requestCode == 5){

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            gambar5.setImageBitmap(bitmap);

        }else if(requestCode == 6){

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            gambar6.setImageBitmap(bitmap);

        }
    }

    public void GetData(Bitmap bitmap){
        mViewModel.openServerConnection();
        RequestQueue requstQueue = Volley.newRequestQueue(this);
        String url = PreferenceHelper.getBaseUrl() + "/photos/upload_photo";
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        Map<String, Object> params = new HashMap<>();
        params.put("file", bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream));
        params.put("save_directory", "Room");
        JSONObject param = new JSONObject(params);
        JsonObjectRequest jsonobj = new JsonObjectRequest(Request.Method.POST, url,param,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(AddPictureActivity.this,response.toString(),Toast.LENGTH_LONG).show();
                        Log.d("RESPONBRO",response.toString());


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(AddPictureActivity.this, "gagal  Edit   :" + error.toString(), Toast.LENGTH_LONG).show();
                        Log.d("RESPONBRO",error.toString());

                    }

                }

        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("Accept","application/json");
                headers.put("Content-Type","application/json");
                return headers;
            }
        };
        requstQueue.add(jsonobj);
    }

}
