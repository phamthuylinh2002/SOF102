
package dao;

import enity.Khoahoc;
import utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class KhoaHocDAO extends AbsDAO<Khoahoc, String> {

    private String INSERT_SQL = "INSERT INTO KhoaHoc(MaCD,HocPhi,ThoiLuong,NgayKG,GhiChu,MaNV)"
            + " values(?,?,?,?,?,?)";
    private String UPDATE_SQL = "UPDATE KhoaHoc SET NgayKG =?,GhiChu =?,MaNV =? WHERE MaKH =?";
    private String DELETE_SQL = "DELETE FROM KhoaHoc WHERE MaKH=?";
    private String SELECT_ALL_SQL = "SELECT * FROM KhoaHoc";
    private String SELECT_BY_ID_SQL = "SELECT * FROM KhoaHoc WHERE MaKH =?";

    @Override
    public void insert(Khoahoc entity) {
        XJdbc.update(INSERT_SQL, entity.getMaCD(),
                entity.getHocPhi(), entity.getThoiLuong(), entity.getNgayKG(),
                entity.getGhiChu(), entity.getMaNV());
    }

    @Override
    public void update(Khoahoc entity) {
        XJdbc.update(UPDATE_SQL, entity.getNgayKG(),
                entity.getGhiChu(), entity.getMaNV(), entity.getMaKH());
    }

    @Override
    public void delete(String key) {
        XJdbc.update(DELETE_SQL, key);
    }

    @Override
    public List<Khoahoc> getAll() {
        List<Khoahoc> lst = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(SELECT_ALL_SQL);
            while(rs.next()){
                int maKh = rs.getInt("MaKh");
                String maCD = rs.getString("MaCD");
                float hocPhi = rs.getFloat("HocPhi");
                int thoiLuong = rs.getInt("ThoiLuong");
                Date ngayKG = rs.getDate("NgayKG");
                String ghiChu = rs.getString("GhiChu");
                String maNv= rs.getString("MaNV");
                Date ngayTao= rs.getDate("NgayTao");
                Khoahoc kh = new Khoahoc(maKh, maCD, hocPhi, thoiLuong, ngayKG, ghiChu, maNv, ngayTao);
                lst.add(kh);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return lst;
    }

    @Override
    public Khoahoc findById(String key) {
        List<Khoahoc> lst = this.getBySql(SELECT_BY_ID_SQL, key);
        if(lst.isEmpty()){
            return null;
        }
        return lst.get(0);
    }

    @Override
    public List<Khoahoc> getBySql(String sql, Object... args) {
        List<Khoahoc> lst = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql,args);
            while(rs.next()){
                int maKh = rs.getInt("MaKh");
                String maCD = rs.getString("MaCD");
                float hocPhi = rs.getFloat("HocPhi");
                int thoiLuong = rs.getInt("ThoiLuong");
                Date ngayKG = rs.getDate("NgayKG");
                String ghiChu = rs.getString("GhiChu");
                String maNv= rs.getString("MaNV");
                Date ngayTao= rs.getDate("NgayTao");
                Khoahoc kh = new Khoahoc(maKh, maCD, hocPhi, thoiLuong, ngayKG, ghiChu, maNv, ngayTao);
                lst.add(kh);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return lst;
    }
    public List<Khoahoc> selectByChuyenDe(String macd){
        String sql = "Select * from khoaHoc where MACD=?";
        return this.getBySql(sql, macd);
    }
    public List<Integer> selectYears(){
        String sql = "SELECT DISTINCT year(NGAYKG) FROM KhoaHoc ORDER BY Year(NGAYKG) DESC";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs =XJdbc.query(sql);
            while(rs.next()){
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}