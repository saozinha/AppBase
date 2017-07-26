package br.com.oslourencos.appbase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import br.com.oslourencos.appbase.entity.Cliente;
import br.com.oslourencos.appbase.adapter.ClienteAdapter;

//Aplicativo Base desenvolvido com o objetivo de introduzir estudantes iniciantes ao mundo de desenvolvimento de aplicativos.

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView;
    List<Cliente> listClientes = new ArrayList<>();
    ClienteAdapter adapter = new ClienteAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        // informando a quantidade de colunas
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);

        loadClientes();
    }


    public void loadClientes () {

        listClientes.add(new Cliente(0, "João Silva", "jao@mail.com", "313488-0000","WWW.SITEDOJAO.COM"));

        listClientes.add(new Cliente(1, "Fabiana Silva", "fabi@mail.com", "313488-0000","WWW.SITEDAFABI.COM"));

        listClientes.add(new Cliente(2, "Junior Silva", "junior@mail.com", "313488-0000","WWW.SITEDOJUNIOR.COM"));

        listClientes.add(new Cliente(3, "Carla Silva", "caca@mail.com", "313488-0000","WWW.SITEDACARLA.COM"));

        listClientes.add(new Cliente(4, "Jeremy Silva", "jeremy@mail.com", "313488-0000","WWW.SITEDOJEREMY.COM"));

        listClientes.add(new Cliente(5, "Victor Silva", "victor@mail.com", "313488-0000","WWW.SITEDOVITOR.COM"));

        listClientes.add(new Cliente(6, "Junia Silva", "junia@mail.com", "313488-0000","WWW.SITEDAJUNIA.COM"));

        adapter.addListCliente(listClientes);
    }


    @Override
    public void onClick(View v) {
        //TODO
    }

}