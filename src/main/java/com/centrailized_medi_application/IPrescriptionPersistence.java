package com.centrailized_medi_application;

import java.util.ArrayList;

public interface IPrescriptionPersistence {

  void savePrescription(IPrescription prescription);
  void loadPrescription(IPrescription prescription);

}
