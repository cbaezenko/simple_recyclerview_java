package com.example.baeza.simplerecyclerjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.ListItemClickListener {

    Toast mToast;
    RecyclerView mRecyclerView;
    RecyclerAdapter mRecyclerAdapter;
    private List<Pet> mPetList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerAdapter = new RecyclerAdapter(mPetList,this);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mRecyclerAdapter);

        preparingData();
    }

    //Filling the List with Pets to show on the RecyclerView
    private void preparingData(){
        Pet pet = new Pet("Kot",10);
        mPetList.add(pet);

        pet = new Pet("Kilka", 1);
        mPetList.add(pet);

        pet = new Pet("Mango", 5);
        mPetList.add(pet);

        pet = new Pet("Winnie", 8);
        mPetList.add(pet);
    }

    /*
    This method is for responding to clicks from our list.
   */
    @Override
    public void onListItemClick(int clickedItemIndex) {

        switch (clickedItemIndex){
            case 0: {
                mToast = Toast.makeText(this, mPetList.get(0).getName()+ " ne urod", Toast.LENGTH_LONG);
                mToast.show();
                break;
            }
            case 1:{
                mToast = Toast.makeText(this, mPetList.get(1).getName()+ " хорошая", Toast.LENGTH_LONG);
                mToast.show();
                break;
            }
            default:{
                mToast = Toast.makeText(this, "Es un perro", Toast.LENGTH_LONG);
                mToast.show();
                break;
            }
        }
    }
}
