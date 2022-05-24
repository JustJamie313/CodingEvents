package org.domesne.codingevents.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.Objects;

public class Event {
    private int id;
    private static int nextID = 1;
    @Size(min = 3, max = 50, message="Name must be between 3 and 50 characters.")
    @NotBlank(message = "Name is required.")
    private String name;
    @Size(max=500, message="Description maximum size is 500 characters.")
    private String description;
    @NotBlank(message="Email is required.")
    @Email(message="Invalid E-mail")
    private String contactEmail;

    @AssertTrue(message="Registration Required must be checked for all events.")
    private Boolean registrationRequired;

    @NotBlank(message="Event Location is required.")
    private String eventLocation;

    @Positive(message="Attendance Capacity must be a whole number higher than zero")
    private int attendanceCapacity;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message="Event Date cannot be a date in the past.")
    private Date eventDate;

    public Event(String name, String description, String contactEmail, String eventLocation) {
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.eventLocation = eventLocation;
        this.id = nextID;
        nextID++;
    }
    public Event(){}

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

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public Boolean getRegistrationRequired() {
        return registrationRequired;
    }

    public void setRegistrationRequired(Boolean registrationRequired) {
        this.registrationRequired = registrationRequired;
    }

    public int getAttendanceCapacity() {
        return attendanceCapacity;
    }

    public void setAttendanceCapacity(int attendanceCapacity) {
        this.attendanceCapacity = attendanceCapacity;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
