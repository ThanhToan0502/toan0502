package vn.edu.stu.sqlite;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Sach {
    @PrimaryKey
    private int ma;
    private String ten;
    private String tacgia;
    private  int namxb;

    public Sach(int ma, String ten, String tacgia, int namxb) {
        this.ma = ma;
        this.ten = ten;
        this.tacgia = tacgia;
        this.namxb = namxb;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public int getNamxb() {
        return namxb;
    }

    public void setNamxb(int namxb) {
        this.namxb = namxb;
    }

    @Override
    public String toString() {
        return "Mã:         " + ma +
                "\nTên:     " + ten +
                "\nTác giả: " + tacgia +
                "\nNăm XB:  " + namxb ;
    }
}
