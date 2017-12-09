package com.projest.loyalty.controllers;

import com.projest.loyalty.entity.Offer;
import com.projest.loyalty.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/demo")
public class DemoController {

    @Autowired
    private OfferRepository offerRepository;

    @GetMapping(path="/add")
    public @ResponseBody
    String addNewUser (@RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Offer offer = new Offer();
        offer.setName("Custom offer");
        offer.setDescription("Custom description");
        offer.setDiscount(12);
        offer.setPoints(120);
        offerRepository.save(offer);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Offer> getAllUsers() {
        Offer offer = new Offer();
        offer.setName("Custom offer");
        offer.setDescription("Custom description");
        offer.setDiscount(12);
        offer.setPoints(120);
        offerRepository.save(offer);
        offer = new Offer();
        offer.setName("Custom offer 2");
        offer.setDescription("Custom description 2");
        offer.setDiscount(15);
        offer.setPoints(70);
        offerRepository.save(offer);
        return offerRepository.findAll();
    }
}
