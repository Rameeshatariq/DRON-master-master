package com.example.nimra.dron;

public class locationdetail {

    private String date;
    private String latitude;
    private String longitude;
    private String time;

    public locationdetail() {
    }

        public String getDate () {
            return date;
        }

        public void setDate (String date){
            this.date = date;
        }

        public String getLatitude () {
            return latitude;
        }

        public void setLatitude (String latitude){
            this.latitude = latitude;
        }

        public String getLongitude () {
            return longitude;
        }

        public void setLongitude (String longitude){
            this.longitude = longitude;
        }

        public String getTime () {
            return time;
        }

        public void setTime (String time){
            this.time = time;
        }
    }
