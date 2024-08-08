package vn.edu.likelion.manage_book.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book_sold")
public class BookSoldEntity extends BaseEntity {

    private int quantity;

    private  int bookId;
}
