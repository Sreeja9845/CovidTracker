package com.example.covid.spring.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
public class Patient 
{
	@Id
private int patientId;
private String patientName;
private int patientAge;
@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
private LocalDate firstConsultaionDate;
@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
private LocalDate lastConsultaionDate;
private String patientDisease;

public Patient(int patientId , String patientName ,int patientAge,LocalDate firstConsultaionDate,LocalDate lastConsultaionDate,String patientDisease)
{
		this.patientId= patientId;
		this.patientName=patientName;
		this.patientAge=patientAge;
		this.firstConsultaionDate=firstConsultaionDate;
		this.lastConsultaionDate=lastConsultaionDate;
		this.patientDisease=patientDisease;
		
	}

}
