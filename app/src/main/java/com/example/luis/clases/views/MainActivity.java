package com.example.luis.clases.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.luis.clases.R;
import com.example.luis.clases.adapters.PersonasAdapter;
import com.example.luis.clases.models.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    List<Persona> personas = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    RecyclerView personasRecycler;
    PersonasAdapter personasAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(linearLayoutManager.VERTICAL);

        personasRecycler = (RecyclerView) findViewById(R.id.personasRecylerView);
        personasRecycler.setLayoutManager(linearLayoutManager);
    }

    public void loadData(View view) {
        personas.add(new Persona("Luis Carlos", "Benavides Rivera", 34, "1234567"));
        personas.add(new Persona("Andrea Lorena", "Riascos Ortiz", 56, "45788"));
        personas.add(new Persona("Jaime", "Rojas", 35, "12345"));
        Toast.makeText(this, "Los datos se han cargado", Toast.LENGTH_SHORT).show();
        processData();
    }

    public void processData() {
        personasAdapter = new PersonasAdapter(personas, getApplicationContext());
        personasRecycler.setAdapter(personasAdapter);
    }
}
