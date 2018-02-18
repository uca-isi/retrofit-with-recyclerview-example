package chocoyolabs.myapplication.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import chocoyolabs.myapplication.R;
import chocoyolabs.myapplication.models.Penalty;

/**
 * Created by moisolutions on 13/2/18.
 */

public class PenaltyAdapter extends RecyclerView.Adapter<PenaltyAdapter.ViewHolder> {
    private ArrayList<Penalty> penalties;

    public PenaltyAdapter(ArrayList<Penalty> penalties) {
        this.penalties = penalties;
    }

    @Override
    public PenaltyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_penalty, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(PenaltyAdapter.ViewHolder holder, int position) {
        Penalty penalty = penalties.get(position);

        holder.text.setText(penalty.getText());
        holder.price.setText(penalty.getPrice());
        holder.text.setText(penalty.getType());
    }

    @Override
    public int getItemCount() {
        return penalties.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        TextView price;
        TextView type;

        public ViewHolder(View itemView) {
            super(itemView);

            text = itemView.findViewById(R.id.text);
            price = itemView.findViewById(R.id.price);
            type = itemView.findViewById(R.id.type);
        }
    }
}
