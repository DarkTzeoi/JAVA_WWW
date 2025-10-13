package iuh.fit.se.baitaptonghop.dao;

import iuh.fit.se.baitaptonghop.entities.DienThoai;

import java.util.List;

public interface DienThoaiDAO {
    List<DienThoai> getAllDienThoai();
    List<DienThoai> getListDienThoaiTheoNCC(String tenNCC);
    boolean addDienThoai(DienThoai dienThoai);
}
