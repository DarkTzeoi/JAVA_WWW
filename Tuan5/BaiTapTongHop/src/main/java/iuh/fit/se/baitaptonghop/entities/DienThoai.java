package iuh.fit.se.baitaptonghop.entities;

public class DienThoai {
    private String maDT;
    private String tenDT;
    private Integer namSanXuat;
    private String cauHinh;
    private String maNCC;
    private String hinhAnh;

    public DienThoai(String maDT, String tenDT, Integer namSanXuat, String cauHinh, String maNCC, String hinhAnh) {
        this.maDT = maDT;
        this.tenDT = tenDT;
        this.namSanXuat = namSanXuat;
        this.cauHinh = cauHinh;
        this.maNCC = maNCC;
        this.hinhAnh = hinhAnh;
    }

    public DienThoai() {
    }

    public String getMaDT() {
        return maDT;
    }

    public String getTenDT() {
        return tenDT;
    }

    public Integer getNamSanXuat() {
        return namSanXuat;
    }

    public String getCauHinh() {
        return cauHinh;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setMaDT(String maDT) {
        this.maDT = maDT;
    }

    public void setTenDT(String tenDT) {
        this.tenDT = tenDT;
    }

    public void setNamSanXuat(Integer namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public void setCauHinh(String cauHinh) {
        this.cauHinh = cauHinh;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
