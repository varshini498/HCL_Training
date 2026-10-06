package com.hcl.placement.placement;

public class Offer {

    private long offerId;
    private long studentId;
    private long companyId;
    private long driveId;
    private String offerType;
    private double packageLpa;

    public Offer(long offerId,
                 long studentId,
                 long companyId,
                 long driveId,
                 String offerType,
                 double packageLpa) {

        this.offerId = offerId;
        this.studentId = studentId;
        this.companyId = companyId;
        this.driveId = driveId;
        this.offerType = offerType;
        this.packageLpa = packageLpa;
    }

    public long getOfferId() {
        return offerId;
    }

    public long getStudentId() {
        return studentId;
    }

    public long getCompanyId() {
        return companyId;
    }

    public long getDriveId() {
        return driveId;
    }

    public String getOfferType() {
        return offerType;
    }

    public double getPackageLpa() {
        return packageLpa;
    }

    public void displayOffer() {

        System.out.println("Offer ID: " + offerId);
        System.out.println("Student ID: " + studentId);
        System.out.println("Company ID: " + companyId);
        System.out.println("Drive ID: " + driveId);
        System.out.println("Offer Type: " + offerType);
        System.out.println("Package: " + packageLpa + " LPA");
    }
}