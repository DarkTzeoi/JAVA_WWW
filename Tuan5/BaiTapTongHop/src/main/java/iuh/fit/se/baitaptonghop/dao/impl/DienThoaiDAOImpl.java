package iuh.fit.se.baitaptonghop.dao.impl;

import iuh.fit.se.baitaptonghop.dao.DienThoaiDAO;
import iuh.fit.se.baitaptonghop.entities.DienThoai;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DienThoaiDAOImpl implements DienThoaiDAO {
    private final DataSource dataSource;

    public DienThoaiDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<DienThoai> getAllDienThoai() {
        List<DienThoai> list = new ArrayList<>();
        String sql = "SELECT * FROM DIENTHOAI";
        try(
                Connection con = (Connection) this.dataSource.getConnection();
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                ){
            while (rs.next()){
                String maDT = rs.getString("MADT");
                String tenDT = rs.getString("TENDT");
                Integer nsx = rs.getInt("NAMSANXUAT");
                String cauHinh = rs.getString("CAUHINH");
                String maNCC = rs.getString("MANCC");
                String hinhAnh = rs.getString("HINHANH");
                list.add(new DienThoai(maDT, tenDT, nsx, cauHinh, maNCC, hinhAnh));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<DienThoai> getListDienThoaiTheoNCC(String tenNCC) {
        return List.of();
    }

    @Override
    public boolean addDienThoai(DienThoai dienThoai) {
        String sql = "Insert into DIENTHOAI(MADT, TENDT, NAMSANXUAT, CAUHINH, MANCC, HINHANH) value(?, ?, ?, ?, ?, ?)";
        try (
                Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ){
            ps.setString(1, dienThoai.getMaDT());
            ps.setString(2, dienThoai.getTenDT());
            ps.setInt(3, dienThoai.getNamSanXuat());
            ps.setString(4, dienThoai.getCauHinh());
            ps.setString(5, dienThoai.getMaNCC());
            ps.setString(6, dienThoai.getHinhAnh());
            int rows = ps.executeUpdate();
            return rows > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }


}
