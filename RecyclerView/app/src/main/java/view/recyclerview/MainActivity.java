package view.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.Snackbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import view.recyclerview.adapter.RecyclerViewAdapter;
import view.recyclerview.pojo.Item;

public class MainActivity extends AppCompatActivity implements ClickListner{


    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    List<Item> itemList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);

        recyclerViewAdapter = new RecyclerViewAdapter(itemList,this);

        RecyclerView.LayoutManager mLayoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setAdapter(recyclerViewAdapter);

        recyclerViewAdapter.setClickListner(this);

        addToRecyclerView();
    }

    private void addToRecyclerView(){
        Item item = new Item("RecyclerView");
        itemList.add(item);
        item = new Item("Example");
        itemList.add(item);
        item = new Item("With");
        itemList.add(item);
        item = new Item("Click");
        itemList.add(item);
        item = new Item("Position");
        itemList.add(item);
        item = new Item("And");
        itemList.add(item);
        item = new Item("Card View");
        itemList.add(item);
        item = new Item("And");
        itemList.add(item);
        item = new Item("Bottom Animation");
        itemList.add(item);
        item = new Item("Thank You");
        itemList.add(item);

        recyclerViewAdapter.notifyDataSetChanged();

    }

    @Override
    public void onItemClicked(View view, int position) {
        snackbar(view, String.valueOf(position));
    }

    public void snackbar(View view,String message)
    {
        Snackbar snackbar = Snackbar
                .make(view, message, Snackbar.LENGTH_LONG);

        snackbar.show();
    }

}
