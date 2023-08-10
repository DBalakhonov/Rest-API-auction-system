package org.example.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateLot {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        @NotBlank
        @Size (min = 3, max= 64)
        private String title;
        @NotBlank
        @Size(min = 1,max = 4096)
        private String description;
        @NotNull
        @Min(1)
        private Integer startPrice;
        @NotNull
        @Min(1)
        private Integer bidPrice;

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public void setStartPrice(Integer startPrice) {
                this.startPrice = startPrice;
        }

        public void setBidPrice(Integer bidPrice) {
                this.bidPrice = bidPrice;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public int getStartPrice() {
                return startPrice;
        }

        public void setStartPrice(int startPrice) {
                this.startPrice = startPrice;
        }

        public int getBidPrice() {
                return bidPrice;
        }

        public void setBidPrice(int bidPrice) {
                this.bidPrice = bidPrice;
        }
}
