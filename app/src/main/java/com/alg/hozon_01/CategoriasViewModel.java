package com.alg.hozon_01;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alg.hozon_01.ECategorias;

import java.util.ArrayList;
import java.util.List;

public class CategoriasViewModel extends ViewModel {

    private MutableLiveData<List<ECategorias>> _theList;

    public void initList(String[] arrayCategorias) {
        List<ECategorias> categoriasList = new ArrayList<ECategorias>();
        for (int i = 0; i < arrayCategorias.length; i++) {
            categoriasList.add(new ECategorias(arrayCategorias[i]));
        }
        if (_theList == null) {
            _theList = new MutableLiveData<>();
        }
        _theList.setValue(categoriasList);
        _theList.getValue().sort(ECategorias::compareTo);
    }

    public LiveData<List<ECategorias>> getList() {
        if (_theList == null) {
            _theList = new MutableLiveData<>();
        }
        return _theList;
    }

    public void deleteCategoria(int position) {
        if (_theList.getValue() != null) {
            List<ECategorias> categoriasList = new ArrayList<>(_theList.getValue());
            categoriasList.remove(position);
            _theList.setValue(categoriasList);
        }
    }

    public void addCategoria(ECategorias categoria) {
        if (_theList.getValue() != null) {
            List<ECategorias> categoriasList = new ArrayList<>(_theList.getValue());
            categoriasList.add(categoria);
            categoriasList.sort(ECategorias::compareTo);
            _theList.setValue(categoriasList);
        }
    }

    public void updateCategoria(ECategorias newCategoria, int position) {
        if (_theList.getValue() != null) {
            List<ECategorias> categoriasList = new ArrayList<>(_theList.getValue());
            categoriasList.remove(position);
            categoriasList.add(position, newCategoria);
            _theList.setValue(categoriasList);
        }
    }

    public boolean findCategoriaByName(String categoriaName) {
        boolean retVal=false;
        if (_theList.getValue() != null) {
            for (ECategorias categoria : _theList.getValue()) {
                if (categoria.toString().equals(categoriaName)){
                    retVal = true;
                    break;
                }
            }
        }
        else {
            retVal=false;
        }
        return retVal;
    }
    //-------------------------------

}