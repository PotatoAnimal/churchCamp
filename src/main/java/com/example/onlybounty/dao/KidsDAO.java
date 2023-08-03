package com.example.onlybounty.dao;

import com.example.onlybounty.model.Kid;

import java.util.List;

public interface KidsDAO {
    public List<Kid> getAllKids();

    public Kid saveKid(Kid kid);

    Kid getKid(int id);

    public void deleteKid(int id);
}
