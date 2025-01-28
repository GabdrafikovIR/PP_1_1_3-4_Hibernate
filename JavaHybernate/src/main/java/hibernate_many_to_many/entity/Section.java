package hibernate_many_to_many.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "section")
public class Section {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;
    @Column (name = "name")
    private String name;
    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable (
            name = "child_section"
            , joinColumns = @JoinColumn(name = "section_id")
            , inverseJoinColumns = @JoinColumn (name = "child_id")
    )
    private List<Child> childs;

    public Section() {
    }

    public Section(String name) {
        this.name = name;
    }

    public void addChildToSection(Child child) {
        if (childs == null) {
            childs = new ArrayList<Child>();
        }
        childs.add(child);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Child> getChilds() {
        return childs;
    }

    public void setChilds(List<Child> childs) {
        this.childs = childs;
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", childs=" + childs +
                '}';
    }
}























