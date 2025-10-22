package com.cvbuilder.auth.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user-seq")
    @SequenceGenerator(name="user-seq",sequenceName = "user-sequence",allocationSize = 1)
    private Long id;
    private String username;
    private String email;
    private String password;
}


//brew install postgresql (install postgresql)
//brew services start postgresql (created default db)
//psql -l (list created dbs)
//brew services start postgresql (start db)

