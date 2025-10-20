package iuh.fit.se.reposities;

import iuh.fit.se.entity.NhaCungCap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NhaCungCapRepository extends JpaRepository<NhaCungCap, String> {
    @Query("SELECT n FROM NhaCungCap n WHERE " +
           "n.maNCC LIKE %?1% OR " +
           "n.tenNhaCC LIKE %?1% OR " +
           "n.diaChi LIKE %?1% OR " +
           "n.soDienThoai LIKE %?1%")
    List<NhaCungCap> search(String keyword);
}