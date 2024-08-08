package vn.edu.likelion.manage_book.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity extends BaseEntity{

    @Column(unique = true, nullable = false)
    private String name;

    @NonNull
    private double price;
    private int quantity;
    private boolean isDeleted;

//    @OneToOne(mappedBy = "book")
//    private BookSoldEntity bookSoldEntity;
//
//    @OneToOne(mappedBy = "book")
//    private BookAcquisitionEntity bookAcquisitionEntity;

    public BookEntity(@NonNull double price, @NonNull String name, int quantity, boolean isDeleted) {
        this.price = price;
        this.name = name;
        this.quantity = quantity;
        this.isDeleted = isDeleted;
    }
}
