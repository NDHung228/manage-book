package vn.edu.likelion.manage_book.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "book_acquisition")
@NoArgsConstructor
@AllArgsConstructor
public class BookAcquisitionEntity extends BaseEntity {

    private int quantity;

    private  int bookId;


}
