package com.example.ontap_ketthucmon01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String url = "https://60b52890fe923b0017c83afc.mockapi.io/persons/onthi1";
    private ListView listView;
    private ListAdapter adapter;
    private ArrayList<Person> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();

        listView = findViewById(R.id.lvPersons);
        GetArrayJson(url);


    }

    private void GetArrayJson(String url){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0; i<response.length(); i++){
                    try {
                        JSONObject object = (JSONObject) response.get(i);
                        int id = Integer.parseInt(object.getString("id"));
                        String name = object.getString("name");
                        String gender = object.getString("gender");
                        int age = object.getInt("age");
                        String mail = object.getString("email");
                        String phone = object.getString("phone");
                        Person persons = new Person(id,name,gender,age,mail,phone);
                        Log.e("emp", id+"");
//                            Toast.makeText(MainActivity.this, object.toString(), Toast.LENGTH_SHORT).show();
                        list.add(persons);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                adapter = new ListAdapter(R.layout.list_item, MainActivity.this,list);
                listView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error by get Json Array!", Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }
}