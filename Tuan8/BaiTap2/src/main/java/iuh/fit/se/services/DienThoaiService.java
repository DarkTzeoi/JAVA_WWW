package iuh.fit.se.services;

import iuh.fit.se.entity.DienThoai;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DienThoaiService {
    List<DienThoai> findByNhaCungCap(String tenNhaCC);
    void save(DienThoai dienThoai);
    void delete(String id);
    List<DienThoai> findAll();
    List<DienThoai> findByName(String tenDT);

    List<DienThoai> findByMaNCC(String maNCC);
}
