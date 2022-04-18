package com.scout.hospitalapp.ViewModels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.scout.hospitalapp.Models.ModelAppointment;
import com.scout.hospitalapp.Repository.Remote.AppointmentRequestRepo;
import com.scout.hospitalapp.Repository.Remote.AppointmentsRepo;
import com.scout.hospitalapp.Repository.SharedPref.SharedPref;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {
    AppointmentsRepo appointmentsRepo;

    public String getHospitalId(Context context) {
        return SharedPref.getLoginUserData(context).getHospitalId().getId();
    }

    public void loadAppointmentIdsList(String hospitalId) {
        appointmentsRepo = AppointmentsRepo.getInstance();
        appointmentsRepo.loadAppointmentIdsList(hospitalId);
    }

    public LiveData<ArrayList<ModelAppointment>> getAppointmentsList() {
        appointmentsRepo = AppointmentsRepo.getInstance();
        return appointmentsRepo.getAppointmentsList();
    }

    public LiveData<Integer> getStartingIndexOfList() {
        appointmentsRepo = AppointmentsRepo.getInstance();
        return appointmentsRepo.getStartingIndexOfList();
    }

    public void loadAppointments(int startingIndex) {
        appointmentsRepo = AppointmentsRepo.getInstance();
        appointmentsRepo.loadAppointmentList(startingIndex);
    }

    public LiveData<String> setStatus(String hospitalId, String appointmentId, String status) {
        AppointmentRequestRepo appointmentRequestRepo = AppointmentRequestRepo.getInstance();
        return appointmentRequestRepo.setStatus(hospitalId,appointmentId,status);
    }
}