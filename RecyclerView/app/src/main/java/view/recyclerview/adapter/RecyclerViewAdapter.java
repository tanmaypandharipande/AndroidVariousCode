package view.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.List;

import view.recyclerview.ClickListner;
import view.recyclerview.R;
import view.recyclerview.pojo.Item;

/**
 * Created by tanmay on 12/03/17.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder> {

    private List<Item> itemsList;
    ClickListner clickListner;
    Context context;
    private int lastPosition = -1;

    public RecyclerViewAdapter(List<Item> itemsList,Context context){
        this.itemsList = itemsList;
        this.context = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_row_layout, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Item item = itemsList.get(holder.getAdapterPosition());
        holder.textView_item_name.setText(item.getItem_name());

        setAnimationBottom(holder.itemView,holder.getAdapterPosition());
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public void setClickListner(ClickListner clickListner)
    {
        this.clickListner=clickListner;
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textView_item_name;
        public CustomViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            this.textView_item_name = (TextView)itemView.findViewById(R.id.text_view_item_name);

        }

        @Override
        public void onClick(View v) {
            if(clickListner!=null)
            {
                clickListner.onItemClicked(v,getPosition());
            }
        }
    }
    public void setAnimationBottom(View viewToAnimate, int position)
    {
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.up_from_bottom);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }
}
