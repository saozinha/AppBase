package br.com.oslourencos.appbase.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Cliente cliente = dataset.get(position);
        holder.name.setText(cliente.getName());
        holder.mail.setText(cliente.getEmail());
        holder.phone.setText(cliente.getPhone());
        holder.website.setText(cliente.getWebsite());
        holder.photo.setImageResource(cliente.getPhoto());

        // Set a click listener for item remove button
        holder.mRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the clicked item label
                String user = dataset.get(position).getName();

                // Remove the item on remove/button click
                dataset.remove(position);

                /*
                    public final void notifyItemRemoved (int position)
                        Notify any registered observers that the item previously located at position
                        has been removed from the data set. The items previously located at and
                        after position may now be found at oldPosition - 1.

                        This is a structural change event. Representations of other existing items
                        in the data set are still considered up to date and will not be rebound,
                        though their positions may be altered.

                    Parameters
                        position : Position of the item that has now been removed
                */
                notifyItemRemoved(position);

                /*
                    public final void notifyItemRangeChanged (int positionStart, int itemCount)
                        Notify any registered observers that the itemCount items starting at
                        position positionStart have changed. Equivalent to calling
                        notifyItemRangeChanged(position, itemCount, null);.

                        This is an item change event, not a structural change event. It indicates
                        that any reflection of the data in the given position range is out of date
                        and should be updated. The items in the given range retain the same identity.

                    Parameters
                        positionStart : Position of the first item that has changed
                        itemCount : Number of items that have changed
                */
                notifyItemRangeChanged(position,dataset.size());

                // Show the removed item label
                Toast.makeText(context,"Removed : " + user,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }



    // Classe viewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, phone, mail, website;
        ImageView photo;

        ImageButton mRemoveButton;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            phone = itemView.findViewById(R.id.phone);
            mail = itemView.findViewById(R.id.mail);
            website = itemView.findViewById(R.id.website);
            photo = itemView.findViewById(R.id.photo);
            mRemoveButton = itemView.findViewById(R.id.ib_remove);

        }
    }

}