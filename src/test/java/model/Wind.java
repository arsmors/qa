package model;

import java.math.BigDecimal;

public class Wind {
    private BigDecimal speed;
    private Double deg;

    public BigDecimal getSpeed() {
        return speed;
    }

    public Double getDeg() {
        return deg;
    }

    public void setDeg(Double deg) {
        this.deg = deg;
    }

    public void setSpeed(BigDecimal speed) {
        this.speed = speed;
    }
}
