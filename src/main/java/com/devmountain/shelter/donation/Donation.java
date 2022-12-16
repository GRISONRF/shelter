package com.devmountain.shelter.donation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "donations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column
    public String donation;

    @Column
    public String when;

    @Column
    public String name;

    @Column
    public Integer phone;

    public Donation(DonationDto donationDto){

        if (donationDto.getDonation() != null) {
            this.donation = donationDto.getDonation();
        }
        if (donationDto.getWhen() != null) {
            this.when = donationDto.getWhen();
        }
        if (donationDto.getName() != null) {
            this.name = donationDto.getName();
        }
        if (donationDto.getPhone() != null) {
            this.phone = donationDto.getPhone();
        }
    }
}
