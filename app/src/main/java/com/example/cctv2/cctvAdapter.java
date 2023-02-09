package com.example.cctv2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class cctvAdapter extends RecyclerView.Adapter<cctvAdapter.MyViewHolder> {

    String data1[], data2[], videoUrl[];
    int images[];
    Context context;

    public cctvAdapter(Context ct, String[] s1, String[] s2, int[] img, String[] link){
        context = ct;
        data1 = s1;
        data2 = s2;
        images = img;
        videoUrl = link;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.myText1.setText(data1[position]);
        holder.myText2.setText(data2[position]);
        holder.myImage.setImageResource(images[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ViewCCTV.class);
                intent.putExtra("data1", data1[position]);
                intent.putExtra("data2", data2[position]);
                intent.putExtra("videoUrl", videoUrl[position]);
                intent.putExtra("position",position);
                context.startActivity(intent);
            }
        });

        /*holder.myCardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ViewCCTV.class);
                context.startActivity(intent);
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView myText1, myText2;
        ImageView myImage;
        CardView myCardview;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            myText1 = itemView.findViewById(R.id.txAreacctv);
            myText2 = itemView.findViewById(R.id.txKapanewon);
            myImage = itemView.findViewById(R.id.imageView);
            myCardview = itemView.findViewById(R.id.cvcardview);
        }
    }
}
