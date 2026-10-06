package com.hcl.placement.placement;

public class OfferService {

    private OfferRepository offerRepository;

    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public boolean recordOffer(Offer offer) {

        if (offer == null) {
            return false;
        }

        Offer existingOffer =
                offerRepository.findByOfferId(
                        offer.getOfferId()
                );

        if (existingOffer != null) {
            return false;
        }

        Offer studentOffer =
                offerRepository.findByStudentId(
                        offer.getStudentId()
                );

        if (studentOffer != null) {
            return false;
        }

        offerRepository.save(offer);

        return true;
    }

    public Offer getStudentOffer(long studentId) {

        return offerRepository.findByStudentId(studentId);
    }
}