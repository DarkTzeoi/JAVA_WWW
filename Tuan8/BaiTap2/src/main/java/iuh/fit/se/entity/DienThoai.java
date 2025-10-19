package iuh.fit.se.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Entity
@Table(name = "dienthoai")
public class DienThoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private int maDT;
    private String tenDT;
    private int namSanXuat;
    private String cauHinh;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_ncc")
    @ToString.Exclude
    private NhaCungCap nhaCungCap;
    private String hinhAnh;
}
