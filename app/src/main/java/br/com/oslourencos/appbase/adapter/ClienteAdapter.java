package br.com.oslourencos.appbase.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.oslourencos.appbase.R;
import br.com.oslourencos.appbase.entity.Cliente;

/**
 * Created by conceicao on 25/07/17.
 */

public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.ViewHolder>  {

    public Context context;
    private List<Cliente> dataset;

    public ClienteAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();
    }

    public void addListCliente(List<Cliente> listaCliente) {

        dataset.addAll(listaCliente);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Cliente cliente = dataset.get(position);
        holder.name.setText(cliente.getName());
        holder.mail.setText(cliente.getEmail());
        holder.phone.setText(cliente.getPhone());
        holder.website.setText(cliente.getWebsite());
        holder.photo.setImageResource(cliente.getPhoto());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    // Classe viewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, phone, mail, website;
        ImageView photo;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            phone = itemView.findViewById(R.id.phone);
            mail = itemView.findViewById(R.id.mail);
            website = itemView.findViewById(R.id.website);
            photo = itemView.findViewById(R.id.photo);
        }
    }

}