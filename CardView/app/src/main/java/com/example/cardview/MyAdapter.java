package com.example.cardview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    //1 data
    private Context context;
    private ArrayList<GameModel> gameModels;

    //2 constructor


    public MyAdapter(Context context, ArrayList<GameModel> gameModels) {
        this.context = context;
        this.gameModels = gameModels;
    }

    //4

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        GameModel gameModel = gameModels.get(position);
        holder.gameTitle.setText(gameModel.getGameName());
        holder.gameImg.setImageResource(gameModel.getGameImg());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "You choose: "+ gameModels.get(position).getGameName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return gameModels.size();
    }

    //3 viewHolder

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView gameImg;
        private TextView gameTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gameImg =itemView.findViewById(R.id.image_view);
            gameTitle = itemView.findViewById(R.id.gametitle);

        }
    }
}
