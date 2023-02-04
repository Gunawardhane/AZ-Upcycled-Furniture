package lk.ijse.upcycled.to;

public class Supplier {

    private String supplierID;
    private String supplierName;
    private String supplierAddress;
    private String supplierPhoneNumber;


    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierPhoneNumber() {
        return supplierPhoneNumber;
    }

    public void setSupplierPhoneNumber(String supplierPhoneNumber) {
        this.supplierPhoneNumber = supplierPhoneNumber;
    }



    public Supplier() {
    }

    public Supplier(String supplierID, String supplierName, String supplierAddress, String supplierPhoneNumber) {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
        this.supplierPhoneNumber = supplierPhoneNumber;
    }

    }

