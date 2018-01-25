package com.example.baeza.simplerecyclerjava;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by baeza on 25.01.2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    final private ListItemClickListener mOnClickListener;
    List<Pet> mPetList;
    //constructor to create the RecyclerAdapter
    public RecyclerAdapter(List<Pet> mPetList, ListItemClickListener listener){
        this.mPetList = mPetList;
        mOnClickListener = listener;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        int layout = R.layout.item_recycler;
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layout, parent,false);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        //en OnBindViewHolder vamos llenando lo que se vera en pantalla
        Pet pet = mPetList.get(position);
        holder.mTextViewLeft.setText(pet.getName());
        holder.mTextViewRight.setText(Integer.toString(pet.getAge()));
    }

    @Override
    public int getItemCount() {
        //we return the recycler View with the number of items
        //esta es la cantidad de items del recycler view
        return mPetList.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        //en el viewHolder declaramos los items
        public TextView mTextViewLeft, mTextViewRight;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            mTextViewLeft =(TextView)itemView.findViewById(R.id.textViewLeft);
            mTextViewRight = (TextView) itemView.findViewById(R.id.textViewRight);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);
        }
    }
    //agregando una interfaz para manejar los clicks
    public interface ListItemClickListener{
        void onListItemClick(int clickedItemIndex);
    }

}
