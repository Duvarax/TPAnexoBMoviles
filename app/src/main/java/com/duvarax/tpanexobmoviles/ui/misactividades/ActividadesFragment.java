package com.duvarax.tpanexobmoviles.ui.misactividades;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duvarax.tpanexobmoviles.R;
import com.duvarax.tpanexobmoviles.databinding.FragmentActividadesBinding;

import java.util.ArrayList;

public class ActividadesFragment extends Fragment {

    private ActividadesViewModel mViewModel;
    private FragmentActividadesBinding binding;

    public static ActividadesFragment newInstance() {
        return new ActividadesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentActividadesBinding.inflate(inflater, container, false);
        mViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(ActividadesViewModel.class);
        View view = binding.getRoot();

        mViewModel.getActividades().observe(getActivity(), new Observer<ArrayList<Actividad>>() {
            @Override
            public void onChanged(ArrayList<Actividad> actividads) {
                for (int i = 0; i<actividads.size(); i++){
                    System.out.println(actividads.get(i).toString());
                }
                RecyclerView rv = binding.rvLista;
                GridLayoutManager grid = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);
                rv.setLayoutManager(grid);
                ActividadesFragmentAdapter adapter = new ActividadesFragmentAdapter(getActivity(), actividads, getLayoutInflater());
                rv.setAdapter(adapter);
            }
        });

        mViewModel.cargarActividades();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
    }

}