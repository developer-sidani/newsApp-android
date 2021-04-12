package com.example.ahmadsidani20190148aliyassine20190234hadiibrahim20170297;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListAdapter extends ArrayAdapter  {
    private Activity Context;
    List<news>  newsList;
    public ListAdapter(Activity Context,List<news>  newsList){
        super(Context,R.layout.row,newsList);
        this.Context=Context;
        this.newsList=newsList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=Context.getLayoutInflater();
        View row=inflater.inflate(R.layout.row,null,true);
        TextView titleTextView=row.findViewById(R.id.titleTextView);
        TextView descriptionTextView=row.findViewById(R.id.descriptionTextView);
        ImageView newsImage= row.findViewById(R.id.newsImage);

        news n=newsList.get(position);
        titleTextView.setText(n.getTitle());
        descriptionTextView.setText(n.getCategory());


        if(n.getCategory().equals("Breaking News")){
//            newsImage.setImageResource(R.mipmap.breaking_news_round);
        }
        else if(n.getCategory().equals("Health")){
            newsImage.setImageResource(R.drawable.health);
        }
        else if(n.getCategory().equals("Sports")){
            newsImage.setImageResource(R.drawable.sports);
        }
        else if(n.getCategory().equals("Technology")){
            newsImage.setImageResource(R.drawable.technology);
        }
        else if(n.getCategory().equals("Travel")){
            //okay
            newsImage.setImageResource(R.drawable.travel);
        }
        else if(n.getCategory().equals("Travel")){
            newsImage.setImageResource(R.drawable.travel);
            //okay
        }

        else{
            newsImage.setImageResource(R.drawable.ic_launcher_background);
        }


        return row;
    }
}
