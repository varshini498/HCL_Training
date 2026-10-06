package com.hcl.placement.placement;

import java.util.ArrayList;
import java.util.List;

public class OfferRepository {

    private List<Offer> offers = new ArrayList<>();

    public void save(Offer offer) {
        offers.add(offer);
    }

    public Offer findByOfferId(long offerId) {

        for (Offer offer : offers) {

            if (offer.getOfferId() == offerId) {
                return offer;
            }
        }

        return null;
    }

    public Offer findByStudentId(long studentId) {

        for (Offer offer : offers) {

            if (offer.getStudentId() == studentId) {
                return offer;
            }
        }

        return null;
    }
}