package com.example.mys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<ItemsG> myList = new ArrayList<>();
    int currentGame=0;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ItemsG g1 = new ItemsG("First item" , 4.5 , R.drawable.imge1);
        ItemsG g2 = new ItemsG("Second item" , 5.5 , R.drawable.imge2);
        ItemsG g3 = new ItemsG("Third item" , 5 , R.drawable.imge3);
        ItemsG g4 = new ItemsG("Fourth item" , 6 , R.drawable.imge4);




        myList.add(g1);
        myList.add(g2);
        myList.add(g3);
        myList.add(g4);

        RecyclerView recycler = findViewById(R.id.rv);
        recycler.setHasFixedSize(true);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recycler.setLayoutManager(manager);

        ItemAdapter adapter = new ItemAdapter(myList, this);
        recycler.setAdapter(adapter);
    }

}