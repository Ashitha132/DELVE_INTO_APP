package com.example.housepage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AdapterSearch extends RecyclerView.Adapter<AdapterSearch.OwnerViewHolder>
{
    private ArrayList<Survey> listSurvey;
    Context context;

    AdapterSearch(Context context, ArrayList<Survey> itemList)
    {
        this.context = context;
        listSurvey = itemList;
    }

    @NonNull
    @Override
    public OwnerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater=LayoutInflater.from((Context) context);
        View view=layoutInflater.inflate(R.layout.cardview_cast,null);
        return new OwnerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final OwnerViewHolder holder, final int position)
    {
        holder.t1.setText(listSurvey.get(position).getWardnumber());
        holder.t2.setText(listSurvey.get(position).getHousenumber());
        holder.t3.setText(listSurvey.get(position).getCast());
        holder.t4.setText(listSurvey.get(position).getAddress());

    }

    @Override
    public int getItemCount()

    {
        return listSurvey.size();
    }

    class OwnerViewHolder extends RecyclerView.ViewHolder
    {
        TextView t1,t2,t3,t4;


        public OwnerViewHolder(@NonNull View ownerView) {
            super(ownerView);
            t1=(TextView) ownerView.findViewById(R.id.wardno);
            t2=(TextView)ownerView.findViewById(R.id.houseno);
            t3=(TextView)ownerView.findViewById(R.id.cast);
            t4=(TextView)ownerView.findViewById(R.id.address);
        }
    }
}
