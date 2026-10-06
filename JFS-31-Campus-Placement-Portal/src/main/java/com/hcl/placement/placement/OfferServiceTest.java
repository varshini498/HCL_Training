package com.hcl.placement.placement;

public class OfferServiceTest {

    public static void main(String[] args) {

        OfferRepository offerRepository =
                new OfferRepository();

        OfferService offerService =
                new OfferService(offerRepository);

        Offer firstOffer = new Offer(
                9001L,
                2001L,
                4001L,
                5001L,
                "REGULAR",
                6.0
        );

        boolean firstOfferResult =
                offerService.recordOffer(firstOffer);

        System.out.println(
                "First offer recorded: "
                        + firstOfferResult
        );

        Offer secondOffer = new Offer(
                9002L,
                2001L,
                4002L,
                5002L,
                "DREAM",
                10.0
        );

        boolean secondOfferResult =
                offerService.recordOffer(secondOffer);

        System.out.println(
                "Second offer recorded: "
                        + secondOfferResult
        );

        Offer studentOffer =
                offerService.getStudentOffer(2001L);

        if (studentOffer != null) {

            System.out.println("\nStudent Offer:");

            studentOffer.displayOffer();
        }
    }
}