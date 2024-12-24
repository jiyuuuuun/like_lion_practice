package happyjdbc.src.main.java.jdbc;

public class DeptDTO {
    private int deptno;
    private String dname;
    private String loc;

    public DeptDTO() {
    }

    public DeptDTO(int deptno, String dname, String loc) {
        this.deptno=deptno;
        this.dname=dname;
        this.loc=loc;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "DeptDTO{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }
}
