package com.devmountain.shelter.donation;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationDto implements Serializable {

    public Long id;
    public String donation;
    public String when;
    public String name;
    public Integer phone;

    public DonationDto (Donation donation) {

        if (donation.getId() != null){
            this.id = donation.getId();
        }
        if (donation.getDonation() != null){
            this.donation = donation.getDonation();
        }
        if (donation.getWhen() != null){
            this.when = donation.getWhen();
        }
        if (donation.getName() != null){
            this.name = donation.getName();
        }
        if (donation.getPhone() != null){
            this.phone = donation.getPhone();
        }
    }
}

