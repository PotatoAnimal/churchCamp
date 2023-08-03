package com.example.onlybounty.service;

import com.example.onlybounty.model.Kid;

import java.util.List;

public interface KidsService {
    public List<Kid> getAllKids();

    public void saveKid(Kid kid);

    public Kid getKid (int id);

    public void deleteKid (int id);
}
