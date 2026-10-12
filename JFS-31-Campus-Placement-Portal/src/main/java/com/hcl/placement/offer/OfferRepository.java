
package com.hcl.placement.offer;

import java.util.ArrayList;
import java.util.List;

public class OfferRepository {

    private List<Offer> offers = new ArrayList<>();

    public boolean addOffer(Offer offer) {
        for (Offer existing : offers) {
            if (existing.getOfferId() == offer.getOfferId()
                    || existing.getApplicationId()
                       == offer.getApplicationId()) {
                return false;
            }
        }

        offers.add(offer);
        return true;
    }

    public void displayOffers() {
        if (offers.isEmpty()) {
            System.out.println("No offers available.");
            return;
        }

        for (Offer offer : offers) {
            offer.display();
        }
    }
    public int getOfferCount() {
    return offers.size();
}
}
