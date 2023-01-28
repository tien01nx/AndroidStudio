package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;



import org.w3c.dom.Text;

import java.sql.DatabaseMetaData;
import java.util.ArrayList;

public class CustomerAdapter extends ArrayAdapter<CountryModelClass> {
   private ArrayList<CountryModelClass> countryModelClasses;
   Context context;
   public  CustomerAdapter(ArrayList<CountryModelClass> data, Context context){
       super(context,R.layout.item_list_view,data);
       this.countryModelClasses =data;
       this.context=context;
   }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // get the data item for this position
        CountryModelClass dataCountryModelClass = getItem(position);

        // check  if an  existing view is  being reused , otherwise inflate the view
        ViewHolder viewHolder ;

        final View result;
        if (convertView==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView= inflater.inflate(R.layout.item_list_view,parent,false);
            viewHolder.txtCountry = (TextView)convertView.findViewById(R.id.country_name);
            viewHolder.txtCupWins =(TextView) convertView.findViewById(R.id.cup_win_desc);
            viewHolder.flagImg =(ImageView) convertView.findViewById(R.id.imageView);
            result = convertView;
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder)convertView.getTag();
            result = convertView;

        }

        // get the data form model class
        viewHolder.txtCountry.setText(dataCountryModelClass.getCountry_name());
        viewHolder.txtCupWins.setText(dataCountryModelClass.getCup_win_count());
        viewHolder.flagImg.setImageResource(dataCountryModelClass.getFlag_img());
        return convertView;
    }

    private static class ViewHolder{
       TextView txtCountry;
       TextView txtCupWins;
       ImageView flagImg;



    }
}
