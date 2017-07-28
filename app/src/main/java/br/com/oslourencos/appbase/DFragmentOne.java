package br.com.oslourencos.appbase;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by conceicao on 28/07/17.
 */

public class DFragmentOne extends DialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.add_cliente, container,
                false);
        getDialog().setTitle("Cadastro de Cliente");
        // Do something else
        return rootView;
    }
}
