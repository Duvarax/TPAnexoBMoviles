package com.duvarax.tpanexobmoviles.ui.misactividades;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duvarax.tpanexobmoviles.R;
import com.duvarax.tpanexobmoviles.databinding.FragmentDetalleBinding;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DetalleFragment extends Fragment {

    private DetalleViewModel mViewModel;
    private FragmentDetalleBinding binding;

    public static DetalleFragment newInstance() {
        return new DetalleFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(DetalleViewModel.class);
        binding = FragmentDetalleBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        Bundle bundle = getArguments();

        mViewModel.getActividad().observe(getActivity(), new Observer<Actividad>() {
            @Override
            public void onChanged(Actividad actividad) {
                binding.dtvNombre.setText(actividad.getNombre());
                binding.dtvDescripcion.setText(actividad.getDescripcion());
                LocalDateTime fechaYHoraActividad = actividad.getFecha();
                DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String fechaActividad = fechaYHoraActividad.format(formatoFecha);

                DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
                String horaActual = fechaYHoraActividad.format(formatoHora);
                binding.dtvFecha.setText(fechaActividad);
                binding.dtvHora.setText(horaActual);
                binding.dtvLugar.setText(actividad.getLugar());

            }
        });

            Actividad actividad = ((Actividad) bundle.getSerializable("actividad"));
            mViewModel.setDetalles(actividad);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
    }

}