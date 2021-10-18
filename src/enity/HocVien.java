
package enity;

public class HocVien {
    private int maHV;
    private int MaKH;
    private String maNH;
    private float diem;

    public HocVien() {
    }

    public HocVien(int maHV, int MaKH, String maNH, float diem) {
        this.maHV = maHV;
        this.MaKH = MaKH;
        this.maNH = maNH;
        this.diem = diem;
    }


    public int getMaHV() {
        return maHV;
    }

    public void setMaHV(int maHV) {
        this.maHV = maHV;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public String getMaNH() {
        return maNH;
    }

    public void setMaNH(String maNH) {
        this.maNH = maNH;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    @Override
    public String toString() {
        return "maHV=" + maHV ;
    }
    
}
