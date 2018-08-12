package notification.android.tutos.com.quiz;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {

    Activity context ;
    ArrayList<User> users;
    private static LayoutInflater inflater  = null;

    public UserAdapter(Activity context , ArrayList<User> users) {

        this.context = context;
        this.users = users;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public User getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView =convertView;
        itemView = (itemView==null) ? inflater.inflate(R.layout.listinfo,null):itemView;
        TextView nom = (TextView) itemView.findViewById(R.id.lnom);
        TextView score = (TextView) itemView.findViewById(R.id.lscore);
        nom.setText(users.get(position).getmFirstName());
        score.setText(users.get(position).getScore().toString());
        return itemView;
    }
}
