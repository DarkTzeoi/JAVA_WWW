package iuh.fit.se.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Entity
@Table(name = "nhacungcap")
public class NhaCungCap {
    @Id
    private String maNCC;
    private String tenNhaCC;
    private String diaChi;
    private String soDienThoai;

    @OneToMany(mappedBy = "nhaCungCap", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<DienThoai> dienThoais;
}
