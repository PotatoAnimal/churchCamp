package com.example.onlybounty.service;

import com.example.onlybounty.dao.KidsDAO;
import com.example.onlybounty.model.Kid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class KidsServiceImpl implements KidsService{
    private final KidsDAO kidsDAO;

    public KidsServiceImpl(KidsDAO kidsDAO) {
        this.kidsDAO = kidsDAO;
    }

    @Override
    @Transactional
    public List<Kid> getAllKids() {
        return kidsDAO.getAllKids();
    }

    @Override
    @Transactional
    public void saveKid(Kid kid) {
        kidsDAO.saveKid(kid);
    }

    @Override
    @Transactional
    public Kid getKid(int id) {
        return kidsDAO.getKid(id);
    }

    @Override
    @Transactional
    public void deleteKid(int id) {
        kidsDAO.deleteKid(id);
    }
}
