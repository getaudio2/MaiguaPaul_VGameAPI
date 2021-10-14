package com.example.vgameapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Llista extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llista);

        ArrayList<String> array_noms = new ArrayList<String>();
        array_noms.add("FPS ('Shooter en primera persona')");
        array_noms.add("Puzzle");
        array_noms.add("Visual Novel");
        array_noms.add("2D Fighter");
        array_noms.add("RPG");
        array_noms.add("Shoot 'em up");
        array_noms.add("Adventure");
        array_noms.add("Platformer");
        array_noms.add("Sandbox");
        array_noms.add("MMORPG");

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(array_noms);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager((this)));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
}