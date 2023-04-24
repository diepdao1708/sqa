package controller;

import java.io.Serializable;
import java.util.Objects;

public class RegisterData implements Serializable {

    Integer status;
    String message;

    public RegisterData() {
    }

    public RegisterData(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.status);
        hash = 17 * hash + Objects.hashCode(this.message);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RegisterData other = (RegisterData) obj;
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        return Objects.equals(this.status, other.status);
    }

}
