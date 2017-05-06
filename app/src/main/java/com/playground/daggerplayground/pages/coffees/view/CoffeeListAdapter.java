package com.playground.daggerplayground.pages.coffees.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.playground.daggerplayground.R;
import com.playground.daggerplayground.data.common.Drink;

import java.util.List;

/**
 * Created by petnagy on 2017. 05. 06..
 */

public class CoffeeListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int HEADER = 1;

    private static final int ITEM = 2;

    private List<Drink> coffeeList;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecyclerView.ViewHolder viewHolder = null;
        if (viewType == ITEM) {
            View view = inflater.inflate(R.layout.coffee_item_layout, parent, false);
            viewHolder = new CoffeeItemViewHolder(view);
        } else if (viewType == HEADER) {
            View view = inflater.inflate(R.layout.coffee_header_layout, parent, false);
            viewHolder = new CoffeeHeaderViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof CoffeeItemViewHolder) {
            Drink drink = coffeeList.get(position - 1);
            CoffeeItemViewHolder item = (CoffeeItemViewHolder) holder;
            item.coffeeName.setText(drink.getDrinkiName());
            item.coffeeDetails.setText(drink.createDrink());
        } else {
            CoffeeHeaderViewHolder header = (CoffeeHeaderViewHolder) holder;
            header.header.setText("Coffee List:");
        }
    }

    @Override
    public int getItemCount() {
        return coffeeList == null ? 0 : coffeeList.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? HEADER : ITEM;
    }

    public void setData(List<Drink> coffeeList) {
        this.coffeeList = coffeeList;
        notifyItemRangeInserted(0, coffeeList.size());
    }

    public static class CoffeeItemViewHolder extends RecyclerView.ViewHolder {

        public TextView coffeeName;

        public TextView coffeeDetails;

        public CoffeeItemViewHolder(View itemView) {
            super(itemView);
            coffeeName = (TextView) itemView.findViewById(R.id.coffee_item_name);
            coffeeDetails = (TextView) itemView.findViewById(R.id.coffee_item_details);
        }
    }

    public static class CoffeeHeaderViewHolder extends RecyclerView.ViewHolder {

        public TextView header;

        public CoffeeHeaderViewHolder(View itemView) {
            super(itemView);
            header = (TextView) itemView.findViewById(R.id.coffee_header);
        }
    }
}
