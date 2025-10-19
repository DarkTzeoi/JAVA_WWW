package iuh.fit.se.services.impl;

import iuh.fit.se.entity.DienThoai;
import iuh.fit.se.reposities.DienThoaiRepository;
import iuh.fit.se.services.DienThoaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DienThoaiServiceImpl implements DienThoaiService {
    DienThoaiRepository dienThoaiRepository;

    @Autowired
    public DienThoaiServiceImpl(DienThoaiRepository dienThoaiRepository){
        this.dienThoaiRepository = dienThoaiRepository;
    }
    @Override
    public List<DienThoai> findByNhaCungCap(String tenNCC) {
        return dienThoaiRepository.findDienThoaiByNhaCungCap_TenNhaCC(tenNCC);
    }

    @Override
    public void save(DienThoai dienThoai) {
        this.dienThoaiRepository.save(dienThoai);
    }

    @Override
    public void delete(int id) {
        this.dienThoaiRepository.deleteById(id);
    }

    @Override
    public List<DienThoai> findAll() {
        return this.dienThoaiRepository.findAll();
    }

    @Override
    public List<DienThoai> findByName(String tenDT) {
        return this.dienThoaiRepository.findDienThoaiByTenDTContainingIgnoreCase(tenDT);
    }
}
