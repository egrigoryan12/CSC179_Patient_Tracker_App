package com.example.csc179_patient_tracker_app.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.csc179_patient_tracker_app.data.PatientModel;

import java.util.List;


@Dao
public interface PatientDAO {
    @Insert
    void insertPatient(PatientModel... patient);
    @Update
    void updatePatient(PatientModel patient);
    @Delete
    void deletePatient(PatientModel patient);
    @Query("SELECT COUNT(*) FROM Patients")
    int getPatientCount();
    @Query("SELECT * FROM Patients")
    LiveData<List<PatientModel>> getAllPatients();
    @Query("select * from Patients where id == :id ")
    public PatientModel getPatient(int id);
    @Query("SELECT id FROM Patients WHERE first_name = :firstName AND middle_name = :middleName AND last_name = :lastName AND `dob_YYYY/MM/DD` = :dob AND mobile_phone = :phoneNumber")
    int getPatientIdByDetails(String firstName, String middleName, String lastName, String dob, String phoneNumber);


}