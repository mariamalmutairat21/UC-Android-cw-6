package com.example.mys;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mys.ItemsG;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter {
    ArrayList<ItemsG> myList = new ArrayList<>();
    Context context;

    public ItemAdapter(ArrayList<ItemsG> myList, Context context) {
        this.myList = myList;
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        ViewHolder vh = new ViewHolder(view);


        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ((ViewHolder)holder).textname.setText(myList.get(position).getGameName());
        ((ViewHolder)holder).textprice.setText(myList.get(position).getGamePrice() + " KD");
        ((ViewHolder)holder).img.setImageResource(myList.get(position).getGameImg());
        ((ViewHolder)holder).v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, com.example.day5.DetailsActivity.class);
                intent.putExtra("ItemG",myList.get(position));
                context.startActivity(intent);

            }
        });
        ((ViewHolder)holder).delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ItemsG removedItem = myList.get(position);
                int x = position;
                AlertDialog.Builder alert = new AlertDialog.Builder(context)
                        .setTitle("Attention")
                        .setMessage(" you want to delete this item ?")
                        .setPositiveButton("delete",new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                myList.remove(position);
                                notifyDataSetChanged();
                                Snackbar.make(context, view,"one item deleted",3000)
                                        .setAction("Undo", new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                myList.add(position,removedItem);
                                                notifyDataSetChanged();
                                            }
                                        }).show();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                alert.show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return myList.size();
    }
}



    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView textname,textprice;
        View v;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            v =itemView;
            img = v.findViewById(R.id.imageView);
            textname = v.findViewById(R.id.textView);
            textprice = v.findViewById(R.id.textViewprice);

        }
    }
