package iuh.fit.se.services;

import iuh.fit.se.entity.DienThoai;

import java.util.List;

public interface DienThoaiService {
    List<DienThoai> findByNhaCungCap(String tenNhaCC);
    void save(DienThoai dienThoai);
    void delete(int id);
    List<DienThoai> findAll();
    List<DienThoai> findByName(String tenDT);
}
