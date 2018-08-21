package model;

public class Message {
    private Long id;
    private boolean is_event;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isIs_event() {
        return is_event;
    }

    public void setIs_event(boolean is_event) {
        this.is_event = is_event;
    }
}
