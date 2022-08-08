package ru.home.preparado.dto;

public class BooleanDTO {

    private boolean exist;

    public BooleanDTO(boolean exist) {
        this.exist = exist;
    }

    public BooleanDTO() {
    }

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    @Override
    public String toString() {
        return "BooleanDTO{" +
                "exist=" + exist +
                '}';
    }
}
