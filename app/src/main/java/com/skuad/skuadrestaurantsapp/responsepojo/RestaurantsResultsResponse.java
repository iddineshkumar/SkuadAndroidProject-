package com.skuad.skuadrestaurantsapp.responsepojo;

import java.util.List;

public class RestaurantsResultsResponse {

    private List<ResultsBean> results;


    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;

    }

    public static class ResultsBean   {
        /**
         * formatted_address : 15 Bligh St, Sydney NSW 2000, Australia
         * icon : https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png
         * id : 6ce174f01df4ca27056af7f5c4c6db681e8a6a0d
         * name : Restaurant Hubert
         * opening_hours : {"open_now":true}
         * place_id : ChIJF5-RdGquEmsR5rN_H74uSqQ
         * plus_code : {"compound_code":"46M6+X4 Sydney, New South Wales, Australia","global_code":"4RRH46M6+X4"}
         * price_level : 3
         * rating : 4.6
         * reference : ChIJF5-RdGquEmsR5rN_H74uSqQ
         * types : ["restaurant","food","point_of_interest","establishment"]
         * user_ratings_total : 1217
         */

        private String formatted_address;
        private String icon;
        private String id;
        private String name;
        private OpeningHoursBean opening_hours;
        private String place_id;
        private PlusCodeBean plus_code;
        private int price_level;
        private double rating;
        private String reference;
        private int user_ratings_total;
        private List<String> types;


        public String getFormatted_address() {
            return formatted_address;
        }

        public void setFormatted_address(String formatted_address) {
            this.formatted_address = formatted_address;

        }


        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;

        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;

        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public OpeningHoursBean getOpening_hours() {
            return opening_hours;
        }

        public void setOpening_hours(OpeningHoursBean opening_hours) {
            this.opening_hours = opening_hours;
        }

        public String getPlace_id() {
            return place_id;
        }

        public void setPlace_id(String place_id) {
            this.place_id = place_id;
        }

        public PlusCodeBean getPlus_code() {
            return plus_code;
        }

        public void setPlus_code(PlusCodeBean plus_code) {
            this.plus_code = plus_code;
        }

        public int getPrice_level() {
            return price_level;
        }

        public void setPrice_level(int price_level) {
            this.price_level = price_level;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        public String getReference() {
            return reference;
        }

        public void setReference(String reference) {
            this.reference = reference;
        }

        public int getUser_ratings_total() {
            return user_ratings_total;
        }

        public void setUser_ratings_total(int user_ratings_total) {
            this.user_ratings_total = user_ratings_total;
        }


        public List<String> getTypes() {
            return types;
        }

        public void setTypes(List<String> types) {
            this.types = types;
        }

        public static class OpeningHoursBean  {
            /**
             * open_now : true
             */

            private boolean open_now;


            public boolean isOpen_now() {
                return open_now;
            }

            public void setOpen_now(boolean open_now) {
                this.open_now = open_now;

            }
        }

        public static class PlusCodeBean  {
            /**
             * compound_code : 46M6+X4 Sydney, New South Wales, Australia
             * global_code : 4RRH46M6+X4
             */

            private String compound_code;
            private String global_code;


            public String getCompound_code() {
                return compound_code;
            }

            public void setCompound_code(String compound_code) {
                this.compound_code = compound_code;

            }


            public String getGlobal_code() {
                return global_code;
            }

            public void setGlobal_code(String global_code) {
                this.global_code = global_code;

            }
        }
    }
}
