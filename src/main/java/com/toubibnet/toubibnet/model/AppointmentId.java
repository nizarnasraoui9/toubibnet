package com.toubibnet.toubibnet.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AppointmentId implements Serializable {
    @Column(name="user_id")
    Long userId;
    @Column(name="doctor_id")
    Long doctorId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppointmentId that = (AppointmentId) o;
        return Objects.equals(doctorId, that.doctorId) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctorId, userId);
    }
}
