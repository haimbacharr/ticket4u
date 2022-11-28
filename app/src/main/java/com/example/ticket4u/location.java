package com.example.ticket4u;

public class location {
    Number row;
    Number seat;
    String rowString;
    String seatString;

    public location(Number row, Number seat) {
        this.row = row;
        this.seat = seat;
    }

    public Number getRow() {
        return row;
    }

    public void setRow(Number row) {
        this.row = row;
    }

    public Number getSeat() {
        return seat;
    }

    public void setSeat(Number seat) {
        this.seat = seat;
    }

    public String getRowString() {
        return rowString;
    }

    public void setRowString(String rowString) {
        this.rowString = rowString;
    }

    public String getSeatString() {
        return seatString;
    }

    public void setSeatString(String seatString) {
        this.seatString = seatString;
    }

    @Override
    public String toString() {
        return "location{" +
                "row=" + row +
                ", seat=" + seat +
                ", rowString='" + rowString + '\'' +
                ", seatString='" + seatString + '\'' +
                '}';
    }
}
