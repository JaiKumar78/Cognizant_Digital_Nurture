package com.bookstore.BookstoreAPI.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Long id;
    private String title;
    
    @JsonProperty("book_author")
    private String author;
    
    @JsonIgnore
    private String isbn;
    
    private double price;

    // Optionally, you can use a method for formatting the price
    @JsonProperty("formatted_price")
    public String getFormattedPrice() {
        return String.format("%.2f", price);
    }
}
