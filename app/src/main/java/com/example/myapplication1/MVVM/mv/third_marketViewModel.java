package com.example.myapplication1.MVVM.mv;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.myapplication1.MVVM.repositories.jsonWork;
import com.example.myapplication1.DI.serviceLocator;

public class third_marketViewModel extends ViewModel {
    private MutableLiveData<String> costBridgewatch = new MutableLiveData<>("");
    private MutableLiveData<String> costLymhust = new MutableLiveData<>("");
    private MutableLiveData<String> costCaerleon = new MutableLiveData<>("");
    private MutableLiveData<String> costFortSterling = new MutableLiveData<>("");
    private MutableLiveData<String> costThetford = new MutableLiveData<>("");
    private MutableLiveData<String> costMartlock = new MutableLiveData<>("");
    private MutableLiveData<String> name = new MutableLiveData<>("");
    private MutableLiveData<String> description = new MutableLiveData<>("");
    private jsonWork repository;

    public third_marketViewModel(){
        this.repository = serviceLocator.getServiceLocator().getRepository();
        costBridgewatch = repository.getCostBridgewatch();
        costLymhust = repository.getCostLymhust();
        costCaerleon = repository.getCostCaerleon();
        costThetford = repository.getCostThetford();
        costFortSterling = repository.getCostFortSterling();
        costMartlock = repository.getCostMartlock();
    }

    public MutableLiveData<String> getCostBridgewatch() {
        return costBridgewatch;
    }

    public MutableLiveData<String> getCostLymhust() {
        return costLymhust;
    }

    public MutableLiveData<String> getCostCaerleon() {
        return costCaerleon;
    }

    public MutableLiveData<String> getCostFortSterling() {
        return costFortSterling;
    }

    public MutableLiveData<String> getCostThetford() {
        return costThetford;
    }

    public MutableLiveData<String> getCostMartlock() {
        return costMartlock;
    }

    public MutableLiveData<String> getName() {
        return name;
    }

    public MutableLiveData<String> getDescription() {
        return description;
    }

    public void calculateCost(String apiName){
        name.setValue(repository.getName(apiName));
        description.setValue(repository.getDescription(apiName));
        repository.getData(apiName);
    }

}
