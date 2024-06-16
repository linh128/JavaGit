/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4.bai2;

/**
 *
 * @author Administrator
 */
public class LopHoc {
    public String tenLop;
    public int siSo;
    public int khoi;

    @Override
    public String toString() {
        return "LopHoc{" + "tenLop=" + tenLop + ", siSo=" + siSo + ", khoi=" + khoi + '}';
    }
    
    

    public LopHoc() {
    }

    public LopHoc(String tenLop, int siSo, int khoi) {
        this.tenLop = tenLop;
        this.siSo = siSo;
        this.khoi = khoi;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public int getSiSo() {
        return siSo;
    }

    public void setSiSo(int siSo) {
        this.siSo = siSo;
    }

    public int getKhoi() {
        return khoi;
    }

    public void setKhoi(int khoi) {
        this.khoi = khoi;
    }
    
    
}
