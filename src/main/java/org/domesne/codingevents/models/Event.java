package org.domesne.codingevents.models;

import javax.validation.constraints.*;
import java.util.Objects;

public class Event {
    private int id;
    private static int nextID = 1;
    @Size(min = 3, max = 50, message="Name must be between 3 and 50 characters")
    @NotBlank(message = "Name cannot be blank")
    private String name;
    @Size(max=500, message="Description Too Long")
    private String description;
    @Email(message="Invalid E-mail")
    private String contactEmail;

    public Event(String name, String description, String contactEmail) {
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.id = nextID;
        nextID++;
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

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
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
