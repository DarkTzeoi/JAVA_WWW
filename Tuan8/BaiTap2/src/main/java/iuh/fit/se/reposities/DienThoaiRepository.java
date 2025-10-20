package iuh.fit.se.reposities;

import iuh.fit.se.entity.DienThoai;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DienThoaiRepository extends JpaRepository<DienThoai, String> {
  List<DienThoai> findDienThoaiByNhaCungCap_TenNhaCC(String nhaCungCapTenNhaCC);

  List<DienThoai> findDienThoaiByTenDTContainingIgnoreCase(String tenDT);

  List<DienThoai> findByNhaCungCap_MaNCC(String maNCC);
}