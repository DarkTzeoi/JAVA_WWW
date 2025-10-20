package iuh.fit.se.services;

import iuh.fit.se.entity.NhaCungCap;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NhaCungCapService {
    List<NhaCungCap> findAll();
    List<NhaCungCap> searchNhaCungCap(String keyword);
}