package webspace.demo.user;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Table
public class User {


    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )

    private Long id;
    private String name;
    private String email;
    private String password;

    //@OneToOne(cascade=CascadeType.PERSIST) <or> @OneToOne(cascade=CascadeType.ALL) <-- for all operation
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "source", referencedColumnName = "id")
    public List<Source> sources;

    private String preferedStyle;


    public User(
            Long id,
            String name,
            String email,
            String password,
            String preferedStyle
            //Source[] source
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.preferedStyle = preferedStyle;
        //this.sources = source;
    }

    public User(
            String name,
            String email,
            String password,
            String preferedStyle,
            List<Source> source
    ) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.preferedStyle = preferedStyle;
        this.sources = source;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPreferedStyle() {return preferedStyle;}

    public List<Source> getSources() {
        return sources;
    }
}
