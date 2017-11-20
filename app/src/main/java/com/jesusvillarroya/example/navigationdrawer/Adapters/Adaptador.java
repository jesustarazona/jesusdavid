package com.jesusvillarroya.example.navigationdrawer.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jesusvillarroya.example.navigationdrawer.R;

import java.util.List;

public class Adaptador extends BaseAdapter {

    private Context context;
    private int layout;
    private List<String> names;

    public Adaptador (Context context, int layout, List<String> names){
        this.context = context;
        this.layout = layout;
        this.names = names;
    }


    //Número de iteraciones
    @Override
    public int getCount() {

        return this.names.size();
    }

    //Obtener un item de la colección
    @Override
    public Object getItem(int position) { return this.names.get(position);}

    //Obtener el id de un item
    @Override
    public long getItemId(int id) { return id; }

    //Configuramos la vista
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        //Cogemos la vista
        //  View view = convertView;

        //View Holder Pattern

        ViewHolder holder;
        if(convertView == null){
            //Inflamos la vista que nos llega con nuestro Layout
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(R.layout.list_item, null);

            holder = new ViewHolder();
            holder.nameText = (TextView)convertView.findViewById(R.id.textViewListado);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        //Cogemos el valor actual
        String currentName = names.get(position);
        //currentName = (String) getItem(position);

        //Referenciamos el elemento a modificar
        holder.nameText.setText(currentName);

        //Devolvemos la vista
        return convertView;
    }

    static class ViewHolder {
        private TextView nameText;
    }
}
