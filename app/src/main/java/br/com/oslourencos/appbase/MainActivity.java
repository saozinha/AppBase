package br.com.oslourencos.appbase;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.oslourencos.appbase.adapter.ClienteAdapter;
import br.com.oslourencos.appbase.entity.Cliente;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Cliente> listClientes = new ArrayList<>();
    ClienteAdapter adapter = new ClienteAdapter(this);

    Random sortNumID = new Random();
    int positionList = 0;

    Button mButtonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonAdd = (Button) findViewById(R.id.btn_add);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        // informando a quantidade de colunas
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);

        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Specify the position

                final Dialog  dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_cliente);
                dialog.setTitle("Adicionar Cliente");
                dialog.setCancelable(true);

                Button saveButton = (Button)dialog.findViewById(R.id.btn_enviar);
                saveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {

                        String name = ((EditText)dialog.findViewById(R.id.name)).getText().toString();
                        String mail = ((EditText)dialog.findViewById(R.id.mail)).getText().toString();
                        String phone = ((EditText)dialog.findViewById(R.id.phone)).getText().toString();
                        String website = ((EditText)dialog.findViewById(R.id.website)).getText().toString();

                        // sorteia um numero , o que vier sera o ID
                        int id = sortNumID.nextInt();

                        // proximo passo -- desenvolver funcao para adicionar foto
                        Cliente cliente = new Cliente(id,name, mail, phone, website, R.drawable.no_image) ;

                        addClienteDialog(cliente);

                        dialog.dismiss();

                        Toast.makeText(MainActivity.this, "Cadastrado com sucesso !!", Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.show();
            }
        });

        loadClientes();
    }


    public void addClienteDialog(final Cliente cliente) {

        new Thread() {
            @Override
            public void run() {
                try {

                    listClientes.add(positionList, cliente);
                    adapter.addListCliente(listClientes);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }.start();
    }


    public void loadClientes () {

        listClientes.add(positionList, new Cliente(0, "João Silva", "jao@mail.com", "313488-0000","www.sitedoJao.com", R.drawable.user0));
        positionList++;

        listClientes.add(positionList , new Cliente(1, "Fabiana Silva", "fabi@mail.com", "313488-0000","www.sitedaFabi.com", R.drawable.user1));
        positionList++;

        listClientes.add(positionList, new Cliente(2, "Junior Silva", "junior@mail.com", "313488-0000","www.sitedoJunior.com", R.drawable.user2 ));
        positionList++;

        listClientes.add(positionList, new Cliente(3, "Carla Silva", "caca@mail.com", "313488-0000","www.sitedaCarla.com", R.drawable.user3));
        positionList++;

        listClientes.add(positionList, new Cliente(4, "Jeremy Silva", "jeremy@mail.com", "313488-0000","www.sitedaCarla.com", R.drawable.user4));
        positionList++;

        listClientes.add(positionList, new Cliente(5, "Victor Silva", "victor@mail.com", "313488-0000","www.sitedoVictor.com", R.drawable.user5));
        positionList++;

        listClientes.add(positionList, new Cliente(6, "Junia Silva", "junia@mail.com", "313488-0000","www.sitedaJu.com", R.drawable.user6));
        positionList++;

        adapter.addListCliente(listClientes);
    }

}