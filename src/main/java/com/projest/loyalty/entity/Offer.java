package com.projest.loyalty.entity;

import javax.persistence.*;

@Entity
@Table(name = "Offer")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private String type;
    private long discount;
    private long points;

    public Offer() { }

    public Offer(long id, String name, String description, String type, long discount, long points) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.discount = discount;
        this.points = points;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getDiscount() {
        return discount;
    }

    public void setDiscount(long discount) {
        this.discount = discount;
    }

    public long getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points = points;
    }

    private Offer(OfferBuilder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.type = builder.type;
        this.discount = builder.discount;
        this.points = builder.points;
    }

    //Builder Class
    public static class OfferBuilder {

        private String name;
        private String description;
        private String type;
        private long discount;
        private long points;

        public OfferBuilder(String name, long discount, long points) {
            this.name = name;
            this.discount = discount;
            this.points = points;
        }

        // Optional parameters
        public OfferBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public OfferBuilder setType(String type) {
            this.type = type;
            return this;
        }

        public Offer build(){
            return new Offer(this);
        }
    }
}
