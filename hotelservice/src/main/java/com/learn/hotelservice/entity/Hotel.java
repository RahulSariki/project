package com.learn.hotelservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "hotels")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
	public class Hotel {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long hotelId;

	    private String hotelName;

	    private String city;

	    private String address;

	    private String description;

	    @Enumerated(EnumType.STRING)
	    private HotelCategory category;

	    private Long ownerId;
	}


