package ru.job4j.serialization.json;

public class Document {

    private String type;
    private String series;
    private String number;

    public String getType() {
        return type;
    }

    public String getSeries() {
        return series;
    }

    public String getNumber() {
        return number;
    }

    public Document(String type, String series, String number) {
        this.type = type;
        this.series = series;
        this.number = number;
    }


    @Override
    public String toString() {
        return "Document{"
                + "type='" + type + '\''
                + ", series='" + series + '\''
                + ", number='" + number + '\''
                + '}';
    }
}
