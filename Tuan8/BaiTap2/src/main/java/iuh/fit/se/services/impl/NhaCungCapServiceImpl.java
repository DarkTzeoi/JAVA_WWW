package iuh.fit.se.services.impl;

import iuh.fit.se.entity.NhaCungCap;
import iuh.fit.se.reposities.NhaCungCapRepository;
import iuh.fit.se.services.NhaCungCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhaCungCapServiceImpl implements NhaCungCapService {
    NhaCungCapRepository nhaCungCapRepository;

    @Autowired
    public NhaCungCapServiceImpl(NhaCungCapRepository nhaCungCapRepository){
        this.nhaCungCapRepository = nhaCungCapRepository;
    }

    @Override
    public List<NhaCungCap> findAll() {
        return nhaCungCapRepository.findAll();
    }

    @Override
    public List<NhaCungCap> searchNhaCungCap(String keyword) {
        return nhaCungCapRepository.search(keyword);
    }
}