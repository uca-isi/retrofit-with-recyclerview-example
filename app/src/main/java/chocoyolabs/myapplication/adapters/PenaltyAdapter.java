package chocoyolabs.myapplication.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import chocoyolabs.myapplication.R;
import chocoyolabs.myapplication.models.Penalty;

public class PenaltyAdapter extends RecyclerView.Adapter<PenaltyAdapter.ViewHolder> {
    private List<Penalty> penalties;

    public PenaltyAdapter(List<Penalty> penalties) {
        this.penalties = penalties;
    }

    @Override
    public PenaltyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_penalty, parent, false);
        return new ViewHolder(view);
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
